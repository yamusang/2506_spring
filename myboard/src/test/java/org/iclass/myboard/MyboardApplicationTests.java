package org.iclass.myboard;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.iclass.myboard.mapper.CommunityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyboardApplicationTests {

	@Autowired
	private CommunityMapper communityMapper;

	@Test
	void selectAll() {
		assertNotEquals(1, communityMapper.selectAll());
	}

}
