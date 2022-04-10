package Chap14;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collect {
    public static void main(String[] args) {

        //Collector 클래스가 제공하는 static 메서드들에 대해 알아보자

        // 스트림을 컬렉션과 배열로...
        Stream<String> strStream = Stream.of("abc", "bcd", "cde");
        Stream<String> strStream2 = Stream.of("abc", "bcd", "cde");
        Stream<String> strStream3 = Stream.of("abc", "bcd", "cde");
        Stream<String> strStream4 = Stream.of("abc", "bcd", "cde");

        List<String> strList = strStream.collect(Collectors.toList());
        ArrayList<String> strArrayList = strStream2.collect(Collectors.toCollection(ArrayList::new));
        Map<String, Integer> map = strStream3.collect(Collectors.toMap(p -> p, p -> p.length()));
        String[] strArray = strStream4.toArray(String[]::new);

        // 통계 - 이후에 groupingBy와 함께 다루자

        // 리듀싱 - reducing()
        // IntStream의 경우 매개변수 3개짜리 collect만 있기에 매개변수 1개 짜리 collect를 사용하려면 boxed활용 필요

        IntStream intStream = new Random().ints(1, 46).distinct().limit(6);

        long sum = intStream.boxed().collect(Collectors.reducing(0, (a, b) -> a+b ));

        // 문자열 결합
        Stream<String> strStream5 = Stream.of("abc", "bcd", "cde");
        String join = strStream5.collect(Collectors.joining(", "));
        System.out.println(join);

        // 그룹화와 분할 groupBy(), partitioningBy()
        Stream<Student> stuStream = Stream.of(
                new Student("a", true, 1, 1, 100),
                new Student("b", true, 2, 1, 200),
                new Student("c", false, 3, 1, 300),
                new Student("d", true, 1, 2, 100),
                new Student("e", true, 2, 1, 200),
                new Student("f", false, 3, 1, 300),
                new Student("g", true, 1, 2, 100)
        );

        Map<Boolean, List<Student>> stuBySex = stuStream.
                collect(Collectors.partitioningBy(Student::isMale));

        Stream<Student> stuStream1 = Stream.of(
                new Student("a", true, 1, 1, 100),
                new Student("b", true, 2, 1, 200),
                new Student("c", false, 3, 1, 300),
                new Student("d", true, 1, 2, 100),
                new Student("e", true, 2, 1, 200),
                new Student("f", false, 3, 1, 300),
                new Student("g", true, 1, 2, 100)
        );

        // 기본 분할 + 통계 정보
        Map<Boolean, Long> stuNumBySex = stuStream1.collect(Collectors.
                partitioningBy(Student::isMale, Collectors.counting()));

        for(Long cnt : stuNumBySex.values()) System.out.println(cnt);


        // groupingBy()에 의한 분류
        Stream<Student> stuStream2 = Stream.of(
                new Student("a", true, 1, 1, 100),
                new Student("b", true, 2, 1, 200),
                new Student("c", false, 3, 1, 300),
                new Student("d", true, 1, 2, 100),
                new Student("e", true, 2, 1, 200),
                new Student("f", false, 3, 1, 300),
                new Student("g", true, 1, 2, 100)
        );

        // Map<Integer, List<Student>> stuByBan = stuStream2.collect(Collectors.groupingBy(Student::getBan));
        Map<Integer, Set<Student>> stuByBan = stuStream2.collect(Collectors.groupingBy(Student::getBan,
                Collectors.toSet()));

        Stream<Student> stuStream3 = Stream.of(
                new Student("a", true, 1, 1, 100),
                new Student("b", true, 2, 1, 200),
                new Student("c", false, 3, 1, 300),
                new Student("d", true, 1, 2, 100),
                new Student("e", true, 2, 1, 200),
                new Student("f", false, 3, 1, 300),
                new Student("g", true, 1, 2, 100)
        );

        Map<Student.LEVEL, Long> stuByLevel = stuStream3
                .collect(Collectors.groupingBy(s ->{
                   if(s.getScore() >= 200) return Student.LEVEL.HIGH;
                   else if(s.getScore() >= 100) return Student.LEVEL.MID;
                   else return Student.LEVEL.LOW;
                }, Collectors.counting()));

        // 학년별 그룹화 후 반별 그룹화

        Stream<Student> stuStream4 = Stream.of(
                new Student("a", true, 1, 1, 100),
                new Student("b", true, 2, 1, 200),
                new Student("c", false, 3, 1, 300),
                new Student("d", true, 1, 2, 100),
                new Student("e", true, 2, 1, 200),
                new Student("f", false, 3, 1, 300),
                new Student("g", true, 1, 2, 100)
        );

        Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = stuStream4.collect(
                Collectors.groupingBy(Student::getHak,
                Collectors.groupingBy(Student::getBan)));

        // 학년별 각 반의 1등
        // Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = stuStream4.collect(
        //                Collectors.groupingBy(Student::getHak,
        //                Collectors.groupingBy(Student::getBan,
        //                Collectors.collectingAndThen(MaxBy(comparingInt(Student::getScore)),
        //                Optional::get
        //                )
        //            )
        //        ));

    }
}