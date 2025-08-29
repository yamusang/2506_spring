package org.iclass.spring_7jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "todo_test") // 따로 설정하지 않으면 테이블명은 Todoentity입니다.
@Entity
public class TodoEntity {

  @Id // Pk
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Pk의 정수값 생성 방법(전략)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String username;

  @Column(name = "done", columnDefinition = "NUMBER(1)")
  @Builder.Default
  private Boolean checked = false;

  @Column(nullable = false)
  private LocalDate todo_date;

  // createdAt(camel case)는 컬럼명이 created_at(snake case)로 만들어집니다.
  // @Transient // 엔티티 필드 항목에서 제외하고 저장할 때
  // @Column(insertable = false)
  private LocalDateTime createdAt;

  @PrePersist // save 메소드 호출 -> prePersist -> db에 sql insert 전에 컬럼 값을 먼저 저장
  public void createdDate() {
    this.createdAt = LocalDateTime.now();// 현재 날짜와 시간
    // this.checked = false;
    // 테이블은 값은 반영이 안됩니다. entity 필드의 값이 null이면 null 저장.

    // @Transient //엔티티 필드 항목에서 제외하고 저장/조회할 때(참고. 여기서는 사용 안함.)
  }
  // ⭕ create table로 만들어진 테이블에 기본값 있을 때 (예시 : created_at default sysdate)
  // 1) insert into 테이블 (title) value('테스트') => 기본값 필드는 적용
  // ㄴ insert에서 제외할 컬럼은 @Column(insertable=false) 속성 설정
  // ⭕ 엔티티의 기본값 설정 방법 : 테이블에 기본값 없음
  // 2) insert into 테이블(title,created_at) value('테스트',null) => 기본값 필드는 적용 X
  // ㄴ @Prepersist에서 기본값 저장
}
