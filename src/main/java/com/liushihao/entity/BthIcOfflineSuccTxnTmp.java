package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BthIcOfflineSuccTxnTmp {
    private Long seqNum;

    private String interBrhCode;

    private String settleDt;

    private String cupsTxnCode;

    private String segmentBitmap;

    private String primaryAcctNum;

    private String amtTrans;

    private String currcyCodeTrans;

    private String transmsnDateTime;

    private String sysTraceAuditNum;

    private String authrIdResp;

    private String authrDate;

    private String retrivlRefNum;

    private String acqInstIdCode;

    private String fwdInstIdCode;

    private String mchntType;

    private String cardAccptrTermnlId;

    private String cardAccptrId;

    private String cardAccptrNameLoc;

    private String origMsg;

    private String msgReasonCode;

    private String oddEvenFlag;

    private String cupSsn;

    private String rcvgInstIdCode;

    private String issInstIdCode;

    private String cupNotifyFlag;

    private String tranLaunchChannel;

    private String tranFeatureFlag;

    private String cupReserve;

    private String posSvcCondCode;

    private String nativeFee;

    private String tranRegionFlag;

    private String eciFlag;

    private String specialCostFlag;

    private String specialCostGrade;

    private String reserve1;

    private String appCrypto;

    private String posEntryModeCode;

    private String cardSeqId;

    private String termnlAchieveCap;

    private String icCondCode;

    private String termnlCapbs;

    private String termnlVeriResl;

    private String unpredicNum;

    private String ifdSerialNum;

    private String issrAppData;

    private String appTransCount;

    private String appInterchProfl;

    private String transDate;

    private String termnlCntryCode;

    private String transRespondCode;

    private String transType;

    private String transAmt;

    private String transCurrcyCode;

    private String appCryptoVerifyResult;

    private String dateExpr;

    private String cryptoInfoData;

    private String amtOther;

    private String cardVerResl;

    private String termnlType;

    private String dfName;

    private String termAppVerNum;

    private String transSeqCount;

    private String eciac;

    private String cardProId;

    private String icIssInstId;

    private String btFlag;

    private String origExistFlag;
}