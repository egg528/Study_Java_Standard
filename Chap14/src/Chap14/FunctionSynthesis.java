package Chap14;

import java.util.function.*;


public class FunctionSynthesis {

    public static void main(String[] args) {
        Function<String, Integer> function1 = (a) -> a.length();
        Function<Integer, String> function2 = (a) -> String.valueOf(a);

        Function<String, String> synthesis1 = function1.andThen(function2);
        Function<String, String> synthesis2 = function2.compose(function1);

        Predicate<Integer> isUnder100 = i -> i < 100;
        System.out.println(isUnder100.test(99));

        Predicate<String> temp = Predicate.isEqual("CHECK");
        System.out.println(temp.test(new String("CHECK")));



    }

}
