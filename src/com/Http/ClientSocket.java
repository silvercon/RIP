package com.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public void sendReq() {

        // 创建socket实例
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**********************************************************
         发送字节流：使用socket的OutputStream创建一个FileWriter对象
         接收字节流：使用socket的InputStream创建BufferReader对象
         ***********************************************************/
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

        StringBuffer stringBuffer = new StringBuffer();
        int tmp = 0;

        while (true) {

            try {
                if (in.ready()) {
                    while ((tmp = in.read()) != -1) {
                        stringBuffer.append((char) tmp);
                    }

                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(stringBuffer.toString());

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ClientSocket httpReq = new ClientSocket();
        httpReq.sendReq();
    }
}
