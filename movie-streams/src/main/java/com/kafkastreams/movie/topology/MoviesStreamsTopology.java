package com.kafkastreams.movie.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MoviesStreamsTopology {


    public static String MOVIES_INPUT="movies";
    public static String CATEGORY_INPUT="categories";

    public static String TAG_INPUT="tags";

    public static String VIDEO_INPUT="videos";

    public static String CREATOR_INPUT="creators";

    public static String ACTOR_INPUT="actors";


    public static String MOVIES_OUTPUT="movies-output";


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
