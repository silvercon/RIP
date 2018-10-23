package com.ex05;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Util.DateUtil;

public class MatchNumber {

    public Date normalizeDate(String date) {
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(date);

        String normalized = matcher.replaceAll("");

        System.out.println(normalized);

        return DateUtil.str2Date(normalized, DateUtil.DB_DATE_FORMAT_STRING);
    }

    public static void main(String args[]) {
        MatchNumber matchNumber = new MatchNumber();

        Date normalDate = matchNumber.normalizeDate("2018.07.09");

        System.out.println(normalDate);
    }
}
