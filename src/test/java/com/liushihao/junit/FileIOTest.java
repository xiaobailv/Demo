package com.liushihao.junit;

import cn.hutool.core.util.StrUtil;
import com.liushihao.entity.BthIcOfflineSuccTxnTmp;
import com.liushihao.entity.TblQrcAllTmp;
import com.liushihao.main.T0206ReadFile;
import com.liushihao.util.WriteUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Slf4j
public class FileIOTest {

    @Test
    public void dir() {
        File file = new File(String.format("D:\\%s\\%s\\", "CCB", "File"));
        File[] files = file.listFiles();
    }

    @Test
    public void filePath() throws IOException {
        String fileName = "src/test/resource/新建文本文档.txt";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int read = bufferedInputStream.read(new byte[1024]);
        System.out.println("read = " + read);

    }

    @Test
    public void getProperties() {
        String path = "report/file_transfer.properties";
        StringBuilder stringBuilder = new StringBuilder();
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties(path);
        } catch (IOException e) {
            log.error("获取配置文件出错", e);
        }
        assert properties != null;
        String homeDir = properties.getProperty("path");
        log.info("homeDir = {}", homeDir);
        stringBuilder.append(homeDir).append("/");
        stringBuilder.append("instOprReport").append("/");
        stringBuilder.append("Inst_Parm_Mnt").append(".xls");
        String string = stringBuilder.toString();
        log.info("string = {}", string);
        int i = string.lastIndexOf("/");
        log.info("i = {}", i);
        String substring = string.substring(i + 1);
        log.info("substring = {}", substring);
    }

    @Test
    public void writeNoLine() {
        List<List<String>> lists = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("1\n");
        strings.add("2\n");
        strings.add("3\n");
        strings.add("4\n");
        strings.add("5\n");
        strings.add("6\n");
        lists.add(strings);
        /*List<String> list = lists.get(0);
        if (list.size() != 0) {
            System.out.println(list.get(0));
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i));
            }
            System.out.println("循环结束");
            String s = list.get(list.size() - 1);
            System.out.print(s);
            String replace = s.replace("\n", "aa");
            System.out.print(replace);
        } else {
            log.info("没有符合条件的数据...");
        }*/
        WriteUtil.writeList(lists, "D:/Download/a.txt");
    }

    @Test
    public void fileExist() throws InterruptedException {
        File file = new File("D:/Download/a.txt");
        boolean exists = false;
        while (!exists) {
            exists = file.exists();
            System.out.println("文件不存在");
            Thread.sleep(5000);
        }
        System.out.println("文件已存在");
    }

    @Test
    public void readFileSuccess() throws IOException {
        Map<String, T0206ReadFile> hashMap = creatT0206ReadFile();
        int time = 0;
        int cursor = 46;
        int length = 7;
        int currentIndex = 0;
        int nextIndex = 0;
        String firstSeven;
        String readResult;
        String date;
        // 读文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/昆仑银行/INFB-INFR/INF20032801B"), "GBK"));
        // 将读取到的字符串赋值给line
        String line = br.readLine();
        // 读取到的字符串信息
        if (line != null) { // 如果读取到的不为null则说明文件有内容
            log.info("读取到的文件内容 -> {}", line);
            date = line.substring(18, 26);  // 保存日期
            while (true) {
                time++;
                firstSeven = StrUtil.subWithLength(line, cursor, length);   // 1: cursor = 46, length = 7; 2: cursor = 526, length = 7
                log.info("第{}次读取到的前七位: {}", time, firstSeven);
                T0206ReadFile t0206ReadFile = hashMap.get(firstSeven);

                if (t0206ReadFile.getIndex() == 3) {    // 300/301
                    readResult = StrUtil.subWithLength(line, cursor, t0206ReadFile.getLength());
                    log.info("读取到的一条数据{}", readResult);  // cursor = 46, length = 526
                    // 对读取到的一条数据进行处理
                    BthIcOfflineSuccTxnTmp bthIcOfflineSuccTxnTmp = new BthIcOfflineSuccTxnTmp();
                    bthIcOfflineSuccTxnTmp.setCupsTxnCode(readResult.substring(0, 3));
                    bthIcOfflineSuccTxnTmp.setSegmentBitmap(readResult.substring(3, 7));
                    bthIcOfflineSuccTxnTmp.setPrimaryAcctNum(readResult.substring(7, 26));
                    bthIcOfflineSuccTxnTmp.setAmtTrans(readResult.substring(26, 38));
                    bthIcOfflineSuccTxnTmp.setCurrcyCodeTrans(readResult.substring(38, 41));
                    bthIcOfflineSuccTxnTmp.setTransmsnDateTime(readResult.substring(41, 51));
                    bthIcOfflineSuccTxnTmp.setSysTraceAuditNum(readResult.substring(51, 57));
                    bthIcOfflineSuccTxnTmp.setAuthrIdResp(readResult.substring(57, 63));
                    bthIcOfflineSuccTxnTmp.setAuthrDate(readResult.substring(63, 67));
                    bthIcOfflineSuccTxnTmp.setRetrivlRefNum(readResult.substring(67, 79));
                    bthIcOfflineSuccTxnTmp.setAcqInstIdCode(readResult.substring(79, 90));
                    bthIcOfflineSuccTxnTmp.setFwdInstIdCode(readResult.substring(90, 101));
                    bthIcOfflineSuccTxnTmp.setMchntType(readResult.substring(101, 105));
                    bthIcOfflineSuccTxnTmp.setCardAccptrTermnlId(readResult.substring(105, 113));
                    bthIcOfflineSuccTxnTmp.setCardAccptrId(readResult.substring(113, 128));
                    bthIcOfflineSuccTxnTmp.setCardAccptrNameLoc(readResult.substring(128, 168));
                    bthIcOfflineSuccTxnTmp.setOrigMsg(readResult.substring(168, 191));
                    bthIcOfflineSuccTxnTmp.setMsgReasonCode(readResult.substring(191, 195));
                    bthIcOfflineSuccTxnTmp.setOddEvenFlag(readResult.substring(195, 196));
                    bthIcOfflineSuccTxnTmp.setCupSsn(readResult.substring(196, 205));
                    bthIcOfflineSuccTxnTmp.setRcvgInstIdCode(readResult.substring(205, 216));
                    bthIcOfflineSuccTxnTmp.setIssInstIdCode(readResult.substring(216, 227));
                    bthIcOfflineSuccTxnTmp.setCupNotifyFlag(readResult.substring(227, 228));
                    bthIcOfflineSuccTxnTmp.setTranLaunchChannel(readResult.substring(228, 230));
                    bthIcOfflineSuccTxnTmp.setTranFeatureFlag(readResult.substring(230, 231));
                    bthIcOfflineSuccTxnTmp.setCupReserve(readResult.substring(231, 239));
                    bthIcOfflineSuccTxnTmp.setPosSvcCondCode(readResult.substring(239, 241));
                    bthIcOfflineSuccTxnTmp.setNativeFee(readResult.substring(241, 253));
                    bthIcOfflineSuccTxnTmp.setTranRegionFlag(readResult.substring(253, 254));
                    bthIcOfflineSuccTxnTmp.setEciFlag(readResult.substring(254, 256));
                    bthIcOfflineSuccTxnTmp.setSpecialCostFlag(readResult.substring(256, 258));
                    bthIcOfflineSuccTxnTmp.setSpecialCostGrade(readResult.substring(258, 259));
                    bthIcOfflineSuccTxnTmp.setReserve1(readResult.substring(259, 269));
                    bthIcOfflineSuccTxnTmp.setAppCrypto(readResult.substring(269, 285));
                    bthIcOfflineSuccTxnTmp.setPosEntryModeCode(readResult.substring(285, 288));
                    bthIcOfflineSuccTxnTmp.setCardSeqId(readResult.substring(288, 291));
                    bthIcOfflineSuccTxnTmp.setTermnlAchieveCap(readResult.substring(291, 292));
                    bthIcOfflineSuccTxnTmp.setIcCondCode(readResult.substring(292, 293));
                    bthIcOfflineSuccTxnTmp.setTermnlCapbs(readResult.substring(293, 299));
                    bthIcOfflineSuccTxnTmp.setTermnlVeriResl(readResult.substring(299, 309));
                    bthIcOfflineSuccTxnTmp.setUnpredicNum(readResult.substring(309, 317));
                    bthIcOfflineSuccTxnTmp.setIfdSerialNum(readResult.substring(317, 325));
                    bthIcOfflineSuccTxnTmp.setIssrAppData(readResult.substring(325, 389));
                    bthIcOfflineSuccTxnTmp.setAppTransCount(readResult.substring(389, 393));
                    bthIcOfflineSuccTxnTmp.setAppInterchProfl(readResult.substring(393, 397));
                    bthIcOfflineSuccTxnTmp.setTransDate(readResult.substring(397, 403));
                    bthIcOfflineSuccTxnTmp.setTermnlCntryCode(readResult.substring(403, 406));
                    bthIcOfflineSuccTxnTmp.setTransRespondCode(readResult.substring(406, 408));
                    bthIcOfflineSuccTxnTmp.setTransType(readResult.substring(408, 410));
                    bthIcOfflineSuccTxnTmp.setTransAmt(readResult.substring(410, 422));
                    bthIcOfflineSuccTxnTmp.setTransCurrcyCode(readResult.substring(422, 425));
                    bthIcOfflineSuccTxnTmp.setAppCryptoVerifyResult(readResult.substring(425, 426));
                    bthIcOfflineSuccTxnTmp.setDateExpr(readResult.substring(426, 430));
                    bthIcOfflineSuccTxnTmp.setCryptoInfoData(readResult.substring(430, 432));
                    bthIcOfflineSuccTxnTmp.setAmtOther(readResult.substring(432, 444));
                    bthIcOfflineSuccTxnTmp.setCardVerResl(readResult.substring(444, 450));
                    bthIcOfflineSuccTxnTmp.setTermnlType(readResult.substring(450, 452));
                    bthIcOfflineSuccTxnTmp.setDfName(readResult.substring(452, 484));
                    bthIcOfflineSuccTxnTmp.setTermAppVerNum(readResult.substring(484, 488));
                    bthIcOfflineSuccTxnTmp.setTransSeqCount(readResult.substring(488, 496));
                    bthIcOfflineSuccTxnTmp.setEciac(readResult.substring(496, 502));
                    bthIcOfflineSuccTxnTmp.setCardProId(readResult.substring(502, 526));
                    cursor += t0206ReadFile.getLength(); // cursor = 526
                } else {
                    break;
                }
            }
        } else {
            log.info("文件没有内容");
        }
        br.close();
    }

    @Test
    public void readFileRefuse() throws IOException {
        log.info("进入T0206_2读取refuse文件...");
        Map<String, T0206ReadFile> hashMap = creatT0206ReadFile();
        int time = 0;
        int cursor = 46;
        int length = 7;
        int currentIndex = 0;
        int nextIndex = 0;
        String firstSeven;
        String readResult;
        String date;
        // 读文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(/*filePath*/"D:/昆仑银行/INFB-INFR/INF20032801R"), "GBK"));
        // 将读取到的字符串赋值给line
        String line = br.readLine();
        // 读取到的字符串信息
        if (line != null) { // 如果读取到的不为null则说明文件有内容
            log.info("读取到的文件内容 -> {}", line);
            date = line.substring(18, 26);  // 保存日期
            // StrUtil.subWithLength(line, cursor, length); arg1: 读取的字符串, arg2: 读取的下标位置 arg3: 读取的长度
            while (true) {
                time++;
                firstSeven = StrUtil.subWithLength(line, cursor, length);   // 1: cursor = 46, length = 7; 2: cursor = 526, length = 7
                log.info("第{}次读取到的前七位: {}", time, firstSeven);
                T0206ReadFile t0206ReadFile = hashMap.get(firstSeven);

                switch (t0206ReadFile.getIndex()) {
                    case 4: {    // 002
                        length = t0206ReadFile.getLength();     // 读取002的长度
                        readResult = StrUtil.subWithLength(line, cursor, length);    // 读002的数据
                        cursor += t0206ReadFile.getLength();    // 继续读取 重置读取下标
                        length = 7;     // 重置读取长度
                        firstSeven = StrUtil.subWithLength(line, cursor, length);   // 下一段的前7位
                        T0206ReadFile t0206ReadFile1 = hashMap.get(firstSeven);     // 获取下一段的信息
                        if (t0206ReadFile1.getIndex() == 3) {   // 300/301
                            // 读取300/301
                            cursor += t0206ReadFile1.getLength();
                            length = t0206ReadFile1.getLength();
                            readResult += StrUtil.subWithLength(line, cursor, length);        // 拼接300/301
                            cursor += length;   // 重置读取下标
                            length = 7;         // 重置读取长度
                            firstSeven = StrUtil.subWithLength(line, cursor, length);         // 判断是不是003
                            T0206ReadFile t0206ReadFile2 = hashMap.get(firstSeven);
                            if (t0206ReadFile2.getIndex() == 5) {
                                cursor += t0206ReadFile2.getLength();
                                length = t0206ReadFile2.getLength();
                                readResult += StrUtil.subWithLength(line, cursor, length);
                                // 调用3段数据插入 002+300/301+003: 665
                            }
                            // 调用2段数据插入 002+300/301: 575
                        }
                    }
                    case 5: {    // 003 90
                        length = t0206ReadFile.getLength();
                        readResult = StrUtil.subWithLength(line, cursor, length);    // 读取003的数据
                        // 调用1段数据插入 003: 90
                    }
                }

                /*if (t0206ReadFile.getIndex() == 4) {    // 读到的是002 那么 如果接下来读到的如果是002就说明这是两条数据
                    readResult = StrUtil.subWithLength(line, cursor, t0206ReadFile.getLength());
                    log.info("读取到的一条数据{}", readResult);  // cursor = 46, length = 526
                    cursor += t0206ReadFile.getLength(); // cursor = 526
                } else {
                    break;
                }*/
            }
        } else {
            log.info("文件没有内容");
        }
        br.close();


        log.info("结束T0206_2读取refuse文件...");
    }

    private Map<String, T0206ReadFile> creatT0206ReadFile() {
        T0206ReadFile tc0008000 = new T0206ReadFile(1, "0008000", 46, "银联文件头 TC000");     // 文件头
        T0206ReadFile tc0018000 = new T0206ReadFile(2, "0018000", 42, "银联文件结尾TC001");    // 文件尾
        T0206ReadFile tc300A000 = new T0206ReadFile(3, "300A000", 526, "TC300 段0，段2");     // 成功 526 519
        T0206ReadFile tc0028000 = new T0206ReadFile(4, "0028000", 49, "TC002拒绝记录");       // 失败
        T0206ReadFile tc0038000 = new T0206ReadFile(5, "0038000", 90, "TC003错误记录");       // 失败
        T0206ReadFile tc301A000 = new T0206ReadFile(3, "301A000", 526, "TC301 段0，段2");    // 成功 526 519
        Map<String, T0206ReadFile> hashMap = new HashMap<>();
        hashMap.put("0008000", tc0008000);
        hashMap.put("0018000", tc0018000);
        hashMap.put("300A000", tc300A000);
        hashMap.put("0028000", tc0028000);
        hashMap.put("0038000", tc0038000);
        hashMap.put("301A000", tc301A000);
        return hashMap;
    }

    @Test
    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/KL-Bank/INFB-INFR/INF20032801Bcopy"), "GBK"));
        String line = br.readLine();
        System.out.println("\"" + StrUtil.subWithLength(line, 174, 40) + "\"");
        System.out.println("------------------------------");
        System.out.println(StrUtil.subWithLength(line, 0, 46));  // 000800005478820   2016041220160412PROD00000001
        System.out.println(StrUtil.subWithLength(line, 46, 526));   // 300A0006224242200000052   0000000005001560413102119003442000000    61041099674005472690   05478820   152026900141547269015200004                                        000000000000000000000000000000016566592130000   92130000   003         00D000000000060   00          D5716C33D0B3D32F07200060E0E1C800000000001E2CA19F131E949007011703900000010A010000046000B11FA7BD                          018F7C00160413156Y10000000000050015632801400000000000003F000022A000000333010102                002000003442ECC001
        System.out.println(line.substring(0, 46));
        System.out.println(line.substring(46, 572));
    }

    @Test
    public void writeFile() {
        String fileName = "/home/gbatch/recon/file/" + 20200707 + "/A00093/OFFLINE/CUPS/" + "aaa.txt";
        String string1 = "ABCD\n";
        String string2 = "9876543210\n";
        List<List<String>> items = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        items.add(list2);
        list2.add(string1);
        list2.add(string2);
        if (items.get(0).size() != 0) {
            for (List<String> strings : items) {
                log.info("items.get(0).size() -> {}", items.get(0).size());
                log.info("strings.get(0) -> {}", strings.get(0));
                WriteUtil.write(fileName, strings.get(0), false);
                for (int i = 1; i < strings.size(); i++) {
                    log.info("strings.get(" + i + ") -> {}", strings.get(i));
                    log.info("items.get(0).size() -> {}", items.get(0).size());
                    WriteUtil.write(fileName, strings.get(i), true);
                }
            }
        } else {
            WriteUtil.write(fileName, "", false);
            log.info("没有符合条件的数据...");
        }
    }

    @Test
    public void createDirectory() {
        String filePath = "D:/Download/aaa/123.txt";
        WriteUtil.write(filePath, "111111111\n", false);
    }

    @Test
    public void readString() {
        BigDecimal zero = BigDecimal.ZERO;
        String str = "            1 02 03 4 0 5541             05478820    00049992    03010000    03010000    05478820    0200 000000 00 787693 1023182609 6222525117526546                                                              000000000000000000000080547882000800049992 01080209 QRA290455412CVS 234339176441 000000031975              D00000000006                            0                                                                                                    ";
        String mcht = str.substring(264, 279);
        String pro = "D".equals(str.substring(319, 331).substring(0, 1)) ? "+" : "-";
        String amt = str.substring(319, 331).substring(1);
        pro += amt;
        BigDecimal proAmt = new BigDecimal(pro).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("mcht = " + mcht);
        System.out.println("proAmt = " + proAmt);
        for (int i = 0; i < 5; i++) {
            zero = zero.add(proAmt);
        }
        System.out.println("zero = " + zero);
        System.out.println("------------------");
        BigDecimal bigDecimal = new BigDecimal(pro);
        System.out.println("bigDecimal = " + bigDecimal);
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO));
    }

    /**
     * 读取条码支付对账文件测试
     *
     * @throws IOException
     */
    @Test
    public void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/KL-Bank/二期/条码文件/QRA0547882020201023_01_ALL/20201023_20201023_ALL.csv"), "GBK"));
        int count = 0;
        String string;
        while ((string = br.readLine()) != null) {
            if (string.substring(0, 14).contains("-")) {
                System.out.println(string);
                count++;
                System.out.println("count = " + count);
                TblQrcAllTmp tblQrcAllTmp = setTblQrcAllTmp(string);
                System.out.println("tblQrcAllTmp.getTransDateTime() = " + tblQrcAllTmp.getTransDateTime());
            }
        }
        System.out.println("count = " + count);
    }

    private TblQrcAllTmp setTblQrcAllTmp(String string) {
//        string = "`2020-09-29 03:44:23,`,`QRA601855410FFU,`QRA601855410FFL,`QRA601855410FFU,`,`9551600000202009294359000408,`50200929134530170721,`16013222527635705039,`,`pay.unionpay.proxy.micropay,`支付成功,`01,`CNY,`10.00,`0.00,`,`,`,`,`,`,`加油站付款,`,`0.02,`0.153%,`,`0,`4I17,`中国石油天然气股份有限公司广东清远回澜西侧加油站,`,`05478820   00049992   0170720929034413,`0.00,`10.00,`9.98,`0.01,`0.02|0.153%|05478820,`11111111111";
//        String txt = "trans_date_time,common_id,third_mcht_no,mcht_no,child_mcht_no,term_id,pl_order_no,un_order_no,mc_order_no,user_id,trans_type,trans_stat,pay_bank,curr_cd,trans_amt,ent_red_amt,plre_order_no,mcre_order_no,refund_amt,ent_red_refund_amt,refund_type,refund_stat,pro_name,mcht_date_package,trans_fee,fee_rate,term_type,local_settle_in,store_no,mcht_name,cashier,key_cup,no_coupon_amt,actual_amt,settle_amt,acq_cost_fee,reserve1,reserve2";
        TblQrcAllTmp tblQrcAllTmp = new TblQrcAllTmp();
        // 替换掉`
        string = string.replace("`", "");
        // 分割读到的字符串为数组
        String[] split = string.split(",");
//        String[] split1 = txt.split(",");
//        System.out.println("split.length = " + split.length);
//        System.out.println("split1.length = " + split1.length);
//        Field[] declaredFields = tblQrcAllTmp.getClass().getDeclaredFields();
//        for (int i = 0; i < declaredFields.length; i++) {
//            Field declaredField = declaredFields[i];
//            declaredField.setAccessible(true);
//            System.out.println("declaredField.getName() = " + declaredField.getName());
//            if (declaredField.getType().toString().equals("class java.math.BigDecimal")) {
//                declaredField.set(tblQrcAllTmp, new BigDecimal(split[i]));
//            } else {
//                declaredField.set(tblQrcAllTmp, split[i]);
//            }
//        }

//        for (int i = 0; i < split1.length; i++) {
//            String s = split1[i];
//            String s1 = split[i];
//            System.out.println("split1[" + i + "] = " + s);
//            System.out.println("split1[" + i + "] = " + s1);
//        }

        tblQrcAllTmp.setTransDateTime(split[0]);
        tblQrcAllTmp.setCommonId(split[1]);
        tblQrcAllTmp.setThirdMchtNo(split[2]);
        tblQrcAllTmp.setMchtNo(split[3]);
        tblQrcAllTmp.setChildMchtNo(split[4]);
        tblQrcAllTmp.setTermId(split[5]);
        tblQrcAllTmp.setPlOrderNo(split[6]);
        tblQrcAllTmp.setUnOrderNo(split[7]);
        tblQrcAllTmp.setMcOrderNo(split[8]);
        tblQrcAllTmp.setUserId(split[9]);
        tblQrcAllTmp.setTransType(split[10]);
        tblQrcAllTmp.setTransStat(split[11]);
        tblQrcAllTmp.setPayBank(split[12]);
        tblQrcAllTmp.setCurrCd(split[13]);
        tblQrcAllTmp.setTransAmt(new BigDecimal(isNullBigDecimal(split[14])));
        tblQrcAllTmp.setEntRedAmt(new BigDecimal(isNullBigDecimal(split[15])));
        tblQrcAllTmp.setPlreOrderNo(split[16]);
        tblQrcAllTmp.setMcreOrderNo(split[17]);
        tblQrcAllTmp.setRefundAmt(new BigDecimal(isNullBigDecimal(split[18])));
        tblQrcAllTmp.setEntRedRefundAmt(new BigDecimal(isNullBigDecimal(split[19])));
        tblQrcAllTmp.setRefundType(split[20]);
        tblQrcAllTmp.setRefundStat(split[21]);
        tblQrcAllTmp.setProName(split[22]);
        tblQrcAllTmp.setMchtDatePackage(split[23]);
        tblQrcAllTmp.setTransFee(new BigDecimal(isNullBigDecimal(split[24])));
        String feeRateString = split[25].replace("%", "");
        BigDecimal feeRate = new BigDecimal(feeRateString).divide(new BigDecimal("100"), 5, RoundingMode.HALF_UP);
        tblQrcAllTmp.setFeeRate(feeRate);
        tblQrcAllTmp.setTermType(split[26]);
        tblQrcAllTmp.setLocalSettleIn(split[27]);
        tblQrcAllTmp.setStoreNo(split[28]);
        tblQrcAllTmp.setMchtName(split[29]);
        tblQrcAllTmp.setCashier(split[30]);
        tblQrcAllTmp.setPriKey(split[31]);
        tblQrcAllTmp.setNoCouponAmt(new BigDecimal(isNullBigDecimal(split[32])));
        tblQrcAllTmp.setActualAmt(new BigDecimal(isNullBigDecimal(split[33])));
        tblQrcAllTmp.setSettleAmt(new BigDecimal(isNullBigDecimal(split[34])));
        tblQrcAllTmp.setAcqCostFee(new BigDecimal(isNullBigDecimal(split[35])));
        tblQrcAllTmp.setThreeColums(split[36]);
        tblQrcAllTmp.setInsIdCd(split[37]);

        return tblQrcAllTmp;
    }

    private String isNullBigDecimal(String string) {
        return string.equals("") ? "0" : string;
    }
}
