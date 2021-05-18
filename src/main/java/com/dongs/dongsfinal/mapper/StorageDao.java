package com.dongs.dongsfinal.mapper;

import com.dongs.dongsfinal.model.Storage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageDao {
    int deleteByPrimaryKey(Integer goodId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Integer goodId);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    Storage selectBygoodName(String goodName);

    void updateAmount(String goodName,int goodAmount);



}