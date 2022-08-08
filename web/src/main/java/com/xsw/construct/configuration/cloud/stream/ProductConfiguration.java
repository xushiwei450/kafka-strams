package com.xsw.construct.configuration.cloud.stream;

import com.sun.tools.javac.util.List;
import com.xsw.construct.common.log.LoggerUtil;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Configuration
public class ProductConfiguration {

    private BlockingQueue<Person> unbounded = new LinkedBlockingQueue<>();
    private BlockingQueue<Account> accountQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    /**
     * 对应yml中配置的logP-out-0通道，即topic log
     * @return java.util.function.Supplier<com.example.kafka.entity.Person>
     * @Date 2020-12-27
     **/
    @Bean
    public Supplier<Person> productPerson(){
        return () -> unbounded.poll();
    }

    /**
     * 调用本方法向log topic发送消息
     *
     * @param person:
     * @return void
     * @Date 2020-12-27
     **/
    public void addPerson(Person person){
        unbounded.offer(person);
    }


    @Bean
    public Supplier<Account> productAccount(){
        return () -> accountQueue.poll();
    }


    public void addAccount(Account account){
        accountQueue.offer(account);
    }


    @Bean
    public Supplier<Order> productOrder(){
        return () -> orderQueue.poll();
    }


    public void addOrder(Order order){
        orderQueue.offer(order);
    }

}
