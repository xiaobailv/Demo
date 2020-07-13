package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TblDatSpecTuihuoFee {
    private String priKey;

    private String localSettleIn;

    private String settleDt;

    private String issIn;

    private String transId;

    private String rawTransId;

    private String transTp;

    private String transClass;

    private String settleInsIdCd;

    private String msgTp;

    private String priAcctNo;

    private String procCd;

    private Long transAt;

    private Long transSettleAt;

    private String sysTraNo;

    private String cardExpiredDate;

    private String transmsnDtTm;

    private String mchntTp;

    private String posEntryMdCd;

    private String cardSeqNum;

    private String posCondCd;

    private String posPinCapCd;

    private String acqInsIdCd;

    private String retriRefNo;

    private String authIdRespCd;

    private String respCd;

    private String termId;

    private String mchntCd;

    private String rcvInsIdCd;

    private String issInsIdCd;

    private String termSeqNum;

    private Long feeAmt;

    private String currCd;

    private Long acctBalance;

    private Long authSumAmt;

    private String msgTypeId;

    private String batchNum;

    private String origTransBatch;

    private String origPosSeqNum;

    private String origTransDate;

    private String origAuthMd;

    private String origAuthIns;

    private String operIdCd;

    private String transChnl;

    private String origSettleDt;

    private Long origTransAt;

    private String origTransmsnDtTm;

    private String origSysTraNo;

    private String crossDistIn;

    private String origDiscDirIn;

    private String origDiscAlgoIn;

    private Integer origDiscRate;

    private String origDiscCd;

    private String discDirIn;

    private String discAlgoIn;

    private Integer discRate;

    private String discCd;

    private String goldIssInsIdCd;

    private String acctNo2;

    private String acctNm2;

    private String payFlag;

    private String freeFlag;

    private Long bankDebtSettleAt;

    private Long bankCretSettleAt;

    private Long brBankDebtSettleAt;

    private Long brBankCretSettleAt;

    private Long mchntDebtSettleAt;

    private Long mchntCretSettleAt;

    private Integer bankDebtDiscAt;

    private Integer bankCretDiscAt;

    private Integer brBankDebtDiscAt;

    private Integer brBankCretDiscAt;

    private Integer mchntDebtDiscAt;

    private Integer mchntCretDiscAt;

    private Long custCupsDebtDiscAt;

    private Long custCupsCretDiscAt;

    private Long bankDebtFeeAt;

    private Long bankCretFeeAt;

    private Long brBankDebtFeeAt;

    private Long brBankCretFeeAt;

    private Integer bankRevDebtDiscAt;

    private Integer bankRevCretDiscAt;

    private Integer brBankRevDebtDiscAt;

    private Integer brBankRevCretDiscAt;

    private Integer mchntRevDebtDiscAt;

    private Integer mchntRevCretDiscAt;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private String recUpdTs;

    private String recCrtTs;

    private String dcFlag;
}