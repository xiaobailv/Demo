package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TblQrcAllTmp extends TblQrcAllTmpKey {
    private String transDateTime;

    private String commonId;

    private String thirdMchtNo;

    private String mchtNo;

    private String childMchtNo;

    private String termId;

    private String plOrderNo;

    private String unOrderNo;

    private String mcOrderNo;

    private String userId;

    private String transType;

    private String transStat;

    private String payBank;

    private String currCd;

    private BigDecimal transAmt;

    private BigDecimal entRedAmt;

    private String plreOrderNo;

    private String mcreOrderNo;

    private BigDecimal refundAmt;

    private BigDecimal entRedRefundAmt;

    private String refundType;

    private String refundStat;

    private String proName;

    private String mchtDatePackage;

    private BigDecimal transFee;

    private BigDecimal feeRate;

    private String termType;

    private String localSettleIn;

    private String storeNo;

    private String mchtName;

    private String cashier;

    private BigDecimal noCouponAmt;

    private BigDecimal actualAmt;

    private BigDecimal settleAmt;

    private BigDecimal acqCostFee;

    private String threeColums;

    private String insIdCd;

    private String transDate;

    private String transTime;

    private BigDecimal preSubsidyFee;

    private BigDecimal preSubsidyRate;

    private String employInsIdCd;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String reserve4;

    private String reserve5;

    private String reserve6;

    private String reserve7;
}