package methodReference;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by ryosuke on 2016/08/11.
 */
public class MethodReferenceDemo1 {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void print(Integer count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void main(String... args) {
        System.out.println("1 argument.");
        // ラムダ式でstaticメソッドをコール
        // 引数はあるが、戻り値がvoidのインターフェース
        Consumer<String> consumer1 = text -> MethodReferenceDemo1.print(text);
        consumer1.accept("call with lambda.");

        // メソッド参照でコール
        Consumer<String> consumer2 = MethodReferenceDemo1::print;
        consumer2.accept("call with method reference.");

        System.out.println();
        System.out.println("2 arguments.");
        BiConsumer<Integer, String> consumer3 = (count, text) -> MethodReferenceDemo1.print(count, text);
        consumer3.accept(3, "lambda");

        BiConsumer<Integer, String> consumer4 = MethodReferenceDemo1::print;
        consumer4.accept(3, "method reference");

        // ラムダ式内でオートアンボクシングを行う例
        Function<Integer, String> function1 = i -> String.valueOf(i);
        String result1 = function1.apply(10);

        // オートアンボクシングを伴うメソッド参照の例
        Function<Integer, String> function2 = String::valueOf;
        String result2 = function2.apply(20);


    }
}
