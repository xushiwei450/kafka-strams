//package com.xsw.construct.configuration.cloud.stream.consumers;
//
//import org.apache.kafka.streams.kstream.KStream;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.function.Consumer;
//
//public class ConsumerTestTwo implements Consumer<KStream<String, String>> {
//
//    @Override
//    public void accept(KStream<String, String> input) {
//        input.foreach((key, value) -> {
//            System.out.println("consumerTestTwo Key: " + key + " Value: " + value);
//        });
//    }
//}
