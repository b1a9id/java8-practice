package stream_sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // リストの要素を標準出力に出力
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.forEach(System.out::println);

        /** 配列からのストリーム生成 **/
        String[] array = {"AA", "BB", "CC", "DD", "EE"};
        // 配列の全ての要素からストリームを生成
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(System.out::println);
        // array[2]~array[4]からなるストリームを生成
        Stream<String> stream2 = Arrays.stream(array, 2, 5);
        stream2.forEach(System.out::println);
    }
}
