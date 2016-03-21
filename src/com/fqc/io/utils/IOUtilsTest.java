package com.fqc.io.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class IOUtilsTest {

    IOUtils ioUtils = null;
    @Before
    public void setUp() throws Exception {
        System.out.println("执行开始======");
        ioUtils = new IOUtils();//由于之后修改为了静态方法，所以该实例化相关的操作可以省略。
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("执行完毕======");
    }

    @Test
    public void testFileDump() throws IOException{
        InputStream is = new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/Utils.java");
        FileOutputStream os = new FileOutputStream(new File("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/Utils.txt"));
        ioUtils.dump(is, os);
    }

    @Test
    public void testUriDump() throws Exception {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        FileOutputStream os = new FileOutputStream(new File("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu.txt"));
        ioUtils.dump(is, os);
    }


    @Test //scanner 包装InputStream
    public void testScanerFileInput() throws Exception {
        System.setIn(new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu.txt"));
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }


    @Test
    public void testCharDump() throws Exception {
        FileReader fileReader = new FileReader("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu.txt");
        StringWriter stringWriter = new StringWriter();
        ioUtils.charDump(fileReader,stringWriter);
        System.out.println(stringWriter.toString());
    }


    @Test
    public void testCharDump1() throws Exception {
        ioUtils.charDump(
                new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu.txt"),
                new FileOutputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu2.txt"),
                "utf-8"
        );
    }

    @Test
    public void testCharDump2() throws Exception {
        ioUtils.charDump(
                new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu.txt"),
                new FileOutputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu2.txt")
        );
    }

    @Test
    public void testDump() throws Exception {

    }

    @Test
    public void testBuffer_dump() throws Exception {

    }



    @Test
    public void testGetProjectPath() throws Exception {
        System.out.println(ioUtils.getProjectPath());
    }

    @Test
    public void testReadUrl() throws Exception {
        ioUtils.readUrl("https://www.baidu.com");
    }

    @Test
    public void testReadFile() throws Exception {
        ioUtils.readFile("/Users/fqc/github/Java_Basic/src/com/fqc/io/file/baidu.txt");
    }

    @Test
    public void testGetPackagePath() throws Exception {
        System.out.println(ioUtils.getPackagePath(this.getClass()));
    }
}