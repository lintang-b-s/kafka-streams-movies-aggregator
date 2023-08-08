package com.kafkastreams.movie.config;


import com.kafkastreams.movie.topology.MoviesStreamsTopology;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MoviesStreamsConfiguration {


    @Bean
    public NewTopic moviesTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.MOVIES_INPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic moviesOutputTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.MOVIES_OUTPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }


}
