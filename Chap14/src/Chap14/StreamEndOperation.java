package Chap14;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEndOperation {
    public static void main(String[] args) {

        // forEach()
        // 요소를 출력하는 용도로 많이 사용됨

        // 조건 검사
        IntStream intStream = IntStream.range(1, 100);

        System.out.println(intStream.allMatch(s -> s <= 100));
        // System.out.println(intStream.allMatch(s -> s <= 100)); 최종 연산임으로 오류 발생

        // count(), sum(), average(), max(), min() 통계 연산들

        // reduce()
        // intStream.reduce(0, (a, b) -> a+b) 내부 로직
        // int a = 0;
        // for(int b : stream)
        // a = a + b;


    }
}
