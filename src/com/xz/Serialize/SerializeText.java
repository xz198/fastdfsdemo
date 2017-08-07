package com.xz.Serialize;

import java.io.*;

/**
 * Created by Administrator on 2017/8/7.
 */
public class SerializeText {
    public static void main(String[] args) throws Exception {
        Person person=new Person();
        person.setId(1);
        person.setName("小智");
        // 序列化 对象 至本地硬盘文件中去
        /*ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\Person")));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();*/
        // 将本地硬盘中文件 反序列化 为内存中的一个对象
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\Person")));
        Person personRead =(Person) objectInputStream.readObject();
        System.out.print(person);
    }
}
