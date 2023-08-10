package com.kafkastreams.movie.topology;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerializer;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Slf4j
public class MoviesStreamsTopology {


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


    @Value("${spring.cloud.stream.kafka.streams.binder.configuration.schema.registry.url}")
    private String schemaRegistryUrl;

    @PostConstruct
    public void init(){
        Map<String, String> serdeConfig = Collections.singletonMap(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
//        SpecificAvroSerializer<>
    }


    @Autowired
    public void process(StreamsBuilder streamsBuilder){
        var moviesStream = streamsBuilder.stream(
                MOVIES_INPUT,
                Consumed.with(Serdes.String(), Serdes.String())
        );

        moviesStream
                .print(Printed.<String, String>toSysOut().withLabel("moviesStream"));


        var modifiedMoviesStream = moviesStream.
                mapValues((readOnlyKey, value) -> value.toUpperCase());

        modifiedMoviesStream
                .print(Printed.<String, String>toSysOut().withLabel("modifiedmoviesStream"));


        modifiedMoviesStream.
                to(MOVIES_OUTPUT,
                        Produced.with(Serdes.String(), Serdes.String()));


    }
}
