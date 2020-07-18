package com.liushihao.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SocketSend {

    public static void main(String[] args)throws Exception {

        // 1，建立udp的socket服务。

        DatagramSocket ds = new DatagramSocket();//指定发送端口，这个可以不指定，系统会随机分配。

        // 2，明确要发送的具体数据。

        String text = "udp刘世豪aslkfjdslk扫两间房龙蛋分开算\n飞龙但发牢骚但来发送但\n劳烦三代藩垄断飞龙将劳烦\n赛但发牢骚胆量翻\n看所戴肯教老三单反老三但\n防老剂三代看复赛框架法老三大夫\n囧带就udp刘世豪aslkfjdslk扫两间房龙蛋分开算\n飞龙但发牢骚但来发送但\n劳烦三代藩垄断飞龙将劳烦\n赛但发牢骚胆量翻\n看所戴肯教老三单反老三但\n防老剂三代看复赛框架法老三大夫\n囧带就udp刘世豪aslkfjdslk扫两间房龙蛋分开算\n飞龙但发牢骚但来发送但\n劳烦三代藩垄断飞龙将劳烦\n赛但发牢骚胆量翻\n看所戴肯教老三单反老三但\n防老剂三代看复赛框架法老三大夫\n囧带就";

        byte[] buf = text.getBytes("GBK");

        // 3，将数据封装成了数据包。

        DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("18.141.70.245"),9999);

        // 4，用socket服务的send方法将数据包发送出去。

        ds.send(dp);

        // 5. 接收服务端的回执信息
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        ds.receive(datagramPacket);
        String receive = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(receive);

        // 5，关闭资源。

        ds.close();

    }

    @Test
    public void sendUdp() throws IOException {
        // 1，建立udp的socket服务。

        DatagramSocket ds = new DatagramSocket();//指定发送端口，这个可以不指定，系统会随机分配。

        // 2，明确要发送的具体数据。

        String text = "udp传输演示 哥们来了";

        byte[] buf = text.getBytes("GBK");

        // 3，将数据封装成了数据包。

        DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("18.141.70.245"),9999);

        // 4，用socket服务的send方法将数据包发送出去。

        ds.send(dp);

        // 5，关闭资源。

        ds.close();
    }
}
