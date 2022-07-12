package com.lambda.practical.modernjava.ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortCollection {
    public static void main(String[] args) {
        List<BaseballPlayer> list = new ArrayList<>();
        // 익명 클래스
        list.sort(new Comparator<BaseballPlayer>() {

            @Override
            public int compare(BaseballPlayer o1, BaseballPlayer o2) {
                // TODO Auto-generated method stub
                return o1.getPlayerName().compareTo(o2.getPlayerName());
            }
            
        });
        // 람다식ㄴ
        list.sort((o1, o2) -> o1.getPlayerName().compareTo(o2.getPlayerName()));
    }
}
