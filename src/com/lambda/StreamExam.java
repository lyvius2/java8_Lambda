package com.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class StreamExam {
    public static void main(String[] args) {
        StreamExam se = new StreamExam();
        print("==============> " + se.addUp(Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()));

        List<artist> initArtData = se.createArtistData();
        se.getNameAndLocation(initArtData.stream()).stream().forEach(item -> print(item));
        se.getNameAndLocation2(initArtData.stream()).stream().forEach(item -> print(item));

        List<album> initAlbumData = se.createAlbumsData();
        se.getAlbumUnderTrackCount(initAlbumData.stream(), 3).stream().forEach(item -> System.out.println(item));

        int totalMembers = initArtData.stream().map(artist -> artist.getMembers()).reduce(0, (acc, element) -> acc + element);
        print("total : " + String.valueOf(totalMembers));

        Stream.of("United States of America","Republic of KOREA").forEach(item -> {
            print(item + " 의 소문자 갯수 : " + String.valueOf(se.getMinusculeCount(item)));
        });

        String maxMinuscule = se.createCountryData().stream().max(Comparator.comparing(country -> se.getMinusculeCount(country))).get();
        print("소문자가 가장 많은 String : " + maxMinuscule);
    }

    static void print(String msg){
        System.out.println(msg);
    }

    private int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (acc, element) -> acc + element);
    }

    private List<String> getNameAndLocation(Stream<artist> artists){
        return artists.map(artist -> artist.getName() + " : " + artist.getLocation()).collect(Collectors.toList());
    }

    private List<String> getNameAndLocation2(Stream<artist> artists){
        return artists.flatMap(artist -> Stream.of(artist.getName(), artist.getLocation())).collect(Collectors.toList());
    }

    private List<album> getAlbumUnderTrackCount(Stream<album> albums, int count){
        return albums.filter(album -> album.getTrack() < count).collect(Collectors.toList());
    }

    private Long getMinusculeCount(String msg){
        return msg.chars().filter(item -> Character.isLowerCase(item)).count();
    }

    private List<artist> createArtistData(){
        return Arrays.asList(new artist(1, "Beatles", "UK", "Rock", 5),
                new artist(2, "Queen", "UK", "Rock", 4),
                new artist(3, "U2", "Ireland", "Rock", 6),
                new artist(4, "Oasis", "UK", "Brit-Pop", 4),
                new artist(5, "Psy", "KOREA REP.", "K-POP", 1));
    }

    private List<album> createAlbumsData(){
        return Arrays.asList(new album("IU4", 12),
                new album("Seotaiji Single", 2),
                new album("Luna Sea", 10),
                new album("Ryoko Shinohara Single", 1));
    }

    private List<String> createCountryData(){
        return Arrays.asList("Finland",
                "Norway",
                "Iceland",
                "Denmark",
                "Sweden",
                "United Kingdom of Great Britain and Northern Ireland",
                "Netherland");
    }
}

class artist {
    public artist(int seq, String name, String location, String genre, int members){
        this.seq = seq; this.name = name; this.location = location; this.genre = genre; this.members = members;
    }
    private int seq;
    private String name;
    private String location;
    private String genre;
    private int members;
    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getMembers() {
        return members;
    }
    public void setMembers(int members) {
        this.members = members;
    }
    @Override
    public String toString() {
        return "artist [seq=" + seq + ", name=" + name + ", location=" + location + ", genre=" + genre + ", members="
                + members + "]";
    }
}

class album {
    public album(String title, int track){
        this.title = title; this.track = track;
    }
    private String title;
    private int track;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getTrack() {
        return track;
    }
    public void setTrack(int track) {
        this.track = track;
    }
    @Override
    public String toString() {
        return "album [title=" + title + ", track=" + track + "]";
    }
}
