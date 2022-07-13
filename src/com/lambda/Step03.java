package com.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Step03 {

    public static void main(String[] args) {
        Step03 stp = new Step03();
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 7, 8, 9);

        // 가장 적은 길이의 트랙을 구하기
        System.out.println("Min ---->> " + stp.getMin(tracks).toString());
        // 가장 긴 길이의 트랙을 구하기
        System.out.println("Max ---->> " + stp.getMax(tracks).toString());

        // 총합을 구하기 (use reduce())
        System.out.println("Count ---->> " + stp.getCount(numbers));

        // 통계용 객체
        IntSummaryStatistics iss = stp.getTrackLengthStats(tracks);
        System.out.printf("Max:%d, Min:%d, Ave:%f, Sum:%d \n",
                iss.getMax(),
                iss.getMin(),
                iss.getAverage(),
                iss.getSum());

        // 평균 구하기
        double average = tracks.stream().collect(Collectors.averagingInt(track -> track.getTrackTime()));
        System.out.println("Average : " + average);
    }

    // 최소값 구하기
    Track getMin(List<Track> tracks) {
        Track shortesTrack = tracks.stream().min(Comparator.comparing(track -> track.getTrackTime())).get();
        return shortesTrack;
    }

    // 최대값 구하기
    Track getMax(List<Track> tracks) {
        Track longestTrack = tracks.stream().max(Comparator.comparing(track -> track.getTrackTime())).get();
        return longestTrack;
    }

    // 총합 구하기
    int getCount(List<Integer> numbers) {
        return numbers.stream().reduce(0, (acc, element) -> acc + element);
    }

    // 통계
    IntSummaryStatistics getTrackLengthStats(List<Track> tracks) {
        return tracks.stream().mapToInt(track -> track.getTrackTime()).summaryStatistics();
    }
}

class Track {
    public Track(String sing, int trackTime) {
        this.sing = sing;
        this.trackTime = trackTime;
    }

    private String sing;
    private int trackTime;

    public String getSing() {
        return sing;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }

    public int getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(int trackTime) {
        this.trackTime = trackTime;
    }

    @Override
    public String toString() {
        return "Track [sing=" + sing + ", trackTime=" + trackTime + "]";
    }
}
