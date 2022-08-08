//package com.xsw.construct.configuration.cloud.stream.consumers;
//
//import com.xsw.construct.configuration.cloud.stream.Account;
//import com.xsw.construct.configuration.cloud.stream.Order;
//import com.xsw.construct.configuration.cloud.stream.Person;
//import org.apache.kafka.streams.KeyValue;
//import org.apache.kafka.streams.kstream.KStream;
//
//import java.util.function.Function;
//
//public class MoreFunctionThree implements Function<KStream<String, Order>, Function<KStream<String, Person>, Function<KStream<String, Person>, KStream<String, Account>>>> {
//
//
//    @Override
//    public Function<KStream<String, Person>, Function<KStream<String, Person>, KStream<String, Account>>> apply(KStream<String, Order> stringOrderKStream) {
//        return a->{
//             return    b->{
//            return stringOrderKStream.map((key, value) -> new KeyValue<String,Account>("1111", new Account("1","13817362618")));
//        };};
//    }
//}
