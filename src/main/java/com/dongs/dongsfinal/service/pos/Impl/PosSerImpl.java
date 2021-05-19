package com.dongs.dongsfinal.service.pos.Impl;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.model.Posisiton;
import com.dongs.dongsfinal.model.Receive;
import com.dongs.dongsfinal.service.pos.PosSer;
import com.dongs.dongsfinal.service.pur.PurSer;
import com.dongs.dongsfinal.service.receive.ReceiveSer;
import com.dongs.dongsfinal.service.storage.StorageSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    public PurSer purSer;
    @Autowired
    public ReceiveSer receiveSer;
    @Autowired
    public StorageSer storageSer;

    @Override
    public void insert(Posisiton posisiton) {
        posisitonDao.insert(posisiton);
    }

    @Override
    public List<Posisiton> selectAll() {
        return posisitonDao.selectAll();
    }

    @Transactional
    @Override
    public void confirm(int receiveId) {
        //通过收获id查询收货信息 goodId，realReceiveAmount
        Receive receive = receiveSer.selectById(receiveId);
        //修改状态位RECEIVED
        purSer.updateStatus2RECEIVED(storageSer.selectById(receive.getGoodId()).getGoodName());

        int notInsert=receive.getRealReceiveAmount();
        //货物每五十加入一个新货位，循环插入
        while(notInsert!=0){

            //如果大于等于50 插入50

            //如果小于50 插入未插入量
            int nowInsert=notInsert>=50?50:notInsert;
            notInsert-=nowInsert;
            Posisiton p=new Posisiton();
            p.setGoodId(receive.getGoodId());
            p.setCurrentamount(nowInsert);
            this.insert(p);
        }
    }
}
