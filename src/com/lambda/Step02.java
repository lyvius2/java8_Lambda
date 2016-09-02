package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Step02 {

	public static void main(String[] args) {
		List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
		collected.forEach(item -> System.out.println("-------------->>> " + item));

		List<String> maps = Stream.of("a", "b", "c").map(string -> string.toUpperCase()).collect(Collectors.toList());
		maps.forEach(item -> System.out.println("-------------->>> " + item));

		List<testModel> testModelList = new ArrayList<>();
		testModelList.add(new testModel(1, "London"));
		testModelList.add(new testModel(2, "Seoul"));
		testModelList.add(new testModel(1, "New York"));
		testModelList.add(new testModel(1, "Frankfurt"));
		testModelList.add(new testModel(2, "Stockholm"));

		// ArrayList 객체로 필터
		List<testModel> result0 = testModelList.stream().filter(model -> model.getKey() == 1).collect(Collectors.toList());
		for (testModel tt : result0) {
			System.out.println(tt.toString());
		}

		// 배열 객체로 필터
		String[] cityArray = {"London", "Seoul", "New York", "Frankfurt", "Stockholm"};
		List<String> result = Stream.of(cityArray).filter(model -> model.substring(0, 1).equals("S")).collect(Collectors.toList());
		for (String tmp : result) {
			System.out.println("--------------->>> " + tmp);
		}

		// flatMap으로 List객체들을 합치기
		List<testModel> testModelList2 = new ArrayList<>();
		testModelList2.add(new testModel(2, "Reykjavik"));
		testModelList2.add(new testModel(1, "Tokyo"));

		List<testModel> result2 = Stream.of(result0, testModelList2).flatMap(city -> city.stream()).collect(Collectors.toList());
		for (testModel tt : result2) {
			System.out.println("--> " + tt.toString());
		}
	}
}

class testModel {
	public testModel(int key, String value) {
		this.key = key;
		this.value = value;
	}

	private int key;
	private String value;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "testModel [key=" + key + ", value=" + value + "]";
	}
}
