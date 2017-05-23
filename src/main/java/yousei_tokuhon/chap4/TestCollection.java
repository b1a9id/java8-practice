package yousei_tokuhon.chap4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {
	public static void main(String[] args) {
		String test1 = "test1";
		String test2 = "test2";
		String test3 = "test3";

		List<String> addArrayList = new ArrayList<>();
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			addArrayList.add(test1);
			addArrayList.add(test2);
			addArrayList.add(test3);
		}
		long entTime1 = System.currentTimeMillis();
		System.out.println("ArrayListの前から追加の所要時間(ms) ： " + (entTime1 - startTime1));

		List<String> addRandomArrayList = addArrayList;
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			addRandomArrayList.add(2 * i, test1);
		}
		long entTime2 = System.currentTimeMillis();
		System.out.println("ArrayListのランダム追加の所要時間(ms) ： " + (entTime2 - startTime2));

		List<String> referArrayList = addArrayList;
		long startTime3 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			referArrayList.get(i);
		}
		long entTime3 = System.currentTimeMillis();
		System.out.println("ArrayListの参照の所要時間(ms) ： " + (entTime3 - startTime3));

		List<String> referRandomArrayList = addArrayList;
		long startTime4 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			referArrayList.get(2 * i);
		}
		long entTime4 = System.currentTimeMillis();
		System.out.println("ArrayListのランダム参照の所要時間(ms) ： " + (entTime4 - startTime4));

		List<String> deleteArrayList = addArrayList;
		long startTime5 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			deleteArrayList.remove(i);
		}
		long entTime5 = System.currentTimeMillis();
		System.out.println("ArrayListの前から削除の所要時間(ms) ： " + (entTime5 - startTime5));

		List<String> deleteRandomArrayList = addArrayList;
		long startTime6 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			deleteRandomArrayList.remove(2 * i);
		}
		long entTime6 = System.currentTimeMillis();
		System.out.println("ArrayListのランダム削除の所要時間(ms) ： " + (entTime6 - startTime6));

		System.out.println("========================================");

		List<String> addLinkedList = new LinkedList<>();
		long startTime7 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			addLinkedList.add(test1);
			addLinkedList.add(test2);
			addLinkedList.add(test3);
		}
		long entTime7 = System.currentTimeMillis();
		System.out.println("LinkedListの前から追加の所要時間(ms) ： " + (entTime7 - startTime7));

		List<String> addRandomLinkedList = addLinkedList;
		long startTime8 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			addRandomLinkedList.add(2 * i, test1);
		}
		long entTime8 = System.currentTimeMillis();
		System.out.println("LinkedListのランダム追加の所要時間(ms) ： " + (entTime8 - startTime8));

		List<String> referLinkedList = addLinkedList;
		long startTime9 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			referLinkedList.get(i);
		}
		long entTime9 = System.currentTimeMillis();
		System.out.println("LinkedListの参照の所要時間(ms) ： " + (entTime9 - startTime9));

		List<String> referRandomLinkedList = addLinkedList;
		long startTime10 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			referRandomLinkedList.get(2 * i);
		}
		long entTime10 = System.currentTimeMillis();
		System.out.println("LinkedListのランダム参照の所要時間(ms) ： " + (entTime10 - startTime10));

		List<String> deleteLinkedList = addLinkedList;
		long startTime11 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			deleteLinkedList.remove(i);
		}
		long entTime11 = System.currentTimeMillis();
		System.out.println("LinkedListの前から削除の所要時間(ms) ： " + (entTime11 - startTime11));

		List<String> deleteRandomLinkedList = addLinkedList;
		long startTime12 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			deleteRandomLinkedList.remove(2 * i);
		}
		long entTime12 = System.currentTimeMillis();
		System.out.println("LinkedListのランダム削除の所要時間(ms) ： " + (entTime12 - startTime12));
	}
}
