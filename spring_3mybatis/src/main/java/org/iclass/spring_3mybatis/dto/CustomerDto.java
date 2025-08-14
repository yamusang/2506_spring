package org.iclass.spring_3mybatis.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
// @AllArgsConstructor // 모든 프로퍼티값 초기화하는 생성자 코드
@RequiredArgsConstructor // final 키워드 변수만 초기화 생성자
public class CustomerDto {
    private final String customerId;
    private final String name;
    private final String email;
    private final Integer age; // int로 하면 안되는 경우 : null 값이 있을 때 int에 저장 못합니다.
    private final Date regDate;
}
// 과거 마이바티스 3.4 이전 버전은 getter,setter, 기본생성자 없으면 오류 발생.
// -> 현재 버전은 문제 없이 정상 실행