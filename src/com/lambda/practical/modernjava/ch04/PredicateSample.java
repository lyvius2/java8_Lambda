package com.lambda.practical.modernjava.ch04;

import java.util.function.Predicate;

public class PredicateSample {
    public static Predicate<GameConsole> isSega() {
        return (console) -> "SEGA".equals(console.getManufacturer().toUpperCase());
    }

    public static Predicate<GameConsole> isMedia() {
        return (console) -> "CD".equals(console.getMedia().toUpperCase());
    }

    public static void main(String[] args) {
        GameConsole saturn = new GameConsole();
        saturn.setConsole("Sega Saturn");
        saturn.setManufacturer("SEGA");
        saturn.setMedia("CD");

        Predicate<GameConsole> isSega = PredicateSample.isSega();
        Predicate<GameConsole> isMedia = PredicateSample.isMedia();
        Predicate<GameConsole> isSegaSaturn = isSega.and(isMedia);
        
        System.out.println("Is this a sega saturn? : " + isSegaSaturn.test(saturn));
    }
}
