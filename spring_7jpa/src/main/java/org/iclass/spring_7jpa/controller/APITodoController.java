package org.iclass.spring_7jpa.controller;

import org.iclass.spring_7jpa.dto.TodoDto;
import org.iclass.spring_7jpa.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class APITodoController {

  private final TodoService todoService;

  // POST /api/todos
  @PostMapping("/api/todos")
  public ResponseEntity<TodoDto> todoSave(@RequestBody TodoDto dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(todoService.write(dto));
  }

  // GET /api/todos/{username}
  @GetMapping("/api/todos/{username}")
  public ResponseEntity<?> userList(@PathVariable String username) {
    return ResponseEntity.ok().body(todoService.userList(username));
  }

}
