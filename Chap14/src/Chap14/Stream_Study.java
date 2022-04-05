package Chap14;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Study {
    public static void main(String[] args) {
        String[] strArr = {"bbb", "aaa", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        // 위 배열과 리스트를 스트림으로
        Stream<String> strStream1 = strList.stream();
        Stream<String> strStream2 = Arrays.stream(strArr);

        strStream2.sorted().forEach(System.out::println);
        strStream1.forEach(System.out::println);


        // Stream 생성 - (1) Collection
        // Collection.stream
        strList.stream();


        // Stream 생성 - (2) Arrays
        IntStream intStream = IntStream.of(1, 2, 3);
        String[] Arr = {"aaa", "bbb", "ccc"};
        Stream<String> stream = Arrays.stream(Arr);

        // 특정 범위의 정수가 포함된 Stream 만들기
        IntStream intStream1 = IntStream.range(1, 5); // 1, 2, 3, 4
        IntStream intStream2 = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5

        intStream1.forEach(System.out::print);
        System.out.println();
        intStream2.forEach(System.out::print);

        // 임의의 수가 포함된 스트림 만들기

        IntStream intStream3 = new Random().ints(); // 무한 스트림 생성
        intStream3.limit(5).forEach(System.out::println); // limit을 활용해 유한 스트림으로 변환
        IntStream intStream4 = new Random().ints(5); // 처음부터 유한 스트림으로 만들 수도 있다.

        new Random().ints(5).forEach(System.out::print);

        // 지정된 범위의 난수
        new Random().longs(1, 1000); // begin, end
        new Random().longs(10, 1, 100); // size, begin, end


        // iterate와 generate
        // Stream.iterate(0, n->n+2).forEach(System.out::println); 무한
        Stream.iterate(0, n->n+2).limit(1000).forEach(System.out::println);

        // generate
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        Stream.generate(() -> 1).limit(10).forEach(System.out::println);

        // Stream.generate(n -> n+2); 에러
        // Stream.iterate(Math::random); 에러
        // generate는 매개변수가 없는 람다식만 다룰 수 있다.

        // iterate와 generate의 경우 기본형 스트림 타입의 참조변수로 다룰 수 없다.
        // IntStream evenStream = Stream.iterate(0, n -> n+2);
        // DoubleStream randomStream = Stream.generate(Math::random);
        // 굳이 필요하다면 mapToInt 활용
        IntStream evenStream = Stream.iterate(0, n -> n+2).mapToInt(Integer::valueOf);
        Stream<Integer> integerStream = evenStream.boxed();

        // 파일 스트림
        // Stream<String> file = Files.lines();

        // 빈 스트림
        Stream empty = Stream.empty();

        // 스트림 연결
        Stream<String> stringStream = Stream.concat(strStream1, strStream2);
    }
}
