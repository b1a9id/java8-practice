package optional_sample;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OtherMethodSample {
	public static void main(String[] args) {
		// ifPresentメソッド。Optionalオブジェクトが値を保持している時だけ指定した処理を行う。
		List<String> words = Arrays.asList("apple", "banana", "grape");
		words.stream()
				.filter(word -> word.startsWith("a"))
				.findFirst()
				.ifPresent(word -> System.out.println(word));


		// filterメソッド。条件に一致するかどうかでフィルタリングを行う。
		List<Integer> numbers1 = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());
		numbers1.stream()
				.max(Comparator.naturalOrder())
				.filter(number -> number > 500)
				.ifPresent(number -> System.out.println(number));
		// 500より小さい時499を返す。
		List<Integer> numbers2 = IntStream.rangeClosed(1, 300).boxed().collect(Collectors.toList());
		Integer max = numbers2.stream()
				.max(Comparator.naturalOrder())
				.filter(number -> number > 500)
				.orElse(499);
		System.out.println(max);


		// mapメソッド。値の変換を行う。
		Map<String, Integer> map = new HashMap<>();
		map.put("test1", 1);
		map.put("test2", 2);
		Optional<Map<String, Integer>> mapOptional = Optional.of(map);
		mapOptional.map(m -> m.get("test1"))
				.ifPresent(m -> System.out.println(m));
	}
}
