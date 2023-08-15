package com.kafkastreams.movie.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkastreams.movie.model.DefaultId;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomIdSerde implements Deserializer<DefaultId>, Serializer<DefaultId> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public DefaultId deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), DefaultId.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to DefaultId");
        }
    }

    @Override
    public void close() {
    }




    @Override
    public byte[] serialize(String topic, DefaultId data) {
        try {
            if (data == null){
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }


}
