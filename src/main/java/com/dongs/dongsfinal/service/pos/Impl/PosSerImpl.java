package com.dongs.dongsfinal.service.pos.Impl;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.service.pos.PosSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PosSerImpl implements PosSer {
    @Autowired
    public PurchaseDao purchaseDao;
    @Autowired
    public PosisitonDao posisitonDao;
    @Autowired
    public ReceiveDao receiveDao;
    @Autowired
    public StorageDao storageDao;



}
