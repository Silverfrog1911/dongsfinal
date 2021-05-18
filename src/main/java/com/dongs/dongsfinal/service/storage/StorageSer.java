package com.dongs.dongsfinal.service.storage;

import com.dongs.dongsfinal.model.Storage;

public interface StorageSer {

    Storage selectBygoodName(String goodName);

    void STORinsert(Storage record);

    void updateAmount(String goodName,int goodAmount);

}
