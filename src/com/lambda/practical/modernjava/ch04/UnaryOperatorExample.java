package com.lambda.practical.modernjava.ch04;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> operator = (t) -> t * 3;

        for (int index = 0; index < 5; index++) {
            System.out.println(operator.apply(index));
        }

        BinaryOperator<Integer> operator2 = (a, b) -> a + b;
        System.out.println("Result : " + operator2.apply(7, 9));
    }
}
