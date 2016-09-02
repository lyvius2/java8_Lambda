package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Step04 {

    public static void main(String[] args) {
        List<musicians> list = createData();
        List<String> result = list.stream().filter(musician -> musician.getName().startsWith("The"))
                .map(musician -> musician.getNational()).collect(Collectors.toList());

        result.stream().forEach(nation -> System.out.println(nation));	// for문 대체
        //for(String tmp : result){ System.out.println("National List : " + tmp); }

        Step04 stp = new Step04();
        Map<String, List<musicians>> result1 = stp.artistByNational(list.stream());
        result1.get("UK").stream().forEach(artist -> System.out.println(artist.getName()));

        Map<Object, Long> result2 = stp.numberOfMusicians(list.stream());
        System.out.println("---------------------->> 1 : " + result2.get("UK"));

        String musicanNames = stp.artistNameString(list.stream());
        System.out.println("---------------------->> 2 : " + musicanNames);
    }
    static List<musicians> createData(){
        return Arrays.asList(new musicians("The Beatles", "UK"),
                new musicians("Michael Jackson", "United States"),
                new musicians("The U2", "Ireland"),
                new musicians("Yuki Kuramoto", "JAPAN"),
                new musicians("Boys II Man", "United States"),
                new musicians("IU", "Korea Rep."),
                new musicians("The Queen", "UK"),
                new musicians("The Oasis", "UK"),
                new musicians("Eric Clapton", "UK"));
    }

    // 그루핑
    public Map<String, List<musicians>> artistByNational(Stream<musicians> Musicians){
        return Musicians.collect(Collectors.groupingBy(musician -> musician.getNational()));
    }

    // 그루핑 후 각 항목별 갯수 구하기
    public Map<Object, Long> numberOfMusicians(Stream<musicians> Musicians){
        return Musicians.collect(Collectors.groupingBy(musician -> musician.getNational(),Collectors.counting()));
    }

    // 문자열 결합
    public String artistNameString(Stream<musicians> Musicians){
        return Musicians.map(musician -> musician.getName()).collect(Collectors.joining(", ", "[", "]"));
    }
}

class musicians {
    public musicians(String name, String national){
        this.name = name; this.national = national;
    }

    private String name;
    private String national;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNational() {
        return national;
    }
    public void setNational(String national) {
        this.national = national;
    }
    @Override
    public String toString() {
        return "musicians [name=" + name + ", national=" + national + "]";
    }
}
