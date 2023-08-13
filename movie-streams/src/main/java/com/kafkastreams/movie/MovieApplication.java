package com.kafkastreams.movie;

import com.google.common.primitives.Chars;
import com.kafkastreams.movie.commons.avro.*;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.var;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovieApplication {


	public static String MOVIES_INPUT="postgresql.tenflix.movies";
	public static String CATEGORY_INPUT="postgresql.tenflix.categories";

//    public static String TAG_INPUT="tags";

	public static String VIDEO_INPUT="postgresql.tenflix.videos";

	public static String CREATOR_INPUT="postgresql.tenflix.creators";

	public static String ACTOR_INPUT="postgresql.tenflix.actors";


	public static String MOVIE_ACTOR_INPUT= "postgresql.tenflix.movie_actor";

	public static String MOVIE_CREATOR_INPUT = "postgresql.tenflix.movie_creator";

	public static String MOVIE_CATEGORY_INPUT = "postgresql.tenflix.movie_category";

//    public static String MOVIE_TAG_INPUT= "postgresql.tenflix.movie_tag";

	public static String MOVIES_OUTPUT="movies-output";
	public static final String SCHEMA_REGISTRY_URL = "http://localhost:8081";


	public Topology createMovieTopology(){
		StreamsBuilder builder = new StreamsBuilder();

		final Map<String, String> serdeConfig =
				Collections.singletonMap(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,
						SCHEMA_REGISTRY_URL);

		final SpecificAvroSerde<MovieElasticSearch> movieEsSerde = new SpecificAvroSerde<>();
		movieEsSerde.configure(serdeConfig, false);
		final SpecificAvroSerde<MovieVideoJoined> movieVideoJoinedSerde = new SpecificAvroSerde<>();
		movieVideoJoinedSerde.configure(serdeConfig, false);

//		movie output ada schemanya

		KTable<String, Movie> movieTable= builder.table(MOVIES_INPUT);
		KTable<String, Category> categoryTable = builder.table(CATEGORY_INPUT);
		KTable<String, Video> videoTable = builder.table(VIDEO_INPUT);
		KTable<String, Creator> creatorTable = builder.table(CREATOR_INPUT);
		KTable<String, Actor> actorTable = builder.table(ACTOR_INPUT);
		KTable<String, MovieActor> movieActorTable =builder.table(MOVIE_ACTOR_INPUT);
		KTable<String, MovieCreator> movieCreatorTable = builder.table(MOVIE_CREATOR_INPUT);
		KTable<String, MovieCategory> movieCategoryTable = builder.table(MOVIE_CATEGORY_INPUT);

		var stringSerde = Serdes.String();


		categoryTable.toStream().peek((key, value)->
				System.out.println("(category) record: "+ key+ " value: " + value ));

		videoTable.toStream().peek((key, value)->
				System.out.println("(video) record: "+ key+ " value: " + value ));

		creatorTable.toStream().peek((key, value)->
				System.out.println("(creator) record: "+ key+ " value: " + value ));

		actorTable.toStream().peek((key, value)->
				System.out.println("(actor) record: "+ key+ " value: " + value ));

		movieActorTable.toStream().peek((key, value)->
				System.out.println("(movieactor) record: "+ key+ " value: " + value ));

		movieCreatorTable.toStream().peek((key, value)->
				System.out.println("(moviecreator) record: "+ key+ " value: " + value ));

		movieCategoryTable.toStream().peek((key, value)->
				System.out.println("(moviecategory) record: "+ key+ " value: " + value ));

		movieTable.toStream().peek((key, value)->
				System.out.println("(movie) record: "+ key+ " value: " + value ));

		var movieWithCategoryIdSerde = new SpecificAvroSerde<MovieWithCategoryId>();
		var movieCategoryJoinedSerde = new SpecificAvroSerde< MovieCategoryJoined>();


//		error disini, state store movies, berubah jadi avro.java.lang: String
		var movieCategoryJoined = movieTable.join(
				movieCategoryTable,
				this::toMovieWithMovieCategoryId
		);

		movieCategoryJoined.toStream()
				.peek((key, value)->
						System.out.println("(movieWithCategoryId) record: "+ key+ " value: " + value ))
		;


		var movieWithCategoryJoined = movieCategoryJoined.join(
				categoryTable,
				(movieWithCategoryId )->movieWithCategoryId.getCategoryId().toString(),
				this::toMovieCategoryJoined
		);
		movieWithCategoryJoined.toStream().peek((key, value)->
				System.out.println("(movieCategoryJoined) record: "+ key+ " value: " + value ));


//		key= movieId, val = movie, categoryName
		var movieCategoryEs = movieWithCategoryJoined.groupBy((KeyValue::pair))
				.aggregate(
						()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), ""),
						(key, newVal, aggVal) -> addCategory(newVal, aggVal),
						(key, newVal, aggVal) -> aggVal
				);


		movieCategoryEs.toStream().peek((key, value)->
						System.out.println("(movieElasticsearch) key: "+ key+ " value: " + value ));




//		tidak ada movieelasticsearch yg key = 1? ktable movieEs belum ada? movieEs send to new topic


		var movievideoJoined = videoTable.join(
				movieCategoryEs,
				(videoVal) -> String.valueOf( videoVal.getMovieId()),
				this::toMovieVideo
		);
		movievideoJoined.toStream().peek((key, value)->
				System.out.println("(movieVideoJoined) key: "+ key+ " value: " + value ));

		var movieVideo = movievideoJoined.groupBy(((key, value) -> KeyValue.pair( String.valueOf(value.getMovieId()), value)))
				.aggregate(
						()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), ""),
						(key, newVal, aggVal) -> addVideo(newVal, aggVal),
						(key, newVal, aggVal) -> aggVal
				);
		movieVideo.toStream().peek((key, value)->
				System.out.println("(movieVideo) key: "+ key+ " value: " + value ));


//		movieTable.toStream().to(MOVIES_OUTPUT);

		return builder.build();

	}


	private MovieElasticSearch addVideo(MovieVideoJoined movieVideoJoined, MovieElasticSearch movie){

		List<CharSequence> videoUrl = movie.getUrl();
		videoUrl.add(movieVideoJoined.getVideoUrl());
		movie.setTitle(movieVideoJoined.getName());movie.setGenre(movieVideoJoined.getGenre().stream().map(String::toString).collect(Collectors.toList()));
		movie.setSynopsis(movieVideoJoined.getSynopsis());movie.setReleaseYear(movieVideoJoined.getReleaseYear());
		movie.setImage(movieVideoJoined.getImage());movie.setRating(movieVideoJoined.getRating());
		movie.setMovieId(String.valueOf(movieVideoJoined.getMovieId()));
		movie.setUrl(videoUrl);
		return movie;
	}

	private MovieVideoJoined toMovieVideo( Video video, MovieElasticSearch movie){
		List<String> genres = new ArrayList<>();
		if (Objects.isNull(movie)){
			return new MovieVideoJoined();
		}
		System.out.println("testes join movieEs & video: " + video);
		System.out.println("testes join movieEs: " + movie);
		movie.getGenre().forEach(
				(genre) -> genres.add(genre.toString())

		);

		MovieVideoJoined movieVideoJoined = MovieVideoJoined.newBuilder().setVideoUrl(video.getUrl().toString())
				.setMovieId(Integer.parseInt( movie.getMovieId().toString())).setName(movie.getTitle().toString())
				.setGenre(genres)
				.setSynopsis(movie.getSynopsis().toString()).setReleaseYear(movie.getReleaseYear())
				.setImage(movie.getImage().toString()).setRating(movie.getRating())
				.setDirector(movie.getDirector().stream().map(CharSequence::toString).collect(Collectors.toList()))
				.setCast(movie.getCast().stream().map(CharSequence::toString).collect(Collectors.toList()))
				.build();

		return movieVideoJoined;
	}

	private MovieElasticSearch addCategory(MovieCategoryJoined movieCategoryJoined, MovieElasticSearch movieElasticSearch){
		List<CharSequence> genre = movieElasticSearch.getGenre();
		genre.add(movieCategoryJoined.getCategoryName());
		MovieCategoryJoined movie = movieCategoryJoined;
		CharSequence cs = String.valueOf(movieCategoryJoined.getMovieId());
		List<CharSequence> directors = new ArrayList<>();
		directors.add("");
		MovieElasticSearch m = MovieElasticSearch.newBuilder()
				.setTitle(movie.getName()).setImage(movie.getImage())
				.setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getRYear())
				.setRating(movie.getIdmbRating())
				.setGenre(genre)
				.setMovieId(cs)
				.setDirector(directors).setCast(directors).setUrl(directors)

				.build();
		return m;
	}

	private MovieCategoryJoined toMovieCategoryJoined(MovieWithCategoryId movieCategory, Category category){
		MovieWithCategoryId movie = movieCategory;
		MovieCategoryJoined c= MovieCategoryJoined.newBuilder()
				.setCategoryName(category.getName())
				.setMovieId(movie.getMovieid()).setName(movie.getName())
				.setCreatedOn(movie.getCreatedOn()).setType(movie.getType())
				.setSynopsis(movie.getSynopsis()).setMpaRating(movie.getMpaRating())
				.setImage(movie.getImage()).setRYear(movie.getRYear())
				.setNotification(movie.getNotification()).setIdmbRating(movie.getIdmbRating())
				.build();


		return c;
	}


	private MovieWithCategoryId toMovieWithMovieCategoryId(Movie movie, MovieCategory movieCategory){

		MovieWithCategoryId  m = MovieWithCategoryId.newBuilder()
				.setMovieid(movie.getId()).setName(movie.getName())
				.setCreatedOn(movie.getCreatedOn()).setType(movie.getType())
				.setSynopsis(movie.getSynopsis()).setMpaRating(movie.getMpaRating())
				.setImage(movie.getImage()).setRYear(movie.getRYear())
				.setNotification(movie.getNotification()).setIdmbRating(movie.getIdmbRating())
				.setCategoryId(String.valueOf(movieCategory.getCategoryId()))
				.build();
		return m;
	}


	public Topology createTopology(){
		StreamsBuilder builder = new StreamsBuilder();
		// 1 - stream from Kafka

		KStream<String, String> textLines = builder.stream("word-count-input");
		KTable<String, Long> wordCounts = textLines
				// 2 - map values to lowercase
				.mapValues(textLine -> textLine.toLowerCase())
				// can be alternatively written as:
				// .mapValues(String::toLowerCase)
				// 3 - flatmap values split by space
				.flatMapValues(textLine -> Arrays.asList(textLine.split("\\W+")))
				// 4 - select key to apply a key (we discard the old key)
				.selectKey((key, word) -> word)
				// 5 - group by key before aggregation
				.groupByKey()
				// 6 - count occurences
				.count(Materialized.as("Counts"));


		wordCounts.toStream().peek((key, value)->
				System.out.println("record: "+ key+ " value: " + value )
		);
		// 7 - to in order to write the results back to kafka
		wordCounts.toStream().to("word-count-output", Produced.with(Serdes.String(), Serdes.Long()));

		return builder.build();
	}

	public static void main(String[] args) {
		Properties config = new Properties();
		config.put(StreamsConfig.APPLICATION_ID_CONFIG, "movies-application");
		config.put(StreamsConfig.CLIENT_ID_CONFIG, "movies-avro-lambda-example-client");

		config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//		config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

		config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
		config.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
		config.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kafka-streams");
		config.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,  1000);

//		config.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, false);

		MovieApplication wordCountApp = new MovieApplication();

		KafkaStreams streams = new KafkaStreams(wordCountApp.createMovieTopology(), config);
		streams.cleanUp();
		streams.start();

		// shutdown hook to correctly close the streams application
		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

		// Update:
		// print the topology every 10 seconds for learning purposes

//		while(true){
//			streams.localThreadsMetadata().forEach(data -> System.out.println(data));
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				break;
//			}
//		}


	}
}






