package com.kelvin.util;

/**
 * Created by tangshulei on 2017/9/28.
 */
public class ChooseSort {
    public static void sort(int[] numbers){
        int size = numbers.length;

        for(int j = 0;j<size;j++){
            int minX = j;
            for (int i = j; i < numbers.length; i++) {
                if (numbers[minX] > numbers[i]) {
                    minX = i;
                }
            }
            int temp = numbers[minX];
            numbers[minX] = numbers[j];
            numbers[j] = temp;
        }
    }
}
