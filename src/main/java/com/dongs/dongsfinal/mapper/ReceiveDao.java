package com.dongs.dongsfinal.mapper;

import com.dongs.dongsfinal.model.Receive;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceiveDao {
    int deleteByPrimaryKey(Integer receiveId);

    int insert(Receive record);

    int insertSelective(Receive record);

    Receive selectByPrimaryKey(Integer receiveId);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);

    void updategoodIdBygoodName(int purchaseId,int goodId);



}