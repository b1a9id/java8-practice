package methodReference;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by ryosuke on 2016/08/13.
 */
public class MethodReferenceDemo2 {

    public static void main(String[] args) {
        List<String> texts = new ArrayList<>();

        // ラムダ式で変数textsのaddコール
        Consumer<String> consumer1 = text -> texts.add(text);
        consumer1.accept("Lambda");
        // メソッド参照でヘンスtextsのaddメソッドをコール
        Consumer<String> consumer2 = texts::add;
        consumer2.accept("MethodReference");
        // 出力
        texts.forEach(System.out::println);


        // ラムダ式の引数に対してメソッドコールをする例
        Function<String, String> func1 = text -> text.trim();
        String trimmedText1 = func1.apply(" Hello, World!");
        System.out.println(trimmedText1);

        // オブジェクトを指摘できないインスタンスメソッド参照の例
        Function<String, String> func2 = String::trim;
        String trimmedText2 = func2.apply(" Hello, Java!");
        System.out.println(trimmedText2);

        // 引数のあるインスタンスメソッド参照の例
        BiFunction<String, String, String> func3 = (text, concatText) -> text.concat(concatText);
        String result1 = func3.apply("uchitate", "ryosuke");
        System.out.println(result1);
        BiFunction<String, String, String> func4 = String::concat;
        System.out.println(func4.apply("That's", "right!"));


        // ラムダ式でオブジェクトを生成
        Supplier<Random> supplier1 = () -> new Random();
        Random random1 = supplier1.get();
        // コンストラクタ参照でオブジェクトを生死
        Supplier<Random> supplier2 = Random::new;
        Random random2 = supplier2.get();

        // 引数のあるコンストラクタ参照の例
        BiFunction<String, Integer, BigInteger> func5 = (value, radix) -> new BigInteger(value, radix);
        BigInteger num1 = func5.apply("1A", 16);
        System.out.println(num1);
        BiFunction<String, Integer, BigInteger> func6 = BigInteger::new;
        BigInteger num2 = func6.apply("FE", 16);
        System.out.println(num2);

        // Iterable#forEachメソッドの使用例
        List<String> items = new ArrayList<>();
        items.add("pen");
        items.add("note");
        items.add("desk");
        items.forEach(item -> System.out.println(item));
        System.out.println("----------");
        items.forEach(System.out::println);
        System.out.println("----------");

        // リストソートの例(昇順)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(10);
        numbers.forEach(System.out::println);
        Collections.sort(numbers, Integer::compare);
        System.out.println("sorted");
        numbers.forEach(System.out::println);

    }
}
