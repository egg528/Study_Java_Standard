package Chap14;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class StreamMiddleOperation {
    public static void main(String[] args) {
        // skip과 limit
        IntStream.range(1, 100).skip(98).forEach(System.out::print); // 99
        System.out.println();


        IntStream.range(1, 100).limit(5).forEach(System.out::print); // 12345


        // distinct - 중복 제거
        // filter (매개변수로 predicate 필요) - 조건에 맞는 값만 남기기

        IntStream.of(1, 1, 1, 1, 1).distinct().forEach(System.out::print); // 1
        System.out.println();

        IntStream.range(1, 5).filter(i -> i%2 != 0).forEach(System.out::print); // 1, 3
        System.out.println();

        // sorted - Comparator로 스트림 정렬
        Stream<String> strStream = Stream.of("aaa", "ccc", "bbb");
        strStream.sorted((o1, o2) -> o1.compareTo(o2)).forEach(System.out::print); // aaa, bbb, ccc
        System.out.println();

        Stream<Integer> intStream = Stream.of(5, 4, 3, 2, 1);
        intStream.sorted((o1, o2) -> Integer.compare(o1, o2)).forEach(System.out::print); // 12345
    }
}
