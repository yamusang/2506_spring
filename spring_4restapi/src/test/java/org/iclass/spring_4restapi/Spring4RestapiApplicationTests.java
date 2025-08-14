package org.iclass.spring_4restapi;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.iclass.spring_4restapi.mapper.BuyMapper;
import org.iclass.spring_4restapi.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class Spring4RestapiApplicationTests {
	// 단위테스트 내용 : mapper 인터페이스의 구현체의 동작 확인
	// 참고 : 테스트 클래스는 필드 주입 사용합니다.
	// 테스트 메소드는 success, fail로 결과를 표시합니다.
	// ㄴ 검증 메소드 assertXXXX(테스트 대상) 입니다. XXXX는 기대값의 상태를 나타내는 키워드

	@Autowired
	private BuyMapper buyMapper;

	@Test
	void testName3() {

	}

	@Test
	void testName2() {

	}

	@Test
	void testName() {

	}

	@Autowired
	private ProductMapper productMapper;

	@Test
	void mapper1() {
		assertNotNull(buyMapper);
		assertNotNull(productMapper);

	}

	@Test
	void select() {
		log.info("{}", buyMapper.selectAllCountByYear());
		assertNotEquals(0, buyMapper.selectAllCountByYear().size());
	}

	@Test
	void mapper2() {
		assertNotNull(productMapper);
	}

}
