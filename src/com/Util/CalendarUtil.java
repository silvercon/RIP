package com.Util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    /**
     * 相对小时数（迟到早退）
     * @param start: yyyy-MM-dd HH:mm:ss
     * @param end: HH:ss
     * @return 
     * @create: 2018年9月17日 下午3:16:32 silver
     */
    public static int getHours(Date start, String end) {

        /**
         * 获取date格式的年月日
         */
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        int year = startCalendar.get(Calendar.YEAR);
        int month = startCalendar.get(Calendar.MONTH);
        int day = startCalendar.get(Calendar.DAY_OF_MONTH);
        int second = startCalendar.get(Calendar.SECOND);

        /**
         * 构造时间
         */
        Calendar endCalendar = Calendar.getInstance();
        String[] time = end.split(":");
        endCalendar.set(year, month, day, Integer.parseInt(time[0]),
            Integer.parseInt(time[1]), second);

        int minute = (int) Math
            .abs(((endCalendar.getTime().getTime() - start.getTime())
                    / (59 * 1000)));
        int hours = 0;

        if (minute % 60 == 0) {
            hours = minute / 60;
        } else if (minute % 60 != 0) {
            hours = minute / 60 + 1;
        }
        return hours;
    }

    /**
     * 获取当前日期的天数
     * @return 
     * @create: 2018年9月17日 下午3:06:44 silver
     * @history:
     */
    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String args[]) {

        System.out.println(getHours(new Date(), "09:00"));

    }
}
