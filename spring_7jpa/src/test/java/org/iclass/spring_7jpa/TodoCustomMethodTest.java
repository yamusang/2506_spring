package org.iclass.spring_7jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.iclass.spring_7jpa.entity.TodoEntity;
import org.iclass.spring_7jpa.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TodoCustomMethodTest {

  @Autowired
  private TodoRepository todoRepository;

  @Test
  void findBy1() {
    List<TodoEntity> list = todoRepository.findByCreatedAtAfter(LocalDateTime.of(2025, 8, 15, 0, 0, 0));
    log.info("2025-08-30 이후의 todo : {}", list);
    assertNotEquals(0, list.size());
  }

  @Test
  void findNative() {
    List<TodoEntity> list = todoRepository.findIncompleteTodosByUsernameNative("iclass");
    assertEquals(10, list.size());
    list = todoRepository.findIncompleteTodosByUsernameNative("himedia");
    assertNotEquals(10, list.size());
  }

  @Test
  void findJPQL() {

  }

}
