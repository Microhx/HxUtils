package com.xinglib;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * author: Java
 * <p>
 * 纵然万劫不复，纵然相思入骨，我依然待你眉眼如初，岁月如故。
 * <p>
 * date : 2019/5/6
 * <p>
 * version : 1.0.1
 * <p>
 * desc : 文件相关操作类
 */
public class FileUtils {

    /**
     * create the target file for the filePath
     *
     * @param filePath which file path you will create
     * @return true : create success, otherwise error
     */
    public static boolean createFile(String filePath) {
        File file = new File(filePath);

        boolean result = false;
        if (!file.exists() || !file.isFile()) {
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                result = false;
            }
        }
        return result;
    }


    /**
     * return the folder size
     *
     * @param file the file which will be calculated
     * @return the file length , unit byte:)
     */
    public static long getFolderSize(File file) {
        if (!file.exists()) {
            return 0L;
        }

        long size = 0L;

        File[] fileList = file.listFiles();
        for (File aFileList : fileList) {
            if (aFileList == null) continue;

            if (aFileList.isDirectory()) {
                size = size + getFolderSize(aFileList);
            } else {
                size = size + aFileList.length();
            }
        }

        return size;
    }


    /**
     * return the file format size : 12kb 24.3M so on
     *
     * @param size the file size
     * @return format file size
     */
    public static String formatFileSize(double size) {
        double kByte = size / 1024d;
        if (kByte < 1) {
            return size + "B";
        }

        double mByte = kByte / 1024d;
        if (mByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double gByte = mByte / 1024d;
        if (gByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(mByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double tByte = gByte / 1024d;
        if (tByte < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }

        BigDecimal result4 = new BigDecimal(tByte);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }


    /**
     * delete the dictionary , sub files and dictionaries are included
     * @param dir the parent dictionary
     * @return delete success return true
     */
    public static boolean deleteDir(File dir) {
        if (dir == null || !dir.exists())
            return false;

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                boolean success = deleteDir(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    public static boolean deleteDir(String dirPath) {
        return deleteDir(new File(dirPath));
    }


}
