package com.dongs.dongsfinal.service.pos;

import com.dongs.dongsfinal.model.Posisiton;

import java.util.List;

public interface PosSer {

    void insert(Posisiton posisiton);

    List<Posisiton> selectAll();

    void confirm(int receiveId);
}
