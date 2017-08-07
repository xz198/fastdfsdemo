package com.xz.URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/8/7.
 */
public class URLText {
    public static void main(String[] args) throws Exception {
        // 创建 url 对象 并且 写入请求路径
        URL url=new URL("https://www.baidu.com/");
        // 通过  url 打开连接
        URLConnection urlConnection=url.openConnection();
        //  urlConnection 打开到此 URL 引用的资源的通信链接
        urlConnection.connect();
        // 创建 字节数组
        byte [] b=new byte[1024];
        // 以字节流的方式 读取 网页内容
        InputStream in = urlConnection.getInputStream();
        //  创建 输出流 outputStream 创建文件地址
        OutputStream outputStream=new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\baidu.txt"));
        while (in.read(b)!=-1){
            // 循环 写入 文件中
            outputStream.write(b);
        }
        // 关闭
        outputStream.close();
        in.close();
    }

}
