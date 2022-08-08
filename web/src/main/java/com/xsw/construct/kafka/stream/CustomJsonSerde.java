package com.xsw.construct.kafka.stream;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class CustomJsonSerde<T> implements Serde<T> {


    @Override
    public Serializer<T> serializer() {
        return null;
    }

    @Override
    public Deserializer<T> deserializer() {
        return null;
    }
}
