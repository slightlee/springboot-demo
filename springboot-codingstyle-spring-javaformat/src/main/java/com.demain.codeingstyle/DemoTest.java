package com.demain.codeingstyle;

import java.util.Arrays;
import java.util.List;

public class DemoTest {

	public static void test() {
		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = Arrays.asList("d", "e", "f");
		list1.forEach(System.out::println);
		list2.forEach(System.out::println);
	}

	/**
	 * 测试
	 * @param a 数值a
	 * @param b 数值b
	 */
	public static void test2(Integer a, Integer b) {
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args) {
		test();
		test2(1, 2);
		int a = 1 + 2;
		System.out.println(a);
	}

}
