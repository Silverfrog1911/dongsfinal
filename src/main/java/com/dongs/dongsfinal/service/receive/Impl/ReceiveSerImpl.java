package com.dongs.dongsfinal.service.receive.Impl;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.model.Receive;
import com.dongs.dongsfinal.service.receive.ReceiveSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveSerImpl implements ReceiveSer {
    @Autowired
    public PurchaseDao purchaseDao;
    @Autowired
    public PosisitonDao posisitonDao;
    @Autowired
    public ReceiveDao receiveDao;
    @Autowired
    public StorageDao storageDao;

    @Override
    public void RECEinsert(Receive record) {
        receiveDao.insert(record);
    }

    @Override
    public void updategoodIdBygoodName(int purchaseId, int goodId) {
        receiveDao.updategoodIdBygoodName(purchaseId,goodId);
    }
}
