package com.lambda.practical.modernjava.ch05;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        String[][] rawData = new String[][] {
                { "a", "b" }, { "c", "d" }, { "e", "a" }, { "a", "h" }, { "i", "j" }
        };
        List<String[]> rawList = Arrays.asList(rawData);

        rawList.stream()
                .flatMap(array -> Arrays.stream(array))
                .filter(data -> "a".equals(data.toString()))
                .forEach(data -> System.out.println(data));
    }
}
