package com.ex06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomDate {

    public static void main(String[] args) {

        Date randomDate = randomDate("2018-05-01 08:30:00",
            "2018-05-01 09:30:00");

        System.out.println(randomDate.toString());

    }

    /**
     * 返回(beginDate,endDate)区间的随机时间
     * @param beginDate
     * @param endDate
     * @return randomDate
     * @create: 2018年9月5日 上午10:30:11 silver
     * @history:
     */
    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");

            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.after(end)) {
                return null;
            }

            long date = random(start.getTime(), end.getTime());

            return new Date(date);

        } catch (Exception e) {
            ;
        }

        return null;

    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));

        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }

        return rtn;
    }

}
