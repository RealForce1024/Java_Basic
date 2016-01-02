package com.fqc.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;

import static org.junit.Assert.*;

public class UtilsTest {

    Utils utils = null;
    @Before
    public void setUp() throws Exception {
        System.out.println("执行开始======");
        utils = new Utils();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("执行完毕======");
    }

    @Test
    public void testFileDump() throws IOException{
        InputStream is = new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/Utils.java");
        FileOutputStream os = new FileOutputStream(new File("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/Utils.txt"));
        utils.dump(is, os);
    }

    @Test
    public void testUriDump() throws Exception {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        FileOutputStream os = new FileOutputStream(new File("/Users/fqc/git_workspace/Java_Basic/src/com/fqc/io/baidu.txt"));
        utils.dump(is, os);
    }
}