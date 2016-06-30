package com.fqc.io.utils;



import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * com.fqc.io
 *
 * @author fqc
 * @date 16/1/2
 */
public class IOUtils {

    /**
     * 抽象读写任何二进制流
     *
     * @param is 字节输入流
     * @param os 字节输出流
     * @throws IOException
     */
    public static void dump(InputStream is, OutputStream os) throws IOException {
        try (InputStream source = is; OutputStream dest = os;) {
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }

    /**
     * 带有缓冲的抽象读写任何二进制流
     *
     * @param is 字节输入流
     * @param os 字节输出流
     * @throws IOException
     */
    public static void buffer_dump(InputStream is, OutputStream os) throws IOException {
        try (InputStream source = new BufferedInputStream(is); OutputStream dest = new BufferedOutputStream(os);) {
            byte[] data = new byte[1024];
            int length = 0;
            while ((length = source.read(data)) != -1) {
                dest.write(data, 0, length);
            }
        }
    }

    /**
     * 字符流读写
     *
     * @param src  字符输入流
     * @param desc 字符输出流
     * @throws IOException
     */
    public static void charDump(Reader src, Writer desc) throws IOException {
        try (Reader input = src; Writer output = desc;) {
            char[] data = new char[1024];
            int length = 0;
            while ((length = input.read(data)) != -1) {
                output.write(data);
            }
        }
    }

    /**
     * 指定字符编码的字符流读写
     *
     * @param src     字节输入流
     * @param desc    字节输出流
     * @param charSet 字符编码
     * @throws IOException
     */
    public static void charDump(InputStream src, OutputStream desc, String charSet) throws IOException {
        charDump(
                new InputStreamReader(src, charSet),
                new OutputStreamWriter(desc, charSet)
        );
    }

    /**
     * 默认系统字符编码的字符流读写
     *
     * @param src  字节输入流
     * @param desc 字节输出流
     * @throws IOException
     */
    public static void charDump(InputStream src, OutputStream desc) throws IOException {
        charDump(src, desc, System.getProperty("file.encoding"));
    }


    /**
     * 获取当前工程路径
     *
     * @return projectPath
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取类到包名
     *
     * @param clazz
     * @return
     */
    public static String getPackagePath(Class clazz) {
        return clazz.getPackage().getName();
    }

    /**
     * 创建文件
     *
     * @param destFileName
     * @return
     */
    public static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        if (file.exists()) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return false;
        }
        //判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                return false;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                System.out.println("创建单个文件" + destFileName + "成功！");
                return true;
            } else {
                System.out.println("创建单个文件" + destFileName + "失败！");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
            return false;
        }
    }

    /**
     * 创建目录
     *
     * @param destDirName
     * @return
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }


    public static String createTempFile(String prefix, String suffix, String dirName) {
        File tempFile = null;
        if (dirName == null) {
            try {
                //在默认文件夹下创建临时文件
                tempFile = File.createTempFile(prefix, suffix);
                //返回临时文件的路径
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建临时文件失败！" + e.getMessage());
                return null;
            }
        } else {
            File dir = new File(dirName);
            //如果临时文件所在目录不存在，首先创建
            if (!dir.exists()) {
                if (!createDir(dirName)) {
                    System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
                    return null;
                }
            }
            try {
                //在指定目录下创建临时文件
                tempFile = File.createTempFile(prefix, suffix, dir);
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建临时文件失败！" + e.getMessage());
                return null;
            }
        }
    }

    /**
     * 从url流中读取文字，封装使用commons io
     *
     * @param url
     */
    public static void readUrl(String url) {
        InputStream in = null;
        try {
            in = new URL(url).openStream();
            System.out.println(org.apache.commons.io.IOUtils.toString(in));//直接封装了 inputStreamReader BufferReader
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    /**
     * 读取文件
     *
     * @param filePath
     */
    public static void readFile(String filePath) {
        File file = new File(filePath);
        try {
            List lines = org.apache.commons.io.FileUtils.readLines(file, "UTF-8");
            for (Object line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //region 测试
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    //endregion
}
