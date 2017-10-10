package com.kelvin.util;

/**
 * Created by tangshulei on 2017/9/27.
 */
public class QuickSort {

    public static void sort(int[] numbers){
        quickSort(numbers,0,numbers.length-1);
    }

    public static void quickSort(int[] numbers,int pos,int end){
        if(pos < end) {
            int mid = getMid(numbers,pos,end);
            quickSort(numbers, pos, mid - 1);
            quickSort(numbers, mid + 1, end);
        }
    }

    public static int getMid(int[] numbers, int pos, int end){
        int temp = numbers[pos];
        while(end > pos){
            while(pos < end && numbers[end] >= temp){
                end--;
            }
            numbers[pos] = numbers[end];
            while(pos < end && numbers[pos] <= temp){
                pos++;
            }
            numbers[end] = numbers[pos];
        }
        numbers[pos] = temp;
        return pos;
    }

    public static void main(String[] args){
        int[] numbers = {1341,435,435,5,8,9,6,32,456,213,14124};
        sort(numbers);
        for(int i : numbers){
            System.out.print(i + ",");
        }
    }
}
