package com.kelvin.util;

import java.util.Random;

/**
 * 归并排序
 * Created by tangshulei on 2017/9/21.
 */
public class MergeSort {

    public static void sort(int[] numbers){
        sort(numbers,0,numbers.length);
    }

    public static void sort(int[] numbers,int pos,int end){
        if(end - pos > 1){
            int offset = (end + pos)/2;
            sort(numbers,pos,offset);
            sort(numbers,offset,end);
            merge(numbers,pos,offset,end);
        }
    }

    public static void merge(int[] numbers,int pos,int offset,int end){
        int[] array1 = new int[offset - pos];
        int[] array2 = new int[end - offset];
        System.arraycopy(numbers,pos,array1,0,array1.length);
        System.arraycopy(numbers,offset,array2,0,array2.length);
        for(int i = pos,j=0,k=0;i<end;i++){
            if(j == array1.length){
                System.arraycopy(array2,k,numbers,i,array2.length-k);
                break;
            }
            if(k == array2.length){
                System.arraycopy(array1,j,numbers,i,array1.length-j);
                break;
            }
            if(array1[j] <= array2[k]){
                numbers[i] = array1[j++];
            }else{
                numbers[i] = array2[k++];
            }
        }
    }

    public static void main(String[] args){
        int[] numbers = new int[40];
        for(int i=0;i<40;i++){
            numbers[i] = new Random().nextInt(400000);
        }
//        MergeSort.guiSort(numbers,0,numbers.length);
        long start = System.currentTimeMillis();
        System.out.println(start + ":ms");
        MergeParallelSort.sort(numbers,5);
        long time = System.currentTimeMillis()-start;
        System.out.println(time + ":ms");
        for(int i : numbers) {
            System.out.print(i + ",");
        }
    }
}
