package com.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.BinaryOperator;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Step01 {
    public static void main(String[] args) {
        Predicate<Integer> fire = x -> x>5;
        Consumer<String> cons = tmp -> System.out.println(tmp);
        Function<Integer, String> func = x -> "Convert - " + x.toString();
        Supplier<String> sply = () -> "Nothing";
        BinaryOperator<Integer> add = (x,y) -> x+y;

        System.out.println("람다 테스트 - ");
        System.out.println("Predicate : " + fire.test(5));
        System.out.print("Consumer : "); cons.accept("Action!!");
        System.out.println("Function : " + func.apply(1008));
        System.out.println("Supplier : " + sply.get());
        System.out.println("BinaryOperator : " + add.apply(9, 9));
    }
}
