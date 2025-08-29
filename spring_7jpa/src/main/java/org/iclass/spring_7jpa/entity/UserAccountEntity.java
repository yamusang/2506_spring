package org.iclass.spring_7jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.iclass.spring_7jpa.dto.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@Table(name = "user_account")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountEntity {

  @Id
  private String userid;

  @Column(nullable = false)
  private String username;

  private String password;

  private LocalDate birth;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  private String email;

  private LocalDateTime regdate;

  @PrePersist // sql insert 전에 컬럼 값을 먼저 저장
  public void createdDate() {
    this.regdate = LocalDateTime.now();// 현재 날짜와 시간
  }

  // @Enumerated(EnumType.STRING) //열거형 타입을 상수 이름으로 문자열 처리
}
