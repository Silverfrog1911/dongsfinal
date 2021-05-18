package com.dongs.dongsfinal.service.pur.Impl;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.model.Purchase;
import com.dongs.dongsfinal.service.pur.PurSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurSerImpl implements PurSer {

    @Autowired
    public PurchaseDao purchaseDao;
    @Autowired
    public PosisitonDao posisitonDao;
    @Autowired
    public ReceiveDao receiveDao;
    @Autowired
    public StorageDao storageDao;

    @Override
    public void updateStatus2WORK(String good_name) {
        purchaseDao.updateStatus2WORK(good_name);
    }

    @Override
    public void updateStatus2CHECKING(String good_name) {
        purchaseDao.updateStatus2CHECKING(good_name);
    }

    @Override
    public void updateStatus2RECEIVED(String good_name) {
        purchaseDao.updateStatus2RECEIVED(good_name);
    }

    @Override
    public Purchase selectBygoodName(String goodName) {
        return purchaseDao.selectBygoodName(goodName);
    }

    @Override
    public List<Purchase> selectAll() {
        return purchaseDao.selectAll();
    }

    @Override
    public int deleteBygoodName(String goodName) {
        purchaseDao.deleteBygoodName(goodName);
        return 0;
    }


}
