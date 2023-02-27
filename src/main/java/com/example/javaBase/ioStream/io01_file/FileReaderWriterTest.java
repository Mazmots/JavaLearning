package com.example.javaBase.ioStream.io01_file;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileReaderWriterTest {

    private final String basePath = "src/main/java/com/example/javaBase/ioStream/io01_file/file/";

    @Test
    public void test01() throws IOException {

        // fileReader 从磁盘读文件
        File file = new File(basePath+ "1.txt");
        FileReader fileReader = new FileReader(file);
//        System.out.println((char)(fileReader.read()));

//        int read = fileReader.read();
//        while (read!=-1) {
//            read = fileReader.read();
//            System.out.println(read);
//        }
        char[] buff = new char[5];
        int read = fileReader.read(buff);
        while (read!=-1) {
            System.out.println(buff);
            read = fileReader.read(buff);
        }
        fileReader.close();


    }

    @Test
    public void test02() throws IOException {

        // fileWriter 写文件到磁盘
        // 要写的文件名称
        File file = new File(basePath + "output.txt");
        // 创建输出流
        FileWriter fw = new FileWriter(file, true);

        fw.write("123456");
        fw.write("abababa");
        fw.write("急急急");

        fw.close();

    }

    // 复制文件
    @Test
    public void test03() throws IOException {
        File src = new File(basePath + "src.txt");
        File tgt = new File(basePath + "tgt.txt");

        FileReader fr = new FileReader(src);
        FileWriter fw = new FileWriter(tgt);

        // 读和写
        char[] buff = new char[5];
        int len;
        while ((len = fr.read(buff)) != -1) {

            fw.write(buff,0,len);
        }

        fw.close();
        fr.close();

    }










}
