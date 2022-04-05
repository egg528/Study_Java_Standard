## Chap14 람다와 스트림

- 람다식
  - 메서드를 하나의 식으로 표현한 것
  - 아래와 같은 메서드를 단순한 식으로 표현하여 더 간결한 코드를 작성할 수 있다.
    - ```java 
      int method() {
          return (int) (Math.random()*5)+1);
      }
      ```
    - ```java 
      Arrays.setAll(arr, (i) -> (int) (Math.random()*5)+1)
      ```
  - 메서드를 변수처럼 다룰 수 있게 된다.