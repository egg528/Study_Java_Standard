package Chap14;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalExample {
    public static void main(String[] args) {

        // Optional<T>은 지네릭 클래스로 "T타입의 객체"를 감싸는 래퍼 클래스

        // Optional 생성하기
        Optional<String> optVal = Optional.of("abc");
        Optional<String> optValNull = Optional.ofNullable(null);

        // Optional은 값을 가져올 때 get() 이용
        // Null일 경우 다른 값을 가져오려면 Else 활용
        System.out.println(optVal);
        System.out.println(optVal.get());
        System.out.println(optValNull.orElse("Else"));
        System.out.println(optValNull.orElseGet(String::new));

        // Optional 객체에도 filter, map, flatMap을 사용할 수 있다.
        System.out.println(
                Optional.of("123").filter(x -> x.length() > 0)
                        .map(Integer::parseInt)
                        .orElse(-1)
        );

        // isPresent()는 Optional이 null인지 여부를 boolean타입으로 출력한다.
        System.out.println(Optional.ofNullable(null).isPresent());

        OptionalInt optInt = OptionalInt.of(3);


        // Optional은 언제 사용할까?
        // Null값을 가질 수 있는 데이터의 경우 유용한 메서드를 많이 제공해준다.
        // 즉, Null값이 있을 수 있는 데이터를 다룰 때 Optional로 데이터를 감싸서 사용할 것 같다.

        

    }

}
