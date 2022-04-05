package Chap14;


import java.util.*;

public class Functional_Interface {
    public static void main(String[] args) {

        // 익명 객체로 인터페이스 구현하기
        MyFunction myFunction = new MyFunction() {
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        // 람다식과 MyFunction의 max 메서드 선언부가 일치한다.
        MyFunction myFunction1 = (int a, int b) -> a > b ? a : b;

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list.get(0) == 5);
        Collections.sort(list, (s1, s2) -> Integer.compare(s1, s2));
        System.out.println(list.get(0) == 1);


        // 함수형 인터페이스를 매개변수로 사용할 때 1. 함수형 인터페이스를 타입으로 가지는 참조 변수를 넣는 방법과 2. 람다식을 넣는 방법 2가지가 있다.
        // 즉, 변수처럼 메서드를 주고받는 것이 가능하다.
        // 실제로는 객체를 주고 받는 것이라 새로운 것은 아니지만 코드가 훨씬 간결해진다.
        method1((a, b) -> a+b); // == 3


        // 람다식은 익명의 객체이기 때문에 타입이 없다.
        // 때문에 실제로는 람다식 좌측 부분에 (MyFunction2)가 생략된 것이다.
        // 하지만 오직 함수형 인터페이스로만 형변환이 가능하다.
        MyFunction2 myFunction2 = () -> System.out.println("wow");

        // Object obj = () -> System.out.println("wow"); -> 에러
        // 함수형 인터페이스로 형변환 후 Object로 형변환 가능 - (Object) 생략
        Object obj = (MyFunction2) () -> System.out.println("wow");


    }

    static void method1(MyFunction myFunction){
        System.out.println(myFunction.max(1, 2));
    }

    @FunctionalInterface
    interface MyFunction2{
        public abstract void method();
    }

    @FunctionalInterface
    interface MyFunction{
        public abstract  int max(int a, int b);
    }
}

