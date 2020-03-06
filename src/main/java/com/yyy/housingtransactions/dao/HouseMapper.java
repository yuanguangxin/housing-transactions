package com.yyy.housingtransactions.dao;

import com.yyy.housingtransactions.model.House;
import com.yyy.housingtransactions.model.vo.HouseQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(House record);

    House selectByPrimaryKey(Long id);

    int updateByPrimaryKey(House record);

    List<House> getAll(@Param("content") String content);

    List<House> query(HouseQueryVo houseQueryVo);

    List<House> selByUserId(@Param("userId") Long userId);
}