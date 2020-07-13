package com.liushihao.dao;

import com.liushihao.entity.TblDatSpecTuihuoFee;
import com.liushihao.entity.TblLogBankSettle;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilsTest {

    @Test
    public void tblLogBankSettleToTblDatSpecTuihuoFee() {
        TblLogBankSettle source = new TblLogBankSettle(null, "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", 1L, 1L, "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", 1L, "1", 1L, 1L, "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", 1L, "1", "1", "1", "1", "1", 1, "1", "1", "1", 1, "1", "1", "1", "1", "1", "1", 1L, 1L, 1L, 1L, 1L, 1L, 1, 1, 1, 1, 1, 1, 1L, 1L, 1L, 1L, 1L, 1L, 1, 1, 1, 1, 1, 1, "1", "1", "1", "1", "1", "1");
        TblDatSpecTuihuoFee target = new TblDatSpecTuihuoFee();
        target.setPriKey("1");
        BeanUtils.copyProperties(source, target);
        System.out.println("target = " + target);
    }
}
