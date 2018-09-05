package com.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DB_DATE_FORMAT_STRING = "yyyyMMdd";

    public static final String FRONT_DATE_FORMAT_STRING = "yyyy-MM-dd";

    public static final String DATA_TIME_PATTERN_1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATA_TIME_PATTERN_2 = "yyyy-MM-dd HH:mm";

    public static final String DATA_TIME_PATTERN_3 = "yyyyMMDDhhmmss";

    public static final String DATA_TIME_PATTERN_4 = "yyyyMMDDhhmmss";

    public static final String DATA_TIME_PATTERN_5 = "yyyyMMddHHmmssSSS";

    public static final String DATA_TIME_PATTERN_6 = "yyyy年MM月dd日";

    public static final String DATA_TIME_PATTERN_7 = "HH:mm";

    public static final String DATA_TIME_PATTERN_8 = "yyyy-MM-dd%HH:mm:ss";

    public static final String TIME_BEGIN = " 00:00:00";

    public static final String TIME_MIDDLE = " 12:00:00";

    public static final String TIME_END = " 23:59:59";

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
