package com.liushihao.junit;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/27 9:25
 */
@Slf4j
public class TimeTest {

    @Test
    public void name() throws ParseException {
        String date = "20220328";
        int days = 10;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date parseDate = sdf.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        String format = sdf.format(calendar.getTime());
        System.out.println("format = " + format);
    }

    @Test
    public void main() throws ParseException {
        String str1 = ""; // 发卡
        String str2 = "20210616111111"; // 审批
        int intervalTime = str2.compareTo(str1);
        System.out.println("intervalTime = " + intervalTime);
        if (intervalTime > 0) {
            System.out.println("审批大于发卡");
        } else if (intervalTime == 0) {
            System.out.println("相同");
        } else {
            System.out.println("发卡大于审批");
        }
        String sdf = "%s-%s-%s 00:00:00";
//        str1 = String.format(sdf, str1.substring(0, 4), str1.substring(4, 6), str1.substring(6, 8));
//        str2 = String.format(sdf, str2.substring(0, 4), str2.substring(4, 6), Integer.valueOf(str2.substring(6, 8)) + 2);
        str2 = String.format(sdf, str2.substring(0, 4), str2.substring(4, 6), str2.substring(6, 8), str2.substring(8, 10), str2.substring(10, 12), str2.substring(12, 14));
//        Timestamp str1Time = Timestamp.valueOf(str1);
        Timestamp str2Time = Timestamp.valueOf(str2);
        Date date = new Date();
        date = str2Time;
        System.out.println("date = " + date);
//        long l = TimeUnit.MILLISECONDS.toDays(str2Time.getTime() - str1Time.getTime());
//        System.out.println("str1Time = " + str1Time);
        System.out.println("str2Time = " + str2Time);
//        System.out.println("l = " + l);

        String createDate = "20211110191515";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = Timestamp.valueOf(sdf2.format(sdf1.parse(createDate)));
        System.out.println("timestamp = " + timestamp);
    }

    @Test
    public void simpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println("format = " + format);

        System.out.println("#########################");

        String date1 = "20210528";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        String today = sdf1.format(new Date());
        if (StringUtils.isNotBlank(date1) && today.equals(date1)) {
            System.out.println("日期相同");
        }
    }

    @Test
    public void timeStamp() {
        // 当前日期
//        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        // 当前系统时间
        Timestamp now = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.getTime());
        System.out.println(sdf.format(new Date(now.getTime())));
        System.out.println(sdf.format(new Date()) + "###");
        Timestamp timestamp1 = Timestamp.valueOf("2021-02-19 10:18:00");
        Timestamp timestamp2 = Timestamp.valueOf("2021-02-24 17:26:00");
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(timestamp2.getTime() - timestamp1.getTime()));
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(now.getTime() - timestamp1.getTime()));
        // compareTo()对比两个时间, 前者比后者大返回1, 后者比前者大返回-1, 相等则返回0
        System.out.println(now.compareTo(timestamp1));  // 1
        System.out.println(timestamp1.compareTo(now));  // -1
        System.out.println(now.compareTo(now)); // 0
        long time = now.getTime();
        System.out.println("time = " + time);
        long differ1 = TimeUnit.MILLISECONDS.toDays(now.getTime() - timestamp2.getTime());
        long differ2 = TimeUnit.DAYS.toDays(now.getTime() - timestamp2.getTime());
        System.out.println("differ1 = " + differ1);
        System.out.println("differ2 = " + differ2);

        System.out.println("======================");
        String timeString1 = "20210222";
        String timeString2 = "20161114";
        int compareTo = timeString1.compareTo(timeString2);
        System.out.println("compareTo = " + compareTo);
        String year = timeString2.substring(0, 4);
        String month = timeString2.substring(4, 6);
        String day = timeString2.substring(6, 8);
        String sdfString = "%s-%s-%s 00:00:00";
        sdfString = String.format(sdfString, year, month, day);
        System.out.println("sdfString = " + sdfString);
        Timestamp timestamp3 = Timestamp.valueOf(sdfString);
        Timestamp timestamp4 = Timestamp.valueOf("2021-05-11 00:00:00");
//        System.out.println("timestamp3 = " + timestamp3);
        long diffTime = TimeUnit.MILLISECONDS.toDays(timestamp4.getTime() - timestamp3.getTime());
        System.out.println("相差" + TimeUnit.MILLISECONDS.toDays(now.getTime() - timestamp3.getTime()) + "天");
        if (diffTime <= 30 && diffTime >= -30) {
            System.out.println("正确执行逻辑, 间隔时间为: " + diffTime);
        } else {
            System.out.println("抛出异常, 间隔时间为: " + diffTime);
        }
        timestamp1 = null;
        log.info("测试日志打印空对象: " + timestamp1);
    }

    @Test
    public void testData() {
        // 设置日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        // 获取当前Util格式的时间
        Date date = new Date();
        // UtilDate ===> String
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        System.out.println("--------");


        try {
            // String ===> UtilDate
            Date parse = simpleDateFormat.parse(format);
            System.out.println(parse.getTime());
        } catch (ParseException e) {
            System.out.println("日期格式转换错误!!!");
            e.printStackTrace();
        }
    }

    @Test
    public void dateUtil() {
        String s = DateUtil.formatAsDatetime(new Date());
        Instant now = Instant.now().plus(Duration.ofHours(8));

        System.out.println("s = " + s);
        System.out.println("now = " + now);
    }

    @Test
    public void localDate() {
        // ========== LocalDate构造 ==========
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, 11, 30);
        System.out.println("localDate1 = " + localDate);        // 获取当前时间: 2020-06-01
        System.out.println("localDate2 = " + localDate2);       // 获取指定时间: 2020-06-01
        long until = localDate2.until(localDate, DAYS);
        System.out.println("until = " + until);
        long between = DAYS.between(localDate2, localDate);
        System.out.println("between = " + between);

        // ========== LocalDate获取当前时间属性 ==========
        System.out.println(localDate.getYear());                // 获取当前年份: 2020
        System.out.println(localDate.getMonth());               // 获取当前月份: 英文: JUNE
        System.out.println(localDate.getMonthValue());          // 获取当前月份: 数字: 6

        System.out.println(localDate.getDayOfMonth());          // 获取当前日期是所在月的第几天 1
        System.out.println(localDate.getDayOfWeek());           // 获取当前日期是星期几（星期的英文全称）: MONDAY
        System.out.println(localDate.getDayOfYear());           // 获取当前日期是所在年的第几天: 153

        System.out.println(localDate.lengthOfYear());           // 获取当前日期所在年有多少天 366
        System.out.println(localDate.lengthOfMonth());          // 获取当前日期所在月份有多少天 30
        System.out.println(localDate.isLeapYear());             // 获取当前年份是否是闰年 true

        // ========== LocalDate当前时间的加减 ==========
        System.out.println(localDate.minusYears(1));            // 将当前日期减1年
        System.out.println(localDate.minusMonths(1));           // 将当前日期减1月
        System.out.println(localDate.minusDays(1));             // 将当前日期减1天

        System.out.println(localDate.plusYears(1));             // 将当前日期加1年
        System.out.println(localDate.plusMonths(1));            // 将当前日期加1月
        System.out.println(localDate.plusDays(1));              // 将当前日期加1天

        // ========== LocalDate当前时间的判断 ==========
        System.out.println("LocalDate的判断");
        System.out.println(localDate.isAfter(localDate2));      // localDate在localDate2日期之后
        System.out.println(localDate.isBefore(localDate2));     // localDate在localDate2日期之前
        System.out.println(localDate.isEqual(localDate2));      // localDate和localDate2日期是否相等

        // ========== LocalDate当前时间支持的类型 ==========
        System.out.println(localDate.isSupported(ChronoField.DAY_OF_YEAR));    // 当前时间支持的时间类型是：一年中的某一天，这个不知道应用场景
        System.out.println(localDate.isSupported(DAYS));            // 当前日期支持的单元：天(说明当前时间是按天来算的)

        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));            // 本月的第1天
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));        // 下月的第1天
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextYear()));         // 下年的第1天
        LocalDate localDate1 = localDate.minusMonths(1);
        System.out.println("上个月的第一天" + localDate1.with(TemporalAdjusters.firstDayOfMonth()));

        // ========== LocalDate指定时间的操作 ==========
        System.out.println(localDate.withDayOfMonth(2));                                    // 本月的第几天
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));             // 本月的最后一天
        System.out.println(localDate.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));   // 上一周星期天是几号
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));       // 下一周星期一是几号
    }

    @Test
    public void localTime() {
        //========== LocalTime 的构造  ==========
        LocalTime localTime = LocalTime.now();                //获取当前时间

//        LocalTime.of(int hour, int minute) 根据参数设置时间，参数分别为时，分
//        LocalTime.of(int hour, int minute, int second) 根据参数设置时间，参数分别为时，分，秒
        LocalTime localTime2 = LocalTime.of(18, 18);
        LocalTime localTime3 = LocalTime.of(18, 18, 18);
        System.out.println(localTime2);
        System.out.println(localTime3);

        //========== LocalDate 获取当前时间属性  ==========
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        System.out.println(localTime.plusHours(1));         // 将当前时间加1时
        System.out.println(localTime.plusMinutes(1));       // 将当前时间加1分钟
        System.out.println(localTime.plusSeconds(1));       // 将当前时间加1秒

        System.out.println(localTime.minusHours(1));        // 将当前时间减1小时
        System.out.println(localTime.minusMinutes(1));      // 将当前时间减1分钟
        System.out.println(localTime.minusSeconds(1));      // 将当前时间减1秒
    }

    @Test
    public void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);              // 2020-06-01T16:20:59.998

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime2);             // 2020-06-01T16:20:59.999
        String[] ts = localDateTime.toString().split("T");
        for (String t : ts) {
            System.out.println("t = " + t);             // t = 2020-06-01 t = 16:20:59.998
        }
        System.out.println(ts[1].substring(0, 8));      // 16:20:59
    }

    @Test
    public void instant() {
        Instant instant = Instant.now();
        System.out.println(instant);                       // 2020-06-01T08:23:22.486Z
        System.out.println(instant.getNano());             // 纳秒数 486000000
        System.out.println(instant.getEpochSecond());      // 1970年到现在的秒数1590999802
        System.out.println(instant.toEpochMilli());        // 1970年到现在的毫秒数(和new Date().getTime() System.currentTimeMillis 一样)
        // 1590999802486
        // ========== Instant 时间区间的加减 省略,用法基本一致 ==========
    }

    @Test
    public void stringToLocalDate() {
        // String --> LocalDate
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(LocalDate.parse("2020-06-01").format(pattern));

        // String --> LocalTime
        LocalTime localTime = LocalTime.parse("16:40:30");

        // String --> LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDate localDate = LocalDate.parse("2019-08-25 09:43:37", formatter);

        System.out.println(localTime);
        System.out.println(localDate);
    }

    @Test
    public void simpleFormat() {
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMdd");
        String retStrFormatNowDate = sdFormatter.format(new Date());
        System.out.println("retStrFormatNowDate = " + retStrFormatNowDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = sdf.format(new Date());
        System.out.println("format = " + format);
    }

    @Test
    public void parse() {
        String startDate = "20201224";
        String endDate = "20201201";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setLenient(false);
        try {
            sdf.parse(startDate);
            sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (endDate.compareTo(startDate) < 0) {
            log.error("查询结束时间不能小于开始时间");
        }
    }

    @Test
    public void newDate() {
        String date = "202008";
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate yyyyMM = LocalDate.parse(date + "01", sdf).with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("yyyyMM = " + yyyyMM.format(sdf));

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf1.format(new Date(Long.parseLong("")));
        System.out.println("format = " + format);
    }
}
