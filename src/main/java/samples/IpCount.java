package samples;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * samples
 *
 * @author fqc
 * @date 16/3/21
 */
public class IpCount {
    /**
     * 一行一行读取文件，适合字符读取，若读取中文字符时会出现乱码
     * 流的关闭顺序：先打开的后关，后打开的先关，
     * 否则有可能出现java.io.IOException: Stream closed异常
     * @throws java.io.IOException
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
            arrs = line.split(" -- \\[");
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
