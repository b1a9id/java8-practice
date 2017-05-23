package optional_sample;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;

public class GetValueSample {

	public static void main(String[] args) {
		// 配列に値が入っていない場合、デフォルト値0.0を返す
		double nonAverage = average(new int[3]);
		System.out.println(nonAverage);

		// 配列に値が入っているとき、平均値を返す
		double hasAverage = average(new int[] {1, 2, 3});
		System.out.println(hasAverage);


		// 値が入っていない時NoSuchElementExceptionを投げる
		Optional<String> optional;
		try {
			optional = Optional.empty();
			String test1 = optional.get();
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException投げました。");
		}

		// 値が入っていない場合Karaと返す
		optional = Optional.empty();
		String test2 = optional.orElse("Kara");
		System.out.println(test2);

		// 値が入っていない場合、ラムダ式を実行し、結果としてKaraLambdaと返す
		optional = optional.empty();
		String test3 = optional.orElseGet(() -> "KaraLambda");
		System.out.println(test3);

		// 値がはいいていない場合、ラムダ式を実行し、結果としてIllegalArgumentExceptionを投げる
		try {
			String test4 = optional.orElseThrow(() -> new IllegalArgumentException());
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentExceptionを投げました");
		}
	}

	private static double average(int[] target) {
		OptionalDouble nonAve = Arrays.stream(target).average();
		return nonAve.orElse(0.0);
	}
}
