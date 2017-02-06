package stream_sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {
        /** ofメソッド **/
        // a,b,c,dを要素に持つストリーム生成
        Stream<String> stream1 = Stream.of("a", "b", "c", "d");
        stream1.forEach(System.out::println);

        /** range, rangeClosedメソッド **/
        // 0から9までのストリームを生成
        IntStream stream2 = IntStream.range(0, 10);
        // 0から10までのストリームを生成
        IntStream stream3 = IntStream.rangeClosed(0, 10);

        /** generateメソッド **/
        Stream<String> stream4 = Stream.generate(() -> "");

        /** emptyメソッド **/
        Stream<Stream> stream5 = Stream.empty();
        IntStream stream6 = IntStream.empty();
        LongStream stream7 = LongStream.empty();
        DoubleStream stream8 = DoubleStream.empty();

        /** concatメソッド **/
        Stream<Integer> integerStream = Stream.of(1);
        Stream<Double> doubleStream = Stream.of(3.2);
        Stream<Number> numberStream = Stream.concat(integerStream, doubleStream);
        numberStream.forEach(System.out::println);

        randomStream();
        try {
            fileSystem();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private static void randomStream() {
        /** intsメソッド **/
        Random random = new Random();
        // Integer.MIN_VALUEからInteger.MAX_VALUEまでの乱数を要素にとる
        // 無限ストリームを生成
        IntStream stream1 = random.ints();
        // 要素数100のストリームを生成
        IntStream stream2 = random.ints(100L);
    }

    private static void fileSystem() throws IOException {
        Path path = Paths.get("/Users/ryosuke/Desktop/alpha");
        // 指定したディレクトリに存在するパスを標準出力に出力
        System.out.println("listメソッド");
        Files.list(path).forEach(System.out::println);
        // 指定したファイルツリーを走査して、標準出力に出力
        System.out.println("walkメソッド");
        Files.walk(path).forEach(System.out::println);
        // 拡張子がtxtのファイルを出力
        System.out.println("findメソッド");
        Files.find(path, 10, (p, attr) -> p.toString().endsWith(".txt")).forEach(System.out::println);
    }
}
