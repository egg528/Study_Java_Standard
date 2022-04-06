package Chap14;

import java.util.Arrays;
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

        // map() - 원하는 필드를 뽑거나 특정 형태로 변환해야할 때

        // peek() - 요소들을 소모하지 않으면서 출력해볼 수 있기에 연산 중간 과정을 확인할 수 있다.

        // mapToInt, Double, Long - Stream<T> 타입의 스트림을 기본형 스트림으로 변환할 때 사용
        // 기본형 스트림의 장점 중 하나는 특정 최종 연산을 제공한다는 점. ex - max, average max, min

        // flatMap - Stream<T[]> => Stream<T>
        Stream.of(new String[]{"I am a bird.", "I can fly"}).
                flatMap(line -> Stream.of(line.split(" ")))
                .forEach(System.out::println);



    }
}
