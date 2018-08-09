package com.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 将字符串按照pattern格式转化为日期
     * @param fromDate
     * @param pattern
     * @return Date
     * @create: 2018年8月8日 上午10:50:01 silver
     * @history:
     */
    public static Date str2Date(String fromDate, String pattern) {
        Date toDate = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);

        try {
            toDate = formater.parse(fromDate);
        } catch (Exception e) {
            throw new RuntimeException("日期转化错误！");
        }

        return toDate;
    }

    public static void main(String args[]) {
        System.out.println(str2Date("2018-08-08", "yyyy-MM-dd"));
    }
}
