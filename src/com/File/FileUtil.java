package com.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;;

public class FileUtil {

    /**
     * 创建新文件
     * @param filePath
     * @return 
     * @create: 2018年8月8日 上午11:02:24 silver
     * @history:
     */
    public Boolean createNewFile(String filePath) {
        Boolean res = true;
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }

    /**
     * 
     * @param filePath 
     * @create: 2018年8月8日 上午11:10:06 silver
     * @history:
     */
    public void readFile(String filePath) {

        try {
            /*
             * 
             * */
            InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream(filePath));
            BufferedReader bReader = new BufferedReader(inputStreamReader);

            StringBuilder sBuilder = new StringBuilder();
            int tmp;
            while ((tmp = bReader.read()) != -1) {
                sBuilder.append((char) tmp);
            }
            bReader.close();
            System.out.println(sBuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FileUtil fileUtil = new FileUtil();
        fileUtil
            .readFile("/Users/silver/Documents/Attendance/2018-08-09-11.txt");
    }
}
