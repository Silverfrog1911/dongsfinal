package com.dongs.dongsfinal.service.storage.Impl;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.model.Storage;
import com.dongs.dongsfinal.service.storage.StorageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageSerImpl implements StorageSer {
    @Autowired
    public PurchaseDao purchaseDao;
    @Autowired
    public PosisitonDao posisitonDao;
    @Autowired
    public ReceiveDao receiveDao;
    @Autowired
    public StorageDao storageDao;

    @Override
    public Storage selectBygoodName(String goodName) {
        return storageDao.selectBygoodName(goodName);
    }

    @Override
    public void STORinsert(Storage record) {
        storageDao.insert(record);
    }

    @Override
    public void updateAmount(String goodName, int goodAmount) {
        storageDao.updateAmount(goodName,goodAmount);
    }

    @Override
    public List<Storage> selectAll() {
        return storageDao.selectAll();
    }

    @Override
    public Storage selectById(int storageId) {
        return storageDao.selectByPrimaryKey(storageId);
    }
}
