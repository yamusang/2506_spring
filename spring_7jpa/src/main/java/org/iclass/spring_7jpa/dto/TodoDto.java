package org.iclass.spring_7jpa.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.iclass.spring_7jpa.entity.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TodoDto {
  private Long id;
  private String title;
  private String username;
  private Boolean checked;
  private LocalDate todo_date; // 할일 날짜
  private LocalDateTime createAt; // 작성(저장) 날짜

  // 편의상 entity와 dto 사이의 변환 메소드 작성하기
  public static TodoDto of(TodoEntity entity) {
    return TodoDto.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .checked(entity.getChecked())
        .todo_date(entity.getTodo_date())
        .username(entity.getUsername())
        .createAt(entity.getCreatedAt())
        .build();
  }

  // save()- insert,update
  public static TodoEntity toEntity(TodoDto dto) {
    return TodoEntity.builder()
        // .id(dto.getId())
        .title(dto.getTitle())
        // .checked(dto.getChecked())
        .todo_date(dto.getTodo_date())
        .username(dto.getUsername())
        // .createdAt(dto.getCreateAt())
        .build();
  }

}
