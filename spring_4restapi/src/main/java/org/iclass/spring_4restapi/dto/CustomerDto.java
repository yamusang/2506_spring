package org.iclass.spring_4restapi.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    // dto 입력값의 유효성 패턴 설정. 검사
    @NotBlank(message = "customerId는 필수값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,}$", message = "영문자와 숫자로 구성된 4글자 이상이어야 합니다.")
    private final String customerId;

    @NotBlank(message = "이름은 필수값 입니다.")
    private final String name;

    @Email
    private final String email;

    @Min(value = 0, message = "나이는 0 이상입니다.")
    @Max(value = 100, message = "나이는 100 이하입니다.")
    private final Integer age; // int로 하면 안되는 경우 : null 값이 있을 때 int에 저장 못합니다.
    private final Date regDate;
}
// 과거 마이바티스 3.4 이전 버전은 getter,setter, 기본생성자 없으면 오류 발생.
// -> 현재 버전은 문제 없이 정상 실행