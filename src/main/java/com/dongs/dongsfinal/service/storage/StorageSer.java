package com.dongs.dongsfinal.service.storage;

import com.dongs.dongsfinal.model.Storage;

import java.util.List;

public interface StorageSer {

    Storage selectBygoodName(String goodName);

    void STORinsert(Storage record);

    void updateAmount(String goodName,int goodAmount);

    List<Storage> selectAll();

    Storage selectById(int storageId);

}
