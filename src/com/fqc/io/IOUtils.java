package com.fqc.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * com.fqc.io
 *
 * @author fqc
 * @date 16/1/2
 */
public class IOUtils {
    public static void dump(InputStream is, OutputStream os) throws IOException{
        try(InputStream source = is; OutputStream dest = os;){
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data))!=-1){
                dest.write(data,0,length);
            }
        }
    }
    public static void buffer_dump(InputStream is, OutputStream os) throws IOException{
        try(InputStream source = new BufferedInputStream(is); OutputStream dest = new BufferedOutputStream(os);){
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data))!=-1){
                dest.write(data,0,length);
            }
        }
    }

    public static void charDump(Reader src, Writer desc) throws  IOException{
        try (Reader input = src; Writer output = desc;) {
            char[] data = new char[1024];
            int length = 0;
            while ((length=input.read(data))!=-1){
                output.write(data);
            }
        }
    }
    public static void charDump(InputStream src, OutputStream desc, String charSet) throws  IOException{
       charDump(
               new InputStreamReader(src,charSet),
               new OutputStreamWriter(desc,charSet)
       );
    }


    public static void charDump(InputStream src, OutputStream desc) throws  IOException {
        charDump(src, desc, System.getProperty("file.encoding"));
    }











}
