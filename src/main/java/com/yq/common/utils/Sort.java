package com.yq.common.utils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Auther: yq
 * @Date: 2018-10-23 09:27
 * @Description:
 */
public class Sort {

    private static Integer count;

    public static void sort(int num,int[] array,int begin,LinkedList<Integer> list){
        Integer l;
        for(int j = begin;j<array.length;j++){
            l = array[j];
            list.add(l);
            if(list.size() == num){
                int[] i2 = new int[num];
                for(int n = 0;n<num;n++){
                    i2[n] = list.get(n);
                }
                permutate(i2,0);
                list.removeLast();
            }else{
                sort(num,array, j + 1,list);
            }
        }
        if(list.size() != 0)
            list.removeLast();
    }

    public static void permutate(int[] data, int begin){
        int length = data.length;
        if(length == begin) {
            count++;
            System.out.println(Arrays.toString(data));
        }
        for(int i = begin ; i < length; i++) {
            if(isUnique(data, begin, i)){
                swap(data, begin, i);
                permutate(data, begin + 1);
                swap(data, begin, i);
            }
        }
    }

    private static boolean isUnique(int[] data, int begin, int end){
        for(int i = begin; i < end; i++)
            if(data[i] == data[end])
                return false;
        return true;
    }

    private static void swap(int[] data, int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

}
