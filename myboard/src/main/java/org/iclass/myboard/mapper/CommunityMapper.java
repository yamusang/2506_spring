package org.iclass.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.myboard.dto.CommunityDto;

@Mapper
public interface CommunityMapper {
    List<CommunityDto> selectAll();

    CommunityDto selectByPk(int idx);

    int insertCommunity(CommunityDto dto);

    int deleteCommunity(int idx);
}
