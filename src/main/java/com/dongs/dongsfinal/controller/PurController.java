package com.dongs.dongsfinal.controller;

import com.dongs.dongsfinal.mapper.PosisitonDao;
import com.dongs.dongsfinal.mapper.PurchaseDao;
import com.dongs.dongsfinal.mapper.ReceiveDao;
import com.dongs.dongsfinal.mapper.StorageDao;
import com.dongs.dongsfinal.model.Posisiton;
import com.dongs.dongsfinal.model.Purchase;
import com.dongs.dongsfinal.model.Receive;
import com.dongs.dongsfinal.model.Storage;
import com.dongs.dongsfinal.model.poly.PosisitonShow;
import com.dongs.dongsfinal.model.poly.PurchaseShow;
import com.dongs.dongsfinal.model.poly.ReceiveShow;
import com.dongs.dongsfinal.service.pos.PosSer;
import com.dongs.dongsfinal.service.pur.PurSer;
import com.dongs.dongsfinal.service.receive.ReceiveSer;
import com.dongs.dongsfinal.service.storage.StorageSer;
import com.dongs.dongsfinal.util.ResultUtils;
import com.dongs.dongsfinal.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public ResultVO RECEgrant(String goodName,int real_receive_amount) {
        System.out.println(goodName+"----RECEgrant");
        Receive receive = new Receive();
        receive.setPurchaseId(purSer.selectBygoodName(goodName).getPurchaseId());
        receive.setRealReceiveAmount(real_receive_amount);
        receiveSer.RECEinsert(receive);//此处尚未插入goodid，需要等待插入storage生成后插入
        if (storageSer.selectBygoodName(goodName)!=null&&purSer.selectBygoodName(goodName).getSku().equals( storageSer.selectBygoodName(goodName).getSku())){
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
    public ResultVO updateCheckingBygoodName(String goodName){
        System.out.println(goodName+"----updateCheckingBygoodName");
        purSer.updateStatus2CHECKING(goodName);
        return ResultUtils.success("update success!");
    }

    /**
     *收货验货=更新数据库中收货单表中收货单的状态为Received
     * @param goodName
     * @return
     */
    @PostMapping("/updateReceivedBygoodName")
    public ResultVO updateReceivedBygoodName(String goodName){
        System.out.println(goodName+"----updateReceivedBygoodName");

        purSer.updateStatus2RECEIVED(goodName);
        return ResultUtils.success("update success!");
    }

    /**
     * 删除Purchase表内的数据
     * @param goodName
     * @return
     */
    @PostMapping("/deleteBygoodName")
    public ResultVO deleteBygoodName(String goodName){
        purSer.deleteBygoodName(goodName);
        return ResultUtils.success("delete success!");
    }

    /**
     * 货位更新
     * @param receiveId
     * @return
     */
    @PostMapping("/updatePosition")
    public ResultVO updatePosition(Integer receiveId){
        System.out.println(receiveId+"----updatePosition");



//        //通过收获id查询收货信息 goodId，realReceiveAmount
//        Receive receive = receiveSer.selectById(receiveId);
//        //修改状态位RECEIVED
//        purSer.updateStatus2RECEIVED(storageSer.selectById(receive.getGoodId()).getGoodName());
//
//        int notInsert=receive.getRealReceiveAmount();
//        //货物每五十加入一个新货位，循环插入
//        while(notInsert!=0){
//
//            //如果大于等于50 插入50
//
//            //如果小于50 插入未插入量
//            int nowInsert=notInsert>=50?50:notInsert;
//            notInsert-=nowInsert;
//            Posisiton p=new Posisiton();
//            p.setGoodId(receive.getGoodId());
//            p.setCurrentamount(nowInsert);
//            posSer.insert(p);
//        }
        posSer.confirm(receiveId);

        return ResultUtils.successMsg("update success!");

    }

    /**
     * 查询 状态为 wait work
     * @return
     */
    @GetMapping("/selectWaitwork")
    public ResultVO selectWaitwork(){
        List<PurchaseShow> purchases = purSer.selectbyStatus("WAIT WORK");
        return ResultUtils.success(purchases);
    }

    /**
     * 查询 状态为 work
     * @return
     */
    @GetMapping("/selectWork")
    public ResultVO selectWork(){
        List<PurchaseShow> purchases = purSer.selectbyStatus("WORK");
        return ResultUtils.success(purchases);
    }

    /**
     * 查询 状态为 checking
     * @return
     */
    @GetMapping("/selectChecking")
    public ResultVO selectChecking(){
        List<PurchaseShow> purchases = purSer.selectbyStatus("CHECKING");
        return ResultUtils.success(purchases);
    }

    /**
     * 查询 状态为 work
     * @return
     */
    @GetMapping("/selectReceived")
    public ResultVO selectReceived(){
        List<PurchaseShow> purchases = purSer.selectbyStatus("RECEIVED");
        return ResultUtils.success(purchases);
    }

    /**
     * 查询 receive表
     * @return
     */
    @GetMapping("/selectReceive")
    public ResultVO selectReceive(){
        List<ReceiveShow> list=new ArrayList<>();


        List<Receive> receives = receiveSer.selectAll();
        for (Receive receive : receives) {
            ReceiveShow rs=new ReceiveShow();
            rs.setReceiveId(receive.getReceiveId());
            rs.setPurchaseId(receive.getPurchaseId());
            rs.setGoodId(receive.getGoodId());
            rs.setRealReceiveAmount(receive.getRealReceiveAmount());
            rs.setReceiveDate(receive.getReceiveDate());
            Purchase purchase = purSer.selectById(receive.getPurchaseId());
            rs.setPurchase(purchase);
            list.add(rs);
        }

        return ResultUtils.success(list);
    }

    /**
     * 查询 posisiton表
     * @return
     */
    @GetMapping("/selectPosisiton")
    public ResultVO selectPosisiton(){
        List<PosisitonShow> list=new ArrayList<>();


        List<Posisiton> posisitons = posSer.selectAll();

        for (Posisiton posisiton : posisitons) {
            PosisitonShow ps=new PosisitonShow();
            ps.setPosId(posisiton.getPosId());
            ps.setGoodId(posisiton.getGoodId());
            ps.setCurrentamount(posisiton.getCurrentamount());
            Storage storage = storageSer.selectById(ps.getGoodId());
            ps.setStorage(storage);
            list.add(ps);
        }

        return ResultUtils.success(list);
    }


    /**
     * 查询 storage表
     * @return
     */
    @GetMapping("/selectStorage")
    public ResultVO selectStorage(){
        List<Storage> storages = storageSer.selectAll();
        return ResultUtils.success(storages);
    }

}
