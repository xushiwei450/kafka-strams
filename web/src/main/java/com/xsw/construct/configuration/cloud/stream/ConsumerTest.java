package com.xsw.construct.configuration.cloud.stream;


import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface ConsumerTest<T> extends Consumer<T>{


    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }

}
