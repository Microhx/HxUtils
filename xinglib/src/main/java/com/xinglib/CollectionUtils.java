package com.xinglib;


import java.util.*;

/**
 * @version : v0.0.9
 * <p>
 * desc :
 * @author: Java
 * <p>
 * 纵然万劫不复，纵然相思入骨，我依然待你眉眼如初，岁月如故。
 * <p>
 * <p>
 * @date : 2019/5/5
 * <p>
 * 集合类的方法整理
 *
 * <p>
 */
public class CollectionUtils {

    /**
     * 集合是否存在 & 是否为空
     */
    public static boolean collectionExists(Collection<?> collection) {
        return null != collection && !collection.isEmpty();
    }


    /**
     * 获取安全型的List
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> getSafeList(List<T> list) {
        if(collectionExists(list)) return list;
        return new ArrayList<>();
    }


    /**
     * 获取安全型的Set
     * @param set
     * @param <T>
     * @return
     */
    public static <T> Set<T> getSafeSet(Set<T> set) {
        if(collectionExists(set)) return set;
        return new HashSet<>();
    }


    /**
     * 检查index位置
     *
     * @param collection
     * @param index
     * @return
     */
    public static boolean checkCollectionIndex(Collection<?> collection, int index) {
        if (!collectionExists(collection)) return false;
        return index >= 0 && index < collection.size();
    }


    /**
     * 将Collection集合转化成数组
     *
     * @param list
     * @return
     */
    public static String[] listConvertArray(Collection<String> list) {
        if (!collectionExists(list)) return new String[0];

        Iterator<String> iterator = list.iterator();
        String[] array = new String[list.size()];
        for (int i = 0; i < array.length && iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    /**
     * 将Collection集合转化成int数组
     * @param list
     * @return
     */
    public static int[] listConvertIntArray(Collection<Integer> list) {
        if (!collectionExists(list)) return new int[0];

        Iterator<Integer> iterator = list.iterator();
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length && iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }


    /**
     * 将Collection集合转成为float数组
     * @param list
     * @return
     */
    public static float[] listConvertFloatArray(Collection<Float> list) {
        if (!collectionExists(list)) return new float[0];

        Iterator<Float> iterator = list.iterator();
        float[] array = new float[list.size()];
        for (int i = 0; i < array.length && iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }


    /**
     * 将Collection集合转化为double数组
     * @param list
     * @return
     */
    public static double[] listConvertDoubleArray(Collection<Double> list) {
        if (!collectionExists(list)) return new double[0];

        Iterator<Double> iterator = list.iterator();
        double[] array = new double[list.size()];
        for (int i = 0; i < array.length && iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }


    /**
     * 将集合转化成数组
     * @param collection
     * @param format
     * @return
     */
    public static String collectionFormat2String(Collection<?> collection, String format) {
        if(collectionExists(collection)) return "";

        Iterator<?> objectIterator = collection.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (objectIterator.hasNext()) {
            stringBuilder.append(objectIterator.next());
            stringBuilder.append(format);
        }

        //去掉最后的格式
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
