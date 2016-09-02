package com.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Step05 {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(asList(4,3,2,1));
        List<Integer> sameOrders = numbers.stream().sorted().collect(toList());
        sameOrders.stream().forEach(item -> System.out.println(item));
    }
}
