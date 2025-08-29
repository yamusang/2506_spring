package org.iclass.spring_7jpa.repository;

import org.iclass.spring_7jpa.entity.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
  // JpaRepository<TodoEntity, Long>에서 상속받은 메소드는 바로 사용 가느이
  // ㄴ Junit 테스트로 확인
  // 커스텀 메소드 정의
  List<TodoEntity> findByUsername(String username); // where username =?

  Page<TodoEntity> findByUsername(String username, Pageable pageable);

  List<TodoEntity> findByUsernameOrderByCreatedAtDesc(String username);

  // where username =? order by createdAt desc
  List<TodoEntity> findByCreatedAt(LocalDateTime createdAt);

  List<TodoEntity> findByCreatedAtAfter(LocalDateTime createdAt);
  // where createAt >?

  boolean existsByUsername(String username);

  // 직접 SQL 작성

  // 1) 네이티브 SQL 예시 : nativeQuery = true 속성 필수
  // - FROM todo_test(테이블이름) AND done = 0 ( 컬럼명 done)
  @Query(value = "SELECT * FROM todo_test WHERE username = :username AND done = 0", nativeQuery = true)
  List<TodoEntity> findIncompleteTodosByUsernameNative(@Param("username") String username);

  // 2) JPQL(엔티티와 그 필드를 )
  // - FROM TodoEntity t(엔티티이름) AND t.checked = false(필드명 checked)
  @Query("SELECT t FROM TodoEntity t WHERE t.username = :username AND t.checked=false")
  List<TodoEntity> findIncompleteTodosByUsername(@Param("username") String username);

}
