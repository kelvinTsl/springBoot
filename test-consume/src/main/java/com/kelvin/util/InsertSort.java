package com.kelvin.util;

/**
 * 冒泡排序
 * Created by tangshulei on 2017/9/27.
 */
public class InsertSort {

    public static void sort(int[] numbers){
        for(int i=0; i<numbers.length;i++){
            for(int j=numbers.length-1;j>i;j--){
                if(numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
