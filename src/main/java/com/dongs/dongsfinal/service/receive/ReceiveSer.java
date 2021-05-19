package com.dongs.dongsfinal.service.receive;

import com.dongs.dongsfinal.model.Receive;

import java.util.List;

public interface ReceiveSer {

    void RECEinsert(Receive record);

    void updategoodIdBygoodName(int purchaseId,int goodId);


    Receive selectById(int receiveId);

    List<Receive> selectAll();

}
