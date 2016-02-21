package samples;

import com.fqc.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * samples
 *
 * @author fqc
 * @date 16/2/21
 */
public class LogAnalysis {
    public static void main(String[] args) {
        //读取文件
        //分析字段

        try {
            IOUtils.buffer_dump(new FileInputStream("/Users/fqc/git_workspace/Java_Basic/src/samples/2013-05-30.log"),System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
