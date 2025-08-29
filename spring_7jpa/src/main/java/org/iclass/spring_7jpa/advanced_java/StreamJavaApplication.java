package org.iclass.spring_7jpa.advanced_java;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamJavaApplication {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // 스트림 API - 메소드 체이닝 형식. 중간연산 리턴 타입이 Stream으로 동일하기 때문에 가능

        numbers.stream().filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(i)); // 최종연산
        // .forEach(System.out::println);

        List<String> words = List.of("apple", "banana", "cherry");
        // 2)
        List<String> newList = words.stream()
                // .map(str -> str.toUpperCase()) // 중간 연산 : 변환(Function 인터페이스)
                .map(String::toUpperCase)
                .collect(Collectors.toList()); // 최종 연산 : 새로운 List 리턴

        System.out.println("대문자 단어 리스트 : " + newList);

        // 3) reduce 최종 연산 : 값의 누적 합계 또는 문자열의 연결에 활용
        int total = numbers.stream()
                // .reduce(0, Integer::sum); // Integer.sum(a,b) //a에 b를 누적해서 더하기
                .reduce(0, (a, b) -> Integer.sum(a, b));

        System.out.println("정수 합계 : " + total);

        // 퀴즈 : numbers 리스트 값의 홀수 합계
        int oddTotal = numbers.stream()
                .filter(n -> n % 2 == 1)
                .reduce(0, Integer::sum);
        System.out.println("홀수 합계 : " + oddTotal);

        // 4)
        List<String> words2 = List.of("apple", "banana", "cherry");

        words2.stream()
                // .sorted() // 기본 오름차순
                .sorted(Comparator.reverseOrder()) // 비교자를 내림차순으로
                .forEach(System.out::println);

        // 5) Integer Stream을 직접 만들기
        IntStream.range(1, 10).forEach(System.out::print);
        System.out.println();
        // IntStream.range 메소드로
        IntStream.rangeClosed(1, 10).forEach(System.out::print);
    }
}
