package com.lambda.practical.modernjava.ch04;

import java.util.function.Consumer;

public class AndThenExample {
    public static void main(String[] args) {
        Consumer<String> consumer = (str) -> System.out.println("Hello!, " + str);
        Consumer<String> andThenConsumer = (str) -> System.out.println("Length : " + str.length());

        consumer.andThen(andThenConsumer).accept("JAVA");
    }
}
