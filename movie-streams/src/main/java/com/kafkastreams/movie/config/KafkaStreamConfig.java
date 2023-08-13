//package com.kafkastreams.movie.config;
//
//import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
//import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.Topology;
//
//
//import java.util.HashMap;
//import java.util.Properties;
//
//
//public class KafkaStreamConfig {
//
//
//
//
//
//
//    public static Properties kafkaStreamsConfiguration() {
//        Properties config = new Properties();
//
//        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-stream-" + System.currentTimeMillis());
//        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092");
//        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
////        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
//
//        config.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, "3000");
//        config.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);
//        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
////        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL);
//
//
//
//        return config;
//    }
//
//
//
//
//
//}
