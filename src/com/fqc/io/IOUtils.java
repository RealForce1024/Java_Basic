package com.fqc.io;

import java.io.*;

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
}
