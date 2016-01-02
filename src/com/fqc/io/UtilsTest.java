package com.fqc.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UtilsTest {

    Utils utils = null;
    @Before
    public void setUp() throws Exception {
        System.out.println("执行开始======");
        utils = new Utils();//由于之后修改为了静态方法，所以该实例化相关的操作可以省略。
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("执行完毕======");
    }

    @Test
    public void testFileDump() throws IOException{
        InputStream is = new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/Utils.java");
        FileOutputStream os = new FileOutputStream(new File("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/Utils.txt"));
        utils.dump(is, os);
    }

    @Test
    public void testUriDump() throws Exception {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        FileOutputStream os = new FileOutputStream(new File("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/file/baidu.txt"));
        utils.dump(is, os);
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
}