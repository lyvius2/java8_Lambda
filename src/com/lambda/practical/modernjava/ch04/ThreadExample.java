package com.lambda.practical.modernjava.ch04;

public class ThreadExample {
    public static void main(String[] args) {
        Runnable runImpl = () -> System.out.println("Hello World~");
        Thread thread = new Thread(runImpl);
        thread.start();
    }
}
