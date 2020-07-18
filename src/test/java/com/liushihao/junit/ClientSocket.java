package com.liushihao.junit;

import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientSocket {

    @Test
    /**
     * 发送失败
     * 原因: 当服务端调用read方法后，他一直阻塞在哪里，因为客户端没有给他一个标识，告诉是否消息发送完成，
     * 所以服务端还在一直等待接受客户端的数据，结果客户端此时已经关闭了，就是在服务端报错：java.net.SocketException: Connection reset
     */
    public void clientSocket1() {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "你好，这是我的第一个socket";
            bufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 增加一个标识告诉流已经输出完毕
     * socket.close();  将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。
     * socket.shutdownOutput(); 将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接收的。
     */
    public void clientSocket2() {
        try {
            Socket socket = new Socket("18.141.70.245", 9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "你好，这是我的第一个socket";
            bufferedWriter.write(str);
            //刷新输入流
            bufferedWriter.flush();
            //关闭socket的输出流
//            socket.close();   // 将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。
            socket.shutdownOutput();    // 将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接受的。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clientSocket3() {
        try {
            //初始化一个socket
            Socket socket = new Socket("18.141.70.245", 9999);
            //通过socket获取字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //通过标准输入流获取字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clientSocket4() {
        try {
            //初始化一个socket
            Socket socket = new Socket("127.0.0.1", 9999);
            //通过socket获取字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //通过标准输入流获取字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String ip = "127.0.0.1";
            ip = "18.141.70.245";
            Socket socket = new Socket(ip, 9999);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "GBK"));
            String str = "你好, 这是发送的socket";
            bufferedWriter.write(str);
            //刷新输入流
            bufferedWriter.flush();
            InputStream in = socket.getInputStream();
            byte[] data = new byte[1024];
            int len = in.read(data);
            String s = new String(data, 0, len);
            System.out.println(s);
//            Thread.sleep(10000);    // 此处需要注意, 将线程休眠一会, 以便服务端打印
            //关闭socket的输出流
//            socket.close();   // 将socket关闭连接，那边如果有服务端给客户端反馈信息，此时客户端是收不到的。
            socket.shutdownOutput();    // 将输出流关闭，此时，如果服务端有信息返回，则客户端是可以正常接收的。
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //初始化一个socket
            Socket socket = new Socket("18.141.70.245", 9999);
            //通过socket获取字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //通过标准输入流获取字符流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            while (true) {
                String str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
