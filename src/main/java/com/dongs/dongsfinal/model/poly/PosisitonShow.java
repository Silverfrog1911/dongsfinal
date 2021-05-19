package com.dongs.dongsfinal.model.poly;

import com.dongs.dongsfinal.model.Posisiton;
import com.dongs.dongsfinal.model.Storage;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class PosisitonShow extends Posisiton {

    private Storage storage;

}
