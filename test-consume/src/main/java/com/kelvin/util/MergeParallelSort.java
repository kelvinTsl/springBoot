package com.kelvin.util;

import java.util.concurrent.CountDownLatch;

/**
 * 并行归并排序
 * Created by tangshulei on 2017/9/27.
 */
public class MergeParallelSort {

    private static final int maxAsDep = (int)(Math.log((Runtime.getRuntime().availableProcessors()))/Math.log(2));

    public static void sort(int[] numbers){
        sort(numbers,maxAsDep);
    }

    public static void sort(int[] numbers, int asDep){
        parallelSort(numbers,0,numbers.length,asDep>maxAsDep?maxAsDep:asDep,1);
    }

    private static void parallelSort(final int[] numbers, final int pos, final int end, final int asDep, final int dep){
        if(end - pos > 1){
            final CountDownLatch mergeSingle = new CountDownLatch(2);
            final int offset = (pos + end)/2;
            Thread thread1 = new SortThread(numbers,pos,offset,mergeSingle,asDep,dep);
            Thread thread2 = new SortThread(numbers,offset,end,mergeSingle,asDep,dep);
            thread1.start();
            thread2.start();
            try {
                mergeSingle.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MergeSort.merge(numbers,pos,offset,end);
        }
    }
    private static class SortThread extends Thread{

        private int[] numbers;
        private int pos;
        private int end;
        private CountDownLatch mergeSingle;
        private int asDep;
        private int dep;

        public SortThread(int[] numbers, int pos, int end, CountDownLatch mergeSingle, int asDep, int dep){
            this.numbers = numbers;
            this.pos = pos;
            this.end = end;
            this.mergeSingle = mergeSingle;
            this.asDep = asDep;
            this.dep = dep;
        }

        @Override
        public void run() {
            if(dep < asDep){
                parallelSort(numbers,pos,end,asDep,(dep+1));
            }else{
                MergeSort.sort(numbers,pos,end);
            }
            mergeSingle.countDown();
        }
    }

}
