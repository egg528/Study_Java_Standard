package Chap14;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {

        // method reference는 람다식을 조금 더 간략하게 표현하는 방법
        Function<String, Integer> function1 = (i) -> Integer.parseInt(i);
        Function<String, Integer> MR = Integer::parseInt;
        // Function<String, String> MR = Integer::parseInt; 에러

        BiFunction<String, String, Boolean> isEqual = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> MR1 = String::equals;

    }
}
