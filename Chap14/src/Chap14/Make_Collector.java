package Chap14;

public class Make_Collector {
    public static void main(String[] args) {
        // Collector를 구현하기 위해서는 4개의 람다식을 작성하면 된다.

        // (1) supplier() - 작업 결과를 저장할 공간을 제공

        // (2) accumulator() - 스트림의 요소를 수집할 방법을 제공

        // (3) combiner() - 두 저장공간을 병합할 방법을 제공

        // (4) finisher() - 결과를 최종적으로 변환할 방법을 제공

        // (5) characteristics() - 작업의 속성에 대한 정보를 제공. ex) 병렬 가능 작업, 순서 유지 필요 x 작업, finisher()가 항등 함수인 작업
        
    }
}
