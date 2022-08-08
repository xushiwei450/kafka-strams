package com.xsw.construct.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class LineSplit {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount3");
        props.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        final StreamsBuilder builder = new StreamsBuilder();


        KStream<String, String> source = builder.stream("streams-plaintext-input01");
        source.foreach((k,v)->System.out.println("kkkkkkkk = "+k+" vvvvvvv = "+v));
//        source.flatMapValues(value -> Arrays.asList(value.toLowerCase(Locale.getDefault()).split("\\W+")))
//                .groupBy((key, value) -> value)
//                .count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("counts-store"))
//                .toStream()
//                .to("streams-wordcount-output03", Produced.with(Serdes.String(), Serdes.Long()));

        final Topology topology = builder.build();
        final KafkaStreams streams = new KafkaStreams(topology, props);
        final CountDownLatch latch = new CountDownLatch(1);

        System.out.println(topology.describe());

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook1"){
            @Override
            public void run(){
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            // countDown -> await ->
            latch.await();
        } catch (Throwable throwable) {
            System.exit(1);
        }

        System.exit(0);
    }
}
