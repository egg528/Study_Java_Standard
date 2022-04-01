package Chap14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.*;
import java.lang.*;

public class Java_Util_Function {
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("run");
        runnable.run();

        Supplier<Integer> supplier = () -> 5;
        System.out.println(supplier.get());

        Consumer<Integer> consumer = (a) -> System.out.println(a);
        consumer.accept(5);

        Function<Integer, Integer> function = (a) -> a+1;
        System.out.println(function.apply(5));

        Predicate<Integer> predicate = (a) -> a%2 == 0;
        System.out.println(predicate.test(10));

        // Predicate<T> 활용
        Predicate<String> isEmptyStr = (a) -> a.length() == 0;

        // 매개변수가 두 개인 함수형 인터페이스
        BiConsumer<String, String> addTwoStr = (a, b) -> System.out.println(a+" "+b);

        BiPredicate<String, String> isSameStr = (a, b) -> a.equals(b);

        BiFunction<String, String, String> biFunction = (a, b) -> a+b;

        // 매개 변수의 타입과 반환 타입이 같다면?
        UnaryOperator<String> unaryOperator = (a) -> "a = "+a;
        BinaryOperator<String> binaryOperator = (a, b) -> a+b;

        // 컬렉션 프레임웍의 메서드 중 함수형 인터페이스를 매개변수로 가지는 것들이 있다.

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) list.add(i);
        list.forEach((i) -> System.out.print(i+" "));

        System.out.println();
        list.removeIf((i) -> i%2 == 0);
        list.forEach((i) -> System.out.print(i+" "));
        System.out.println();


       // 기본형을 사용하는 함수형 인터페이스
        DoubleToIntFunction doubleToInt = (a) -> (int) a;
        IntSupplier s = () -> (int) Math.random()*100;




    }
}
