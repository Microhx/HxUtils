package com.xinglib;

import java.io.*;

/**
 * @version :
 * <p>
 * desc :
 * @author: Java
 * <p>
 * 纵然万劫不复，纵然相思入骨，我依然待你眉眼如初，岁月如故。
 * <p>
 * <p>
 * @date : 2019/5/5
 * <p>
 *
 *  IO流操作工具类
 *
 */
public class IOUtils {

    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 保存内容
     *
     * @param filePath
     * @param content
     */
    public static void saveContent2File(String filePath, String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(writer);
        }
    }

    /**
     * 保存字节流
     * @param filePath
     * @param outputStream
     */
    public static void saveOutputStream(String filePath, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;

        byte[] bytes = new byte[1024 * 4];
        int length;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            while ((length = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, length);
                bufferedOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeQuietly(bufferedInputStream);
            closeQuietly(bufferedOutputStream);
        }
    }


    /**
     * 获取文件内容
     * @param filePath
     * @return
     */
    public static String getFileContent(String filePath) {
        BufferedReader reader = null ;
        StringBuilder stringBuilder = new StringBuilder();
        String line ;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            closeQuietly(reader);
        }

        return stringBuilder.toString();
    }

}
