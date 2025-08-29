package org.iclass.spring_7jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.iclass.spring_7jpa.dto.Gender;
import org.iclass.spring_7jpa.entity.UserAccountEntity;
import org.iclass.spring_7jpa.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserAccountRepositoryTest {

  @Autowired
  UserAccountRepository userAccountRepository;

  @Test
  void saveOne() {
    UserAccountEntity entity = UserAccountEntity.builder()
        .userid("yamusang")
        .username("야무상")
        .password("1111")
        .birth(LocalDate.of(2005, 03, 8))
        .gender(Gender.F)
        .email("ttobiyam@korea.kr")
        .build();
    UserAccountEntity savEntity = userAccountRepository.save(entity);
    log.info("{}", savEntity);
    assertNotNull(savEntity);
  }
}
