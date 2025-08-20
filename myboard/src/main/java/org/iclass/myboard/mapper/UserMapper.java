package org.iclass.myboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.myboard.dto.UserDto;

@Mapper
public interface UserMapper {
    UserDto selectUser(UserDto dto);
}
