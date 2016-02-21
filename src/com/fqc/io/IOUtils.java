package com.fqc.io;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * com.fqc.io
 *
 * @author fqc
 * @date 16/1/2
 */
public class IOUtils {
    public static void dump(InputStream is, OutputStream os) throws IOException {
        try (InputStream source = is; OutputStream dest = os;) {
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }

    public static void buffer_dump(InputStream is, OutputStream os) throws IOException {
        try (InputStream source = new BufferedInputStream(is); OutputStream dest = new BufferedOutputStream(os);) {
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }

    public static void charDump(Reader src, Writer desc) throws IOException {
        try (Reader input = src; Writer output = desc;) {
            char[] data = new char[1024];
            int length = 0;
            while ((length = input.read(data)) != -1) {
                output.write(data);
            }
        }
    }

    public static void charDump(InputStream src, OutputStream desc, String charSet) throws IOException {
        charDump(
                new InputStreamReader(src, charSet),
                new OutputStreamWriter(desc, charSet)
        );
    }


    public static void charDump(InputStream src, OutputStream desc) throws IOException {
        charDump(src, desc, System.getProperty("file.encoding"));
    }


    /**
     * 一行一行读取文件，适合字符读取，若读取中文字符时会出现乱码
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     *
     * @throws IOException
     */

    public void readFile01() throws IOException {
        FileReader fr = new FileReader("/Users/fqc/git_workspace/Java_Basic/src/samples/2013-05-30.log");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] arrs = null;
//        while ((line = br.readLine())!=null) { //apache isEmpty (line = br.readLine())!=null
//            if (!line.equals("")) {//line != ""
        HashMap<String, List> logMaps = new HashMap<String, List>();;
//        HashSet set = new HashSet();
        ArrayList dateList = new ArrayList();
        while (StringUtils.isNotEmpty(line = br.readLine())) {

            arrs = line.split(" -- ");
            System.out.println(arrs[0] + " : " + arrs[1]);
            String ip = arrs[0];
            String date = arrs[1];
            dateList.add(date);
            logMaps.put(ip, dateList);

        }
        br.close();
        fr.close();
        System.out.println(logMaps.get("27.19.74.143"));
    }


}
