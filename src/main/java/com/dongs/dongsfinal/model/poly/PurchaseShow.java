package com.dongs.dongsfinal.model.poly;

import com.dongs.dongsfinal.model.Purchase;
import com.dongs.dongsfinal.model.Receive;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class PurchaseShow extends Purchase {

    private Receive receive;

}
