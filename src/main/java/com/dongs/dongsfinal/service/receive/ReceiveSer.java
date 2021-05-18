package com.dongs.dongsfinal.service.receive;

import com.dongs.dongsfinal.model.Receive;

public interface ReceiveSer {

    void RECEinsert(Receive record);

    void updategoodIdBygoodName(int purchaseId,int goodId);

}
