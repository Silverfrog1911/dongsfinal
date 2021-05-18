package com.dongs.dongsfinal.mapper;

import com.dongs.dongsfinal.model.Purchase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDao {
    int deleteByPrimaryKey(Integer purchaseId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);

    /**
     * WORK
     * CHECKING
     * RECEIVED
     * @param goodName
     */
    void updateStatus2WORK(String goodName);
    void updateStatus2CHECKING(String goodName);
    void updateStatus2RECEIVED(String goodName);


    Purchase selectBygoodName(String goodName);


    List<Purchase> selectAll();

    int deleteBygoodName(String goodName);

}