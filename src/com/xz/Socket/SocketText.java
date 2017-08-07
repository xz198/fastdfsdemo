package com.xz.Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

/**
 * Created by Administrator on 2017/8/7.
 */
public class SocketText {
    public static void main(String[] args) throws Exception {
        String strPage = "/";
        String strServer="www.baidu.com";
        InetAddress urlName = InetAddress.getByName(strServer);
        int port=80;
        /*
             *  socket编程一般步骤
             *（1） 创建Socket；
             *（2） 打开连接到Socket的输入/出流；
             *（3） 按照一定的协议对Socket进行读/写操作；
             *（4） 关闭Socket.
             * 其中address、host和port分别是双向连接中另一方的IP地址、主机名和端 口号，
             * stream指明socket是流socket还是数据报socket，localPort表示本地主机的端口号，
             * localAddr和 bindAddr是本地机器的地址（ServerSocket的主机地址）
         * */
        Socket socket=new Socket(urlName,port);
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        /**
         * HTTP1.1
         * 它支持持续连接.
         * 与之相对的
         * HTTP1.0
         * 当连接建立起来以后,浏览器发送一个请求,之后一个回应消息被送回来.然后TCP连接被释放.
         * 所以发生了阻塞
         * */
        wr.write("GET " + strPage + " HTTP/1.0\r\n");
        wr.write("HOST:" + strServer + "\r\n");
        wr.write("Accept:*/*\r\n");
        wr.write("\r\n");
        wr.flush();
        //接收Socket返回的结果,并打印出来
        BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null)
        {
            System.out.println(line);
        }
        wr.close();
        rd.close();
    }
}
