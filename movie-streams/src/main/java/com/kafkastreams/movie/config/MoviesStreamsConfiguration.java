package com.kafkastreams.movie.config;


import com.kafkastreams.movie.exceptionhandler.StreamsProcessorCustomErrorHandler;
import com.kafkastreams.movie.topology.MoviesStreamsTopology;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.streams.RecoveringDeserializationExceptionHandler;

@Configuration
@Slf4j
public class MoviesStreamsConfiguration {

    @Autowired
    KafkaProperties kafkaProperties;


    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;



    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamConfig() {

        var streamProperties = kafkaProperties.buildStreamsProperties();

//        deserialization exception handler & recovery
        streamProperties.put(StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, RecoveringDeserializationExceptionHandler.class);
        streamProperties.put(RecoveringDeserializationExceptionHandler.KSTREAM_DESERIALIZATION_RECOVERER, consumerRecordRecoverer);
        //streamProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new KafkaStreamsConfiguration(streamProperties);
    }


// streamsprocessorerrorhandler
    @Bean
    public StreamsBuilderFactoryBeanConfigurer streamsBuilderFactoryBeanConfigurer(){
        log.info("Inside streamsBuilderFactoryBeanConfigurer");
        return factoryBean -> {
            factoryBean.setStreamsUncaughtExceptionHandler(new StreamsProcessorCustomErrorHandler());
        };
    }

//    recover and send to  dlq topic
    public DeadLetterPublishingRecoverer recoverer() {
        return new DeadLetterPublishingRecoverer(kafkaTemplate,
                (record, ex) -> {
                    log.error("Exception in Deserializing the message : {} and the record is : {}", ex.getMessage(),record,  ex);
                    return new TopicPartition("recovererDLQ", record.partition());
                });
    }


// log exception when deserializing
    ConsumerRecordRecoverer consumerRecordRecoverer = (record, exception) -> {
        log.error("Exception is : {} Failed Record : {} ", exception, record);
    };




    @Bean
    public NewTopic moviesTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.MOVIES_INPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }


    @Bean
    public NewTopic categoriesTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.CATEGORY_INPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic tagsTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.TAG_INPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }



    @Bean
    public NewTopic videosTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.VIDEO_INPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic creatorsTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.CREATOR_INPUT)
                .partitions(2)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic actorsTopic(){
        return TopicBuilder.name(MoviesStreamsTopology.ACTOR_INPUT)
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
