package yousei_tokuhon.chap4;

public class TestString {
	public static void main(String[] args) {
		String val1 = "abcde";
		String val2 = "fghij";
		String val3 = "klmno";
		String val4 = "pqrst";
		String val5 = "uvwxyz";

		long startTime1 = System.currentTimeMillis();
		String message1 = null;
		for (int i = 0; i < 100000000; i++) {
			message1 = val1 + val2;
			message1 += val3;
			message1 += val4;
			message1 += val5;
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("＋で連結の所要時間(ms) : " + (endTime1 - startTime1));

		long startTime2 = System.currentTimeMillis();
		String message2 = null;
		for (int i = 0; i < 100000000; i++) {
			StringBuilder buf2 = new StringBuilder();
			buf2.append(val1);
			buf2.append(val2);
			buf2.append(val3);
			buf2.append(val4);
			buf2.append(val5);
			message2 = buf2.toString();
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("StringBuilderで連結の所要時間(ms) : " + (endTime2 - startTime2));

		long startTime3 = System.currentTimeMillis();
		String message3 = null;
		StringBuilder buf3 = new StringBuilder();
		for (int i = 0; i < 100000000; i++) {
			buf3.setLength(0);
			buf3.append(val1);
			buf3.append(val2);
			buf3.append(val3);
			buf3.append(val4);
			buf3.append(val5);
			message3 = buf3.toString();
		}
		long endTime3 = System.currentTimeMillis();
		System.out.println("StringBuilder＆setLength(0)で連結の所要時間(ms) : " + (endTime3 - startTime3));

		long startTime4 = System.currentTimeMillis();
		String message4 = null;
		for (int i = 0; i < 100000000; i++) {
			StringBuilder buf4 = new StringBuilder(val1);
			buf4.append(val2);
			buf4.append(val3);
			buf4.append(val4);
			buf4.append(val5);
			message4 = buf4.toString();
		}
		long endTime4 = System.currentTimeMillis();
		System.out.println("StringBuilder＆new StringBuilder(val1)で連結の所要時間(ms) : " + (endTime4 - startTime4));

		long startTime5 = System.currentTimeMillis();
		String message5 = null;
		for (int i = 0; i < 100000000; i++) {
			message5 = val1 + val2 + val3 + val4 + val5;
		}
		long endTime5 = System.currentTimeMillis();
		System.out.println("+で一気に連結の所要時間(ms) : " + (endTime5 - startTime5));
	}
}
