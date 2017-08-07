package com.xz.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/**
 * Created by Administrator on 2017/8/6.
 */
public class FastDFS {
    public static void main(String[] args) throws IOException,Exception{
        //  读取配置文件
        ClientGlobal.init("E:\\fastdfsdemo\\src\\config\\fdfs_client.conf");
        // 创建 一个 trackerClient 对象
        TrackerClient trackerClient = new TrackerClient();
        //  通过 trackerClient 对象 获取 TrackerServer连接
        TrackerServer connection = trackerClient.getConnection();
        //  创建 一个 storageServer 对象
        StorageServer storageServer = null;
        //StorageClient storageClient = new StorageClient(connection,storageServer);
        // 创建 storageClient1
        StorageClient1 storageClient1=new StorageClient1(connection,storageServer);
        //
        // 使用 storageClient 对象的 upload_file上传图片
        /*
            创建 一个 storageClient 对象
            参数1：为 文件路径（不包含中文）
            参数2：为 文件拓展名
            参数3：为 文件扩展信息
          */
        //String[] pngs = storageClient.upload_file("D:\\Documents\\Pictures\\8.jpg", "png", null);
        String png = storageClient1.upload_file1("D:\\Documents\\Pictures\\1.jpg", "png", null);
        System.out.println(png);
    }
    @Test
    public void testDownload() {
        try {
            // 初始化 配置文件
            ClientGlobal.init("E:\\fastdfsdemo\\src\\config\\fdfs_client.conf");
            //  创建 TrackerClient 对象
            TrackerClient tracker = new TrackerClient();
            // 通过 TrackerClient 对象 获取 连接 得到 trackerServer
            TrackerServer trackerServer = tracker.getConnection();
            // 创建 storageServer 对象 并复制为空
            StorageServer storageServer = null;
            //  创建 storageClient 对象 需要 trackerServer，storageServer
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            // 下载 download_file group1 图片存储的组名 M00/00/00/wKiegFmHfZaAMZRsAAAeSG2ZHc4760.png 文件保存地址
            byte[] b = storageClient.download_file("group1", "M00/00/00/wKiegFmHfZaAMZRsAAAeSG2ZHc4760.png");
            System.out.println(b);
            // 使用 fileOutputStream 对象 将文件保存至D:\a.jpg
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.jpg");
            //  将字节 数组 b 写入
            fileOutputStream.write(b);
            // 关流
            fileOutputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
