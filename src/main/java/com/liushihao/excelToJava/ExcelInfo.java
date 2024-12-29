package com.liushihao.excelToJava;

import java.util.List;

public class ExcelInfo {

    /**
     * 交易名称
     */
    private String txnName;

    /**
     * vo集合
     */
    private List<VoInfo> voInfoList;

    public String getTxnName() {
        return txnName;
    }

    public void setTxnName(String txnName) {
        this.txnName = txnName;
    }

    public List<VoInfo> getVoInfoList() {
        return voInfoList;
    }

    public void setVoInfoList(List<VoInfo> voInfoList) {
        this.voInfoList = voInfoList;
    }
}
