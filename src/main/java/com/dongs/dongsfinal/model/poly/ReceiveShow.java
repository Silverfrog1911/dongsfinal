package com.dongs.dongsfinal.model.poly;

import com.dongs.dongsfinal.model.Purchase;
import com.dongs.dongsfinal.model.Receive;
import com.dongs.dongsfinal.model.Storage;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ReceiveShow extends Receive {

    private Purchase purchase;

}
