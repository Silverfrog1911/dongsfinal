package com.dongs.dongsfinal.mapper;

import com.dongs.dongsfinal.model.Posisiton;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PosisitonDao {
    int deleteByPrimaryKey(Integer posId);

    int insert(Posisiton record);

    int insertSelective(Posisiton record);

    Posisiton selectByPrimaryKey(Integer posId);

    int updateByPrimaryKeySelective(Posisiton record);

    int updateByPrimaryKey(Posisiton record);



}