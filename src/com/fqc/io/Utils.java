package com.fqc.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * com.fqc.io
 *
 * @author fqc
 * @date 16/1/2
 */
public class Utils {
    private void dump(InputStream is, OutputStream os) throws IOException{
        try(InputStream source = is; OutputStream dest = os;){
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data))!=-1){
                dest.write(data,0,length);
            }
        }
    }
}
