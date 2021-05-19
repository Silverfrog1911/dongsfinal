package com.dongs.dongsfinal.service.pur;

import com.dongs.dongsfinal.model.Purchase;
import com.dongs.dongsfinal.model.poly.PurchaseShow;

import java.util.List;

public interface PurSer {

    /**
     * WORK
     * CHECKING
     * RECEIVED
     * @param good_name
     */
    void updateStatus2WORK(String good_name);
    void updateStatus2CHECKING(String good_name);
    void updateStatus2RECEIVED(String good_name);


    Purchase selectBygoodName(String goodName);

    List<Purchase> selectAll();

    List<PurchaseShow> selectbyStatus(String status);

    Purchase selectById(int purchaseId);


    int deleteBygoodName(String goodName);


}
