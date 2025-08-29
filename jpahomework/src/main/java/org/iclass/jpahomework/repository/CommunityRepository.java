package org.iclass.jpahomework.repository;

import java.util.List;

import org.iclass.jpahomework.dto.CommunityListDto;
import org.iclass.jpahomework.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {

  @Query(value = "SELECT count(*) FROM community", nativeQuery = true)
  int getAllCount();

  @Query(value = "SELECT idx,writer,title,content,readcount,CAST(createdat AS DATE) AS createdat,ip,commentcount FROM (SELECT rownum r ,f.* from (SELECT * FROM community  ORDER BY idx DESC) f) WHERE r BETWEEN :startNo AND :endNo", nativeQuery = true)
  List<CommunityListDto> selectPageList(@Param("startNo") int startNo, @Param("endNo") int endNo);
}
