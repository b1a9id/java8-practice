package stream_sample.middle_operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // filterメソッドを使用して偶数だけのストリームとする
        IntStream intStream = IntStream.range(0, 10).filter(x -> x % 2 == 0);

        // 文字数が5文字より大きいもののみ出力
        List<String> words = new ArrayList<>();
        words.add("test");
        words.add("sample");
        words.add("desk");
        words.add("computer");

        words.stream()
                .filter(word -> word.length() > 5)
                .forEach(System.out::println);
    }
}
