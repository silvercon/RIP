package com.ex05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

public class MatchStringJson {

    /**
     * 匹配 {"key":"value"} 格式的json字符串
     * @param json
     * @param key
     * @return value
     * @create: 2018年9月5日 上午10:22:50 silver
     * @history:
     */
    public String getValue(String json, String key) {

        // 匹配 {} 中的内容
        Pattern pattern = Pattern.compile("(?<=\\{)(.+?)(?=\\})");
        Matcher matcher = pattern.matcher(json);

        String keyString = null;
        while (matcher.find()) {
            keyString = matcher.group();
        }

        System.out.println(keyString);

        // 将字符串转化为json对象
        JSONObject target = JSONObject.parseObject("{" + keyString + "}");
        String value = target.getString(key);

        return value;
    }

    public static void main(String args[]) {

        MatchStringJson matchJson = new MatchStringJson();

        String json = "{\"key\":\"value\"}";

        System.out.println(matchJson.getValue(json, "key"));

    }
}
