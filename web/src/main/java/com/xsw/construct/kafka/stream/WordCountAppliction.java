//package com.xsw.construct.kafka.stream;
//
//import com.xsw.construct.common.log.LoggerUtil;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.KStream;
//
//import java.util.Properties;
//
//public class WordCountAppliction {
//
//    public static void main(String[] args) {
//        Properties properties = new Properties();
//        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
//
//        // 流处理构建对象
//        StreamsBuilder builder = new StreamsBuilder();
//        // input stream
//        KStream<String, String> textLines = builder.stream("input");
//        textLines.foreach((k,v)->{LoggerUtil.info("WordCount foreach k = {0} v = {1} ",k,v);});
//
//        // 流处理
//        // Hello World
//        // k: Hello World v: Hello
//        // k: Hello World v: World
////        KTable<String, Long> wordCount = textLines.flatMapValues(v -> Arrays.asList(v.split(" ")))
////                // hello hello
////                // world word
////                .groupBy((k, v) -> v)
////                // hello 1
////                // ....
////                .count();
//
//        // output stream
////        wordCount.toStream().to("output", Produced.with(Serdes.String(), Serdes.Long()));
//
//        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), properties);
//        // 启动
//        kafkaStreams.start();
//
//    }
//
//}
