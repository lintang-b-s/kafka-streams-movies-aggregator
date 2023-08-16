package com.kafkastreams.movie;

import com.kafkastreams.movie.commons.avro.*;
import com.kafkastreams.movie.commons.avro.MovieElasticSearch;
import com.kafkastreams.movie.model.*;
import com.kafkastreams.movie.model.Actor;
import com.kafkastreams.movie.model.Category;
import com.kafkastreams.movie.model.Creator;
import com.kafkastreams.movie.model.Movie;
import com.kafkastreams.movie.model.MovieActor;
import com.kafkastreams.movie.model.MovieActorKey;
import com.kafkastreams.movie.model.MovieCategory;
import com.kafkastreams.movie.model.MovieCategoryKey;
import com.kafkastreams.movie.model.MovieCreator;
import com.kafkastreams.movie.model.MovieCreatorKey;
import com.kafkastreams.movie.model.Video;
import com.kafkastreams.movie.serdes.CustomIdSerde;
import com.kafkastreams.movie.serdes.SerdeFactory;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import io.debezium.serde.json.JsonSerde;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class MovieApplication {

//    local
//    private static String schemaRegistry = "http://127.0.0.1:8081";
//
//    private static  String kafkaBootstrapServer = "localhost:29092";
////
//    //    docker
    private static String schemaRegistry = "http://schema-registry:8081";
    private static  String kafkaBootstrapServer = "kafka:9092";


    public static String MOVIES_INPUT="postgresql.public.movies";
    public static String CATEGORY_INPUT="postgresql.public.categories";

//    public static String TAG_INPUT="tags";

    public static String VIDEO_INPUT="postgresql.public.videos";

    public static String CREATOR_INPUT="postgresql.public.creators";

    public static String ACTOR_INPUT="postgresql.public.actors";


    public static String MOVIE_ACTOR_INPUT= "postgresql.public.movie_actor";

    public static String MOVIE_CREATOR_INPUT = "postgresql.public.movie_creator";

    public static String MOVIE_CATEGORY_INPUT = "postgresql.public.movie_category";

//    public static String MOVIE_TAG_INPUT= "postgresql.public.movie_tag";

    public static String MOVIES_OUTPUT="movieswiki";
    public static final String SCHEMA_REGISTRY_URL = "http://127.0.0.1:8081";


    public Topology createMovieTopology(){
        StreamsBuilder builder = new StreamsBuilder();
        // with 3.0 (or with 2.10 as alternative)

        final Map<String, String> serdeConfig =
                Collections.singletonMap(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,
                        schemaRegistry);

        final SpecificAvroSerde<MovieElasticSearch> movieEsSerde = new SpecificAvroSerde<>();
        movieEsSerde.configure(serdeConfig, false);
        final SpecificAvroSerde<MovieVideoJoined> movieVideoJoinedSerde = new SpecificAvroSerde<>();
        movieVideoJoinedSerde.configure(serdeConfig, false);
        final SpecificAvroSerde<MovieWithCreatorJoined> movieWithCreatorJoinedSpecificAvroSerde = new SpecificAvroSerde<>();
        movieWithCreatorJoinedSpecificAvroSerde.configure(serdeConfig, false);
        final SpecificAvroSerde<MovieWithCreatorId> movieWithCreatorIdSpecificAvroSerde = new SpecificAvroSerde<>();
        movieWithCreatorIdSpecificAvroSerde.configure(serdeConfig, false);
        final SpecificAvroSerde<MovieWithActorId> movieWithActorIdSpecificAvroSerde =  new SpecificAvroSerde<>();
        movieWithActorIdSpecificAvroSerde.configure(serdeConfig, false);
        final SpecificAvroSerde< MovieWithActorJoined> movieWithActorJoinedSpecificAvroSerde = new SpecificAvroSerde<>();
        movieWithActorJoinedSpecificAvroSerde.configure(serdeConfig, false);


// tidak bisa

        final Serde<Integer> integerSerde =  SerdeFactory.createDbzEventJsonPojoSerdeFor(Integer.class,true);

        final Serde<DefaultId> defaultIdSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(DefaultId.class,true);
        final Serde<Movie> movieSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(Movie.class,false);
        final Serde<Video> videoSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(Video.class,false);
        final Serde<Actor> actorSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(Actor.class,false);
        final Serde<Category> categorySerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(Category.class,false);
        final Serde<Creator> creatorSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(Creator.class,false);
        final Serde<MovieActor> movieActorSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieActor.class,false);
        final Serde<MovieCategory> movieCategorySerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieCategory.class,false);
        final Serde<MovieCreator> movieCreatorSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieCreator.class,false);
        final Serde<MovieActorKey> movieActorKeySerde =  SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieActorKey.class,false);
        final Serde<MovieCreatorKey> movieCreatorKeySerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieCreatorKey.class,false);
        final Serde<MovieCategoryKey> movieCategoryKeySerde =  SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieCategoryKey.class,false);
        final Serde<MovieWithCategoryId> movieWithCategoryIdSerde =  SerdeFactory.createDbzEventJsonPojoSerdeFor(MovieWithCategoryId.class,false);
        final Serde<JsonSerde> jsonSerdeSerde = SerdeFactory.createDbzEventJsonPojoSerdeFor(JsonSerde.class,false);

//		movie output ada schemanya

        KTable<DefaultId, Movie> movieTable= builder.table(MOVIES_INPUT, Consumed.with(defaultIdSerde, movieSerde));
        KTable<DefaultId, Category> categoryTable = builder.table(CATEGORY_INPUT, Consumed.with(defaultIdSerde, categorySerde));
        KTable<DefaultId, Video> videoTable = builder.table(VIDEO_INPUT , Consumed.with(defaultIdSerde, videoSerde));
        KTable<DefaultId, Creator> creatorTable = builder.table(CREATOR_INPUT , Consumed.with(defaultIdSerde, creatorSerde));
        KTable<DefaultId, Actor> actorTable = builder.table(ACTOR_INPUT , Consumed.with(defaultIdSerde, actorSerde));

        KTable<MovieActorKey, MovieActor> movieActorTable =builder.table(MOVIE_ACTOR_INPUT, Consumed.with(movieActorKeySerde, movieActorSerde));
        KTable<MovieCreatorKey, MovieCreator> movieCreatorTable = builder.table(MOVIE_CREATOR_INPUT, Consumed.with(movieCreatorKeySerde, movieCreatorSerde));
        KTable<MovieCategoryKey, MovieCategory> movieCategoryTable = builder.table(MOVIE_CATEGORY_INPUT,  Consumed.with(movieCategoryKeySerde, movieCategorySerde));


        var stringSerde = Serdes.String();
//
//
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
        {
            System.out.println("(moviecategory) record: " + key + " value: " + value);
        });


        final boolean[] isDeleted = {false};
        movieTable.toStream().peek((key, value)->
                {
                    System.out.println("(movie) record: "+ key+ " value: " + value );

                    if (Objects.isNull(value)){
                        isDeleted[0] = true;
                    }
                }
                );

        if (isDeleted[0] == true){

            movieTable.mapValues(
//                  val-> new MovieElasticSearch(null, null, null, null, null,null, null, null, null, null)
                    val -> null
            ).toStream().map((key,value) -> KeyValue.pair(String.valueOf(key), value)).to(MOVIES_OUTPUT);
        }
//		var movieWithCategoryIdSerde = new SpecificAvroSerde<MovieWithCategoryId>();
//		var movieCategoryJoinedSerde = new SpecificAvroSerde< MovieCategoryJoined>();

         var movieCreatorStream = movieCreatorTable.toStream().map(((key, value) -> KeyValue.pair(key.getMovieid(), value)));
        var movieActorStream = movieActorTable.toStream().map(((key, value) -> KeyValue.pair(key.getMovieid(), value)));

        var movieCategoryId = movieCategoryTable.join(
                movieTable,
                (movieCategoryVal) -> new DefaultId( movieCategoryVal.getMovieId()),
                this::toMovieWithMovieCategoryId
        );

        movieCategoryId.toStream()
                .peek((key, value)->
                        System.out.println("(movieWithCategoryId) record: key: "+ key+ " value: " + value ));

        var movieWithCategoryJoined = movieCategoryId.join(
                categoryTable,
                (movieCategoryIdVal) -> new DefaultId(movieCategoryIdVal.getCategoryId()),
                this::toMovieCategoryJoined
        );

        movieWithCategoryJoined.toStream()
                .peek((key, value)->
                        System.out.println("(movieWithCategoryJoined) record: "+ key+ " value: " + value ));


        var movieCategoryEs = movieWithCategoryJoined.groupBy((key, value) -> KeyValue.pair(String.valueOf(key.getMovieid()), value))
                .aggregate(
                        ()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0),
                        (key, newVal, aggVal) -> addCategory(newVal, aggVal),
                        (key, newVal, aggVal) -> aggVal,
                        Materialized.<String, MovieElasticSearch, KeyValueStore<Bytes, byte[]>>as("category-movie") /* state store name */
                                .withValueSerde(movieEsSerde)
                );

        movieCategoryEs.toStream().peek((key, value)->
                System.out.println("(movieElasticsearchCategory) key: "+ key+ " value: " + value ));



//        movie yang gak ada video
        var movieWithoutVideo = movieCategoryEs.mapValues(value ->
                {
                    value.setUrl(new ArrayList<>());
                    return value;
                }
              );

        movieWithoutVideo.toStream().peek((key, value)->
                System.out.println("(movieWithoutVideo) key: "+ key+ " value: " + value ));


        //		join creator/director - movieElasticsearch director not joined

        var movieCreatorIdWithoutVideo = movieCreatorTable.join(
                movieWithoutVideo,
                (movieCreatorVal) -> String.valueOf( movieCreatorVal.getMovieId()),
                this::toMovieWithCreatorId
        );

        movieCreatorIdWithoutVideo.toStream().peek((key, value)->
                System.out.println("(movieCreatorIdWithoutVideo) key: "+ key+ " value: " + value ));

        var movieCreatorWithoutVideo = movieCreatorIdWithoutVideo.join(
                creatorTable,
                (movieCreatorVal) -> new DefaultId(movieCreatorVal.getCreatorId()),
                this::toMovieCreator
        );

        movieCreatorWithoutVideo.toStream().peek((key, value)->
                System.out.println("(movieCreatorWithoutVideo) key: "+ key+ " value: " + value ));


// key = movieId
        var movieCreatorEsWithoutVideo = movieCreatorWithoutVideo.groupBy((key, value) -> KeyValue.pair( String.valueOf(key.getMovieid()), value)
//                        , Grouped.with(defaultIdSerde, movieCreatorJ)
                )
                .aggregate(
                        ()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0),
                        (key, newVal, aggVal) -> addCreator(newVal, aggVal),
                        (key, newVal, aggVal) -> aggVal,
                        Materialized.<String, MovieElasticSearch, KeyValueStore<Bytes, byte[]>>as("movie-creator-without-video") /* state store name */
                                .withValueSerde(movieEsSerde)
                );

        movieCreatorEsWithoutVideo.toStream().peek((key, value)->
                System.out.println("(movieCreatorEsWithoutVideo) key: "+ key+ " value: " + value ));

        var movieActorIdWithoutVideo = movieActorTable.join(
                movieCreatorEsWithoutVideo,
                (movieActorVal) -> String.valueOf( movieActorVal.getMovieId()),
                this::toMovieWithActor

        );

        movieActorIdWithoutVideo.toStream().peek((key, value)->
                System.out.println("(movieActorIdWithoutVideo) key: "+ key+ " value: " + value ));

        var movieActorJoinedWithoutVideo = movieActorIdWithoutVideo.join(
                actorTable,
                (movieActorIdVal) -> new DefaultId(movieActorIdVal.getActorId()),
                this::toMovieActorJoined
        );

        movieActorJoinedWithoutVideo.toStream()
                .peek((key, value)->
                        System.out.println("(movieActorJoinedWithoutVideo) key: "+ key+ " value: " + value ));


        var movieActorWithoutVideo = movieActorJoinedWithoutVideo.groupBy((key, value) -> KeyValue.pair( String.valueOf(key.getMovieid()),value))
                .aggregate(
                        ()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0),
                        (key, newVal, aggVal) -> addCast(newVal, aggVal),
                        (key, newVal, aggVal) -> aggVal,
                        Materialized.<String, MovieElasticSearch, KeyValueStore<Bytes, byte[]>>as("movie-actor-without-video") /* state store name */
                                .withValueSerde(movieEsSerde)
                );
        movieActorWithoutVideo.toStream().peek((key, value)->
                System.out.println("(movieActorWithoutVideo) key: "+ key+ " value: " + value ));

//        movieActorWithoutVideo.mapValues(val-> new com.kafkastreams.movie.model.MovieElasticSearch(
//                val.getMovieId(), val.getTitle(), val.getGenre(), val.getSynopsis(),
//                Date.from( val.getReleaseYear()), val.getImage(), val.getRating(), val.getDirector(),
//                val.getCast(), val.getUrl()
//        )).toStream().to(MOVIES_OUTPUT);

        movieActorWithoutVideo.toStream().to(MOVIES_OUTPUT, Produced.with(stringSerde, movieEsSerde));
//        .to("final_ddd_aggregates",
//                Produced.with(defaultIdSerde,(Serde)aggregateSerde));


//        movie yang ada video (key = videoId)
        var movieVideoJoined = videoTable.join(
                movieCategoryEs,
                (videoVal) -> String.valueOf(videoVal.getMovieId()),
                this::toMovieVideo
        );

        movieVideoJoined.toStream().peek((key, value)->
                System.out.println("(movieVideoJoined) key: "+ key+ " value: " + value ));


        var movieVideo = movieVideoJoined.groupBy(((key, value) -> KeyValue.pair(String.valueOf( value.getMovieId()), value)))
                .aggregate(
                        ()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0),
                        (key, newVal, aggVal) -> addVideo(newVal, aggVal),
                        (key, newVal, aggVal) -> aggVal,
                        Materialized.<String, MovieElasticSearch, KeyValueStore<Bytes, byte[]>>as("movie-video") /* state store name */
                                .withValueSerde(movieEsSerde)
                );


        movieVideo.toStream().peek((key, value)->
                System.out.println("(movieVideo) key: "+ key+ " value: " + value ));


//		join creator/director - movieElasticsearch

        var movieCreatorId = movieCreatorTable.join(
                movieVideo,
                (movieCreatorVal) -> String.valueOf( movieCreatorVal.getMovieId()),
                this::toMovieWithCreatorId
        );

        movieCreatorId.toStream().peek((key, value)->
                System.out.println("(movieCreatorId) key: "+ key+ " value: " + value ));

        var movieCreator = movieCreatorId.join(
                creatorTable,
                (movieCreatorVal) -> new DefaultId(movieCreatorVal.getCreatorId()),
                this::toMovieCreator
        );

        movieCreator.toStream().peek((key, value)->
                System.out.println("(movieCreator) key: "+ key+ " value: " + value ));


// key = movieId
        var movieCreatorEs = movieCreator
                .groupBy(((key, value) -> KeyValue.pair( String.valueOf(key.getMovieid()), value)))
                .aggregate(
                        ()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0),
                        (key, newVal, aggVal) -> addCreator(newVal, aggVal),
                        (key, newVal, aggVal) -> aggVal,
                        Materialized.<String, MovieElasticSearch, KeyValueStore<Bytes, byte[]>>as("movie-creator") /* state store name */
                                .withValueSerde(movieEsSerde)
                );


        movieCreatorEs.toStream().peek((key, value)->
                System.out.println("(movieCreatorEs) key: "+ key+ " value: " + value ));

        var movieActorId = movieActorTable.join(
                movieCreatorEs,
                (movieActorVal) -> String.valueOf(movieActorVal.getMovieId()),
                this::toMovieWithActor

        );

        movieActorId.toStream().peek((key, value)->
                System.out.println("(movieActorId) key: "+ key+ " value: " + value ));
        var movieActorJoined = movieActorId.join(
                actorTable,
                (movieActorIdVal) -> new DefaultId(movieActorIdVal.getActorId()),
                this::toMovieActorJoined
        );

        movieActorJoined.toStream()
                .peek((key, value)->
                        System.out.println("(movieActorJoined) key: "+ key+ " value: " + value ));


        var movieActor = movieActorJoined.groupBy((key, value) -> KeyValue.pair(String.valueOf(key.getMovieid()),value))
                .aggregate(
                        ()-> new MovieElasticSearch("", new ArrayList<>(), "", Instant.now(), "", (float) 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0),
                        (key, newVal, aggVal) -> addCast(newVal, aggVal),
                        (key, newVal, aggVal) -> aggVal,
                        Materialized.<String, MovieElasticSearch, KeyValueStore<Bytes, byte[]>>as("movie-actor") /* state store name */
                                .withValueSerde(movieEsSerde)
                );
        movieActor.toStream().peek((key, value)->
                System.out.println("(movieActorOutput) key: "+ key+ " value: " + value ));


//        movieActor.mapValues(val-> new com.kafkastreams.movie.model.MovieElasticSearch(
//                val.getMovieId(), val.getTitle(), val.getGenre(), val.getSynopsis(),
//                Date.from( val.getReleaseYear()), val.getImage(), val.getRating(), val.getDirector(),
//                val.getCast(), val.getUrl()
//        )).toStream().to(MOVIES_OUTPUT);
        movieActor.toStream().to(MOVIES_OUTPUT, Produced.with(stringSerde, movieEsSerde));

//		movieTable.toStream().to(MOVIES_OUTPUT);

        return builder.build();

    }
//
    private MovieElasticSearch addCast(MovieWithActorJoined movie, MovieElasticSearch movieElasticSearch){
        List<String> casts = movieElasticSearch.getCast();
        casts.add(movie.getActorName());
        MovieElasticSearch m = MovieElasticSearch.newBuilder()
                .setTitle(movie.getTitle()).setImage(movie.getImage())
                .setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getReleaseYear())
                .setGenre(movie.getGenre().stream().map(String::toString).collect(Collectors.toList()))
                .setRating(movie.getRating()).setDirector(movie.getDirector().stream().map(String::toString).collect(Collectors.toList()))
                .setMovieId(movie.getMovieId())
                .setCast(casts)
                .setUrl(movie.getUrl().stream().map(String::toString).collect(Collectors.toList()))
                .build();
        return m;
    }

    private MovieWithActorJoined toMovieActorJoined(MovieWithActorId movie, Actor actor){
        MovieWithActorJoined m = MovieWithActorJoined.newBuilder()
                .setActorName(actor.getName())
                .setTitle(movie.getTitle()).setGenre(movie.getGenre())
                .setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getReleaseYear())
                .setImage(movie.getImage()).setRating(movie.getRating()).setDirector(movie.getDirector())
                .setCast(movie.getCast()).setUrl(movie.getUrl()).setMovieId(movie.getMovieId())
                .build();
        return m;
    }
//
private MovieWithActorId toMovieWithActor(MovieActor movieActor, MovieElasticSearch movie){
    MovieWithActorId m =MovieWithActorId.newBuilder()
            .setActorId(movieActor.getActorId())
            .setTitle(movie.getTitle())
                .setImage(movie.getImage())
            .setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getReleaseYear())
                .setGenre(movie.getGenre().stream().map(CharSequence::toString).collect(Collectors.toList()))
            .setRating(movie.getRating()).setDirector(movie.getDirector().stream().map(CharSequence::toString).collect(Collectors.toList()))
            .setMovieId(movie.getMovieId())
            .setCast(new ArrayList<>())
                .setUrl(movie.getUrl().stream().map(CharSequence::toString).collect(Collectors.toList()))
            .build();
        return m;
}
//
    private MovieElasticSearch  addCreator(MovieWithCreatorJoined movie, MovieElasticSearch movieElasticSearch){
        List<String> creators = movieElasticSearch.getDirector();
        creators.add(movie.getCreatorName());
        MovieElasticSearch m = MovieElasticSearch.newBuilder()
                .setTitle(movie.getTitle()).setImage(movie.getImage())
                .setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getReleaseYear())
                .setGenre(movie.getGenre().stream().map(String::toString).collect(Collectors.toList()))
                .setRating(movie.getRating())
                .setMovieId(movie.getMovieId())
                .setCast(new ArrayList<>())
                .setUrl(movie.getUrl().stream().map(String::toString).collect(Collectors.toList()))
                .setDirector(creators)
                .build();
        return m;
    }
//
    private MovieWithCreatorJoined toMovieCreator( MovieWithCreatorId movieWithCreatorId, Creator creator){
        MovieWithCreatorJoined m = MovieWithCreatorJoined.newBuilder().setCreatorName(creator.getName().toString())
                .setTitle(movieWithCreatorId.getTitle()).setGenre(movieWithCreatorId.getGenre().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setSynopsis(movieWithCreatorId.getSynopsis()).setReleaseYear(movieWithCreatorId.getReleaseYear()).setImage(movieWithCreatorId.getImage())
                .setRating(movieWithCreatorId.getRating()).setDirector(movieWithCreatorId.getDirector().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setCast(movieWithCreatorId.getCast().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setUrl(movieWithCreatorId.getUrl().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setMovieId(movieWithCreatorId.getMovieId())
                .build();
        return m;
    }
//

    private MovieWithCreatorId toMovieWithCreatorId(MovieCreator movieCreator, MovieElasticSearch movie){
        MovieWithCreatorId m = MovieWithCreatorId.newBuilder().setCreatorId(movieCreator.getCreatorId())
                .setTitle(movie.getTitle()).setGenre(movie.getGenre().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getReleaseYear()).setImage(movie.getImage())
                .setRating(movie.getRating()).setDirector(movie.getDirector().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setCast(movie.getCast().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setUrl(movie.getUrl().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .setMovieId(movie.getMovieId())
                .build();
        return m;
    }



//
private MovieElasticSearch addVideo(MovieVideoJoined movieVideoJoined, MovieElasticSearch movie){

    List<String> videoUrl = movie.getUrl();
    videoUrl.add(movieVideoJoined.getVideoUrl());
    movie.setTitle(movieVideoJoined.getName());movie.setGenre(movieVideoJoined.getGenre().stream().map(String::toString).collect(Collectors.toList()));
    movie.setSynopsis(movieVideoJoined.getSynopsis());movie.setReleaseYear(movieVideoJoined.getReleaseYear());
    movie.setImage(movieVideoJoined.getImage());movie.setRating(movieVideoJoined.getRating());
    movie.setMovieId(movieVideoJoined.getMovieId());
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
            (genre) -> genres.add(genre)

    );

    MovieVideoJoined movieVideoJoined = MovieVideoJoined.newBuilder().setVideoUrl(video.getUrl())
            .setMovieId( movie.getMovieId()).setName(movie.getTitle())
            .setGenre(genres)
            .setSynopsis(movie.getSynopsis()).setReleaseYear(movie.getReleaseYear())
            .setImage(movie.getImage()).setRating(movie.getRating())
            .setDirector(movie.getDirector().stream().map(CharSequence::toString).collect(Collectors.toList()))
            .setCast(movie.getCast().stream().map(CharSequence::toString).collect(Collectors.toList()))
            .build();

    return movieVideoJoined;
}


    private MovieElasticSearch addCategory(MovieCategoryJoined movie, MovieElasticSearch movieElasticSearch){
        List<String> genre = movieElasticSearch.getGenre();
        genre.add(movie.getCategoryName());
         MovieElasticSearch m =  MovieElasticSearch.newBuilder()
                .setTitle(movie.getTitle())
                .setImage(movie.getImage())
                .setGenre(genre)
                .setSynopsis(movie.getSynopsis())
                .setReleaseYear(movie.getReleaseYear())
                .setImage(movie.getImage())
                .setDirector(movie.getDirector())
                .setRating(movie.getRating())
                .setCast(movie.getCast())
                .setMovieId(movie.getMovieId())
                .setUrl(movie.getUrl())
                .build();
        return m;
    }

private MovieCategoryJoined toMovieCategoryJoined(
        MovieWithCategoryId movie, Category category){

    MovieCategoryJoined  c= MovieCategoryJoined .newBuilder()
            .setCategoryName(category.getName())
            .setMovieId(movie.getMovieId()).setTitle(movie.getTitle())
            .setReleaseYear(movie.getReleaseYear()).setGenre(new ArrayList<>())
            .setSynopsis(movie.getSynopsis()).setImage(movie.getImage())
            .setRating(movie.getRating()).setDirector(new ArrayList<>())
            .setCast(new ArrayList<>()).setUrl(new ArrayList<>())
            .build();

    return c;
}


    private MovieWithCategoryId toMovieWithMovieCategoryId(MovieCategory movieCategory, Movie movie){

        MovieWithCategoryId   m = MovieWithCategoryId .newBuilder()
                .setMovieId(movie.getId()).setTitle(movie.getName())
                .setReleaseYear(movie.getrYear().toInstant()).setGenre(new ArrayList<>())
                .setSynopsis(movie.getSynopsis()).setImage(movie.getImage())
                .setRating(Float.valueOf(movie.getIdmbRating())).setDirector(new ArrayList<>())
                .setCast(new ArrayList<>()).setUrl(new ArrayList<>())

                .setCategoryId(movieCategory.getCategoryId())
                .build();
        return m;
    }




        public static void main(String[] args){
            Properties config = new Properties();

            config.put(StreamsConfig.APPLICATION_ID_CONFIG, "movies-application");
            config.put(StreamsConfig.CLIENT_ID_CONFIG, "movies-avro-lambda-example-client");


            config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServer);
            config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

//            config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass().getName());
            config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());


            config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);


            config.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistry);
            config.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kafka-streams");
            config.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 1000);

//		config.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, false);

            MovieApplication wordCountApp = new MovieApplication();

            KafkaStreams streams = new KafkaStreams(wordCountApp.createMovieTopology(), config);
            streams.cleanUp();
            streams.start();

            // shutdown hook to correctly close the streams application
            Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
            SpringApplication.run(MovieApplication.class, args);

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






