package com.xsw.construct.configuration.cloud.stream;

import com.alibaba.fastjson.JSONObject;
import com.xsw.construct.common.log.LoggerUtil;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class ConsumersConfiguration {

    /**
     * 对应yml中配置的logC-in-0通道，即topic log。
     * 消费topic log中的消息
     *
     * @return java.util.function.Consumer<com.example.kafka.entity.Person>
     * @Date 2020-12-27
     **/
    @Bean
    public Consumer<Person> consumerPerson() {

        return person -> {
            System.out.println("Consumer person: " + person.toString());
        };
    }

    /**
     * 对应yml中配置的addAgeC-in-0通道，即topic addAge。
     * 消费topic addAge中的消息
     *
     * @return java.util.function.Consumer<com.example.kafka.entity.Person>
     * @Date 2020-12-27
     **/
    @Bean
    public Consumer<Account> consumerAccount(){

        return account -> {
            System.out.println("Consumer account: " + account.toString());
        };
    }


    @Bean
    public Consumer<Order> consumerOrder() {

        return order -> {
            System.out.println("Consumer order: " + order.toString());
        };
    }



//    @Bean(name = "consumerTestOne")
//    public Consumer<KStream<String, String>> consumerTestOne() {
//
//        return input ->
//                input.foreach((key, value) -> {
//                    System.out.println("consumerTestOne  Key: " + key + " Value: " + value);
//                });
//    }
//
//
//
//    @Bean(name = "consumerTestTwo")
//    public Consumer<KStream<String, String>> consumerTestTwo() {
//        return new ConsumerTestTwo();
//    }


//    @Bean
//    public BiConsumer<KStream<String, Account>, KStream<String, Person>> processOne() {
//        return (a, b) -> {
//            a.peek((k,v)->{LoggerUtil.info("processOne---  a : {0}", JSONObject.toJSONString(v)); });
//            b.peek((k,v)->{LoggerUtil.info("processOne=== b : {0}", JSONObject.toJSONString(v)); });
//        };
//    }
//
//    @Bean
//    public BiConsumer<KStream<String, Person>, KStream<String, Person>> processTwo() {
//        return (a, b) -> a
//                .merge(b)
//                .peek((k, v) -> {
//
//                    LoggerUtil.info("processTwo ({0}): {1}", JSONObject.toJSONString(k),JSONObject.toJSONString(v));
//                });
//    }

    @Bean
    public Function<KStream<String, Order>, KStream<String, Person>> functionProcessOne() {

        return input -> {
            input.peek((k,v)->{
                LoggerUtil.info("functionProcessOne Account ({0}): {1}", JSONObject.toJSONString(k),JSONObject.toJSONString(v));});
            return input.map((key, value) -> new KeyValue<String,Person>("1111", new Person("tim6666","13817362618","2")));};

    }

    @Bean
    public Function<KStream<String, Order>, Function<KStream<String, Person>, KStream<String, Account>>> moreFunction() {

//        return orders ->
//                persons ->{
//                    orders.peek((k,v)->{
//                        LoggerUtil.info("moreFunction orders ({0}): {1}", JSONObject.toJSONString(k),JSONObject.toJSONString(v));});
//                    persons.peek((k,v)->{
//                        LoggerUtil.info("moreFunction persons ({0}): {1}", JSONObject.toJSONString(k),JSONObject.toJSONString(v));});
//                    // 流处理构建对象
//                    StreamsBuilder builder = new StreamsBuilder();
//                    // input stream
//                    KStream<String, Account> response = builder.stream("account");
//                    response.
//
//
//                  return  new KeyValue<String,Account>("1111", new Account("1","13817362618")).
//        };

        return orders->{
            orders.peek((k,v)->{LoggerUtil.info("moreFunctionFirst orders ({0}): {1}", JSONObject.toJSONString(k),JSONObject.toJSONString(v));});
            int a = 6;
            return persons->{
                orders.peek((k,v)->{LoggerUtil.info("moreFunction orders ({0}): {1}:{2}", JSONObject.toJSONString(k),JSONObject.toJSONString(v),a);});
                persons.peek((k,v)->{LoggerUtil.info("moreFunction persons ({0}): {1}", JSONObject.toJSONString(k),JSONObject.toJSONString(v));});
                return orders.map((key, value) -> new KeyValue<String,Account>("1111", new Account("13817362618","2")));
            };

        };

    }

    @PostConstruct
    public void init(){
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");

        // 流处理构建对象
        StreamsBuilder builder = new StreamsBuilder();
        // input stream
        KStream<String, String> textLines = builder.stream("input");
        textLines.foreach((k,v)->{LoggerUtil.info("input foreach k = {0} v = {1} ",k,v);});

        // 流处理
        // Hello World
        // k: Hello World v: Hello
        // k: Hello World v: World
        KTable<String, Long> wordCount = textLines.flatMapValues(v -> Arrays.asList(v.split(" ")))
                // hello hello
                // world word
                .groupBy((k, v) -> v)
                // hello 1
                // ....
                .count();
        wordCount.toStream().foreach((k,v)->{LoggerUtil.info("wordCount foreach k = {0} v = {1}",k,v);});

        KStream<String, String> wordCount2 = textLines.selectKey((k,v)->new BigDecimal(Math.random()*100).longValue()+"");
        wordCount2.foreach((k,v)->{LoggerUtil.info("wordCount2 foreach k = {0} v = {1}",k,v);});

        KStream<String, String> wordCount3 = textLines.flatMap((k,v) -> {
                    List<String> splitList = Arrays.asList(v.split(" "));
                    List<KeyValue<String, String>> result = new LinkedList<>();
                    for (String str : splitList) {
                        result.add(KeyValue.pair(str, k + str));
                    }
                    return result;
                }

            );
//        wordCount3.foreach((k,v)->LoggerUtil.info("wordCount3 foreach k = {0} v = {1}",k,v));


        KStream<String, String> wordCount4 = wordCount3.filter((key, value) -> key.equals("333"));
//        wordCount4.foreach((k,v)->LoggerUtil.info("wordCount4 foreach k = {0} v = {1}",k,v));

        KStream<String, String> wordCount5 =wordCount4.mapValues(value -> value+"tim");
//        wordCount5.foreach((k,v)->LoggerUtil.info("wordCount5 foreach k = {0} v = {1}",k,v));

        KStream<String, String> wordCount6 = wordCount5.map((key, value) -> KeyValue.pair(key+"sherlock",value+"sherlock"));
//        wordCount6.foreach((k,v)->LoggerUtil.info("wordCount6 foreach k = {0} v = {1}",k,v));

//        wordCount3.foreach((k,v)->LoggerUtil.info("wordCount3Again foreach k = {0} v = {1}",k,v));
        KTable<String, Long> wordCount7 =  wordCount3.groupByKey().count();
        wordCount7.toStream().foreach((k,v)->LoggerUtil.info("wordCount7 foreach k = {0} v = {1}",k,v));

//        wordCount3.groupBy((k,v)->k).count();



//        // output stream
//        wordCount.toStream().to("output", Produced.with(Serdes.String(), Serdes.Long()));
//
//        wordCount2.to("output2", Produced.with(Serdes.String(), Serdes.String()));

        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), properties);
        // 启动
        kafkaStreams.start();
    }

    @Bean
    public Consumer<KTable<String,Long>> consumerOutput() {

        return output->output.toStream().peek((k,v)->{LoggerUtil.info("this is consumerOutput  k = {0} v = {1}",k,v);});

    }

    @Bean
    public Consumer<KStream<String, String>> consumerOutput2() {

        return output->output.peek((k,v)->{LoggerUtil.info("this is consumerOutput2  k = {0} v = {1}",k,v);});

    }




    @Bean
    public Function<KStream<String, Order>, KTable<String, Order>> functionProcessThree() {

        return order->{
            order.peek((k,v)->{LoggerUtil.info("this is functionProcessThree  k = {0} v = {1}",k,v);});
//            return order.selectKey((k,v)->v.getOrderId()).toTable().mapValues(value -> JSONObject.toJSONString(value)).toStream();};
//        return order.selectKey((k,v)->v.getOrderId()).toTable();};
        return            order.selectKey((k,v)->v.getOrderId(),Named.as("bbbbThree")).toTable(Named.as("aaaaathree"));};



    }

}










