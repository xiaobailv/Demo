package com.liushihao.junit;

import cn.hutool.core.util.StrUtil;
import com.liushihao.entity.BthIcOfflineSuccTxnTmp;
import com.liushihao.main.T0206ReadFile;
import com.liushihao.util.WriteUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class FileIOTest {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\昆仑银行\\INFB-INFR\\INF20032801B"), "GBK"));
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
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(/*filePath*/"D:\\昆仑银行\\INFB-INFR\\INF20032801R"), "GBK"));
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
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\昆仑银行\\INFB-INFR\\INF20032801B"), UTF_8));
        String line = br.readLine();
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
                WriteUtil.write(fileName, strings.get(0), false, UTF_8);
                for (int i = 1; i < strings.size(); i++) {
                    log.info("strings.get(" + i + ") -> {}", strings.get(i));
                    log.info("items.get(0).size() -> {}", items.get(0).size());
                    WriteUtil.write(fileName, strings.get(i), true, UTF_8);
                }
            }
        } else {
            WriteUtil.write(fileName, "", false, UTF_8);
            log.info("没有符合条件的数据...");
        }
    }

    @Test
    public void createDirectory() {
        String filePath = "D:\\Download\\aaa\\123.txt";
        WriteUtil.write(filePath, "111111111\n", false, UTF_8);
    }

    @Test
    public void replace() {
        // 20200710|20200615|100099|14|0|0|611001|14|1543463|882012|6217661599001060644|6217661599001060644|000|882012|156|10.00|||||12340008|008009|123026|||||
        // 20200710|20200615|100099|14|0|0|611002|14|1543470|882012|6217661599001060644|6217661599001060644|000|882012|156|10.00|||||12340008|008010|123215|||||
        String str = "20200710|20200615|100099|14|0|0|611001|14|1543463|882012|6217661599001060644|6217661599001060644|000|882012|156|10.00|||||12340008|008009|123026|||||\n";
        Integer integer1 = 611001;
        Integer integer2 = 1543463;
        Integer integer3 = 108009;
        Integer integer4 = 123026;
        List<String> list = new ArrayList<>();
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < 11000; i++) {
            Integer integer1add = integer1++;
            Integer integer2add = integer2++;
            Integer integer3add = integer3++;
            Integer integer4add = integer4++;
            String replace = str.replace("611001", integer1add.toString());
            String replace1 = replace.replace("1543463", integer2add.toString());
            String replace2 = replace1.replace("008009", integer3add.toString());
            String replace3 = replace2.replace("123026", integer4add.toString());
            list.add(replace3);
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(list);
        WriteUtil.writeList(lists, "/home/gbatch/recon/file/20200712/A00093/OFFLINE/aaa.txt", UTF_8);
    }

    @Test
    public void randomStr() {
        String source = "0123456789";
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int j = 0; j < 6; j++) {
            int i = r.nextInt(10);
            rs.append(source.charAt(i));
            System.out.println(i);
        }
        System.out.println("rs = " + rs);
    }
}
