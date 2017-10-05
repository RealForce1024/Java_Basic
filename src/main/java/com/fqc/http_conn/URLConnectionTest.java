package com.fqc.http_conn;

import com.fqc.io.utils.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * com.fqc.http_conn
 *
 * @author fqc
 * @date 16/3/17
 */
public class URLConnectionTest {
    /**
     * 向指定URL发送POST方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是name1=value1&name2=value2的形式。
     * @return URL所代表远程资源的响应
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
//            conn.setRequestProperty( "Content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "Accept", "*/*" );
            //conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization","Bearer 4/PLANzPEabQgYYTbbmXNNyPShg8HZkqYzG5rqWADt/O7IlR7erF1f9B+1kuyr79og35CD/4yPV2CYvkMqbUzw==");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += "/n" + line;
            }
        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    // 提供主方法，测试发送GET请求和POST请求
    public static void main(String args[])
    {
//发送GET请求
//        String s = URLConnectionTest.sendGet("http://localhost:8888/abc/login.jsp",null );
//        System.out.println(s);
//发送POST请求
        String s1 = URLConnectionTest.sendPost("https://ussouthcentral.services.azureml.net/workspaces/2dad6072409241e89b5868a22adced99/services/6c03112ec20d4a5bab652cdfff6e9185/score" ,
        "{\n" +
                "  \"Id\": \"score00001\",\n" +
                "  \"Instance\": {\n" +
                "    \"FeatureVector\": {\n" +
                "      \"age\": \"0\",\n" +
                "      \"workclass\": \"value\",\n" +
                "      \"fnlwgt\": \"0\",\n" +
                "      \"education\": \"value\",\n" +
                "      \"education-i\": \"0\",\n" +
                "      \"marital-status\": \"value\",\n" +
                "      \"occupation\": \"value\",\n" +
                "      \"relationship\": \"value\",\n" +
                "      \"race\": \"value\",\n" +
                "      \"sex\": \"value\",\n" +
                "      \"capital-gain\": \"0\",\n" +
                "      \"capital-loss\": \"0\",\n" +
                "      \"hours-per-week\": \"0\",\n" +
                "      \"native-country\": \"value\"\n" +
                "    },\n" +
                "    \"GlobalParameters\": {}\n" +
                "  }\n" +
                "}");
        System.out.println(s1);
    }
}

