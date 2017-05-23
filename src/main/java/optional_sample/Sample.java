package optional_sample;

import java.util.Optional;

public class Sample {
	public static void main(String[] args) {
		System.out.println(sample1(null));
		System.out.println(sample2(null));

		System.out.println(sample1("fuga"));
		System.out.println(sample2("fuga"));
	}

	private static String sample1(String hoge) {
		SampleObj obj = new SampleObj();
		obj.setHoge(hoge);

		String test1 = null;
		if (obj.getHoge() == null) {
			test1 = "テストだよ";
		} else {
			test1 = hoge;
		}
		return test1;
	}

	private static String sample2(String hoge) {
		SampleObj obj = new SampleObj();
		obj.setHoge(hoge);

		String test1 = Optional.ofNullable(obj.getHoge()).orElse("テストやねん");
		return test1;
	}
}
