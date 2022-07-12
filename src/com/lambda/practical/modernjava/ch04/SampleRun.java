package com.lambda.practical.modernjava.ch04;

public class SampleRun {
    void run(SampleInterface interface1, String testMessage) {
        interface1.Test(testMessage);
    }

    public static void main(String[] args) {
        SampleRun sampleRun = new SampleRun();
        sampleRun.run((str) -> {System.out.println("Print : " + str);}, "Run!");
    }
}
