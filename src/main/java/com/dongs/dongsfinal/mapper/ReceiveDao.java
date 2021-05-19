package com.dongs.dongsfinal.mapper;

import com.dongs.dongsfinal.model.Receive;
import com.dongs.dongsfinal.model.poly.ReceiveShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceiveDao {
    int deleteByPrimaryKey(Integer receiveId);

    int insert(Receive record);

    int insertSelective(Receive record);

    Receive selectByPrimaryKey(Integer receiveId);

    int updateByPrimaryKeySelective(Receive record);

    int updateByPrimaryKey(Receive record);

    void updategoodIdBygoodName(int purchaseId,int goodId);

    List<Receive> selectAll();


}