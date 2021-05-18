package com.dongs.dongsfinal.mapper;

import com.dongs.dongsfinal.model.Purchase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseDao {
    int deleteByPrimaryKey(Integer purchaseId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}