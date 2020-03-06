package com.yyy.housingtransactions.dao;

import com.yyy.housingtransactions.model.Watch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WatchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Watch record);

    Watch selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Watch record);

    List<Watch> selByUserId(@Param("userId") Long userId);

    Watch selByUserIdAndHouseId(@Param("userId")Long userId,@Param("houseId")Long houseId);

    int delByUserIdAndHouseId(@Param("userId") Long userId,@Param("houseId")Long houseId);
}