package com.dongs.dongsfinal.controller;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.model.Receive;
import com.dongs.dongsfinal.model.Storage;
import com.dongs.dongsfinal.service.pos.PosSer;
import com.dongs.dongsfinal.service.pur.PurSer;
import com.dongs.dongsfinal.service.receive.ReceiveSer;
import com.dongs.dongsfinal.service.storage.StorageSer;
import com.dongs.dongsfinal.util.ResultUtils;
import com.dongs.dongsfinal.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Purchase")
public class PurController {


    @Autowired
    public PurSer purSer;
    @Autowired
    public PosSer posSer;
    @Autowired
    public ReceiveSer receiveSer;
    @Autowired
    public StorageSer storageSer;

    /**
     * 收货授权
     * @param goodName
     * @param real_receive_amount
     * @return
     */
    @PostMapping("/RECEgrant")
    private ResultVO RECEgrant(String goodName,int real_receive_amount) {

        Receive receive = new Receive();
        receive.setPurchaseId(purSer.selectBygoodName(goodName).getPurchaseId());
        receive.setRealReceiveAmount(real_receive_amount);
        receiveSer.RECEinsert(receive);//此处尚未插入goodid，需要等待插入storage生成后插入

        if (purSer.selectBygoodName(goodName).getSku() == storageSer.selectBygoodName(goodName).getSku()){
            int now_amount = storageSer.selectBygoodName(goodName).getGoodAmount();
            now_amount = now_amount + real_receive_amount;
            storageSer.updateAmount(goodName,now_amount);
            return ResultUtils.success("Success ! ");
        }else{
            Storage storage = new Storage();
            //storage = storageSer.selectBygoodName(goodName);
            storage.setGoodAmount(real_receive_amount);
            storage.setGoodName(purSer.selectBygoodName(goodName).getGoodName());
            storage.setSku(purSer.selectBygoodName(goodName).getSku());
            storageSer.STORinsert(storage);
        }

        receiveSer.updategoodIdBygoodName(purSer.selectBygoodName(goodName).getPurchaseId(),storageSer.selectBygoodName(goodName).getGoodId());

        purSer.updateStatus2WORK(goodName);

        return ResultUtils.success("Success ! ");
    }

    /**
     * 收货验货=更新数据库中收货单表中收货单的状态为Checking
     * @param goodName
     * @return
     */
    @PostMapping("/updateCheckingBygoodName")
    private ResultVO updateCheckingBygoodName(String goodName){
        purSer.updateStatus2CHECKING(goodName);
        return ResultUtils.success("update success!");
    }

    /**
     *收货验货=更新数据库中收货单表中收货单的状态为Received
     * @param goodName
     * @return
     */
    @PostMapping("/updateReceivedBygoodName")
    private ResultVO updateReceivedBygoodName(String goodName){
        purSer.updateStatus2RECEIVED(goodName);
        return ResultUtils.success("update success!");
    }

    /**
     * 删除Purchase表内的数据
     * @param goodName
     * @return
     */
    @PostMapping("/deleteBygoodName")
    private ResultVO deleteBygoodName(String goodName){
        purSer.deleteBygoodName(goodName);
        return ResultUtils.success("delete success!");
    }


}
