package com.kelvin.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * Created by tangshulei on 2017/9/27.
 */
public class SortTest {

    public static void main(String[] args){
        testSort();
//        testCoumputeTime("MergeParallelSort",40000,4);
//        testCoumputeTime("MergeSort",40000,4);
//        testCoumputeTime("InsertSort",100,4);
//        testCoumputeTime("QuickSort",40000,4);
//        testCoumputeTime("FastSort",4000,4);
        testCoumputeTime("ChooseSort",100,4);
    }

    public static void testSort(){
        File classPath = new File(SortTest.class.getResource("").getFile());
        File[] classFiles = classPath.listFiles();
        for(int i = 0; i < classFiles.length; i++){
            if(classFiles[i].getName().endsWith("Sort.class")){
                testSortIsCorrect(classFiles[i].getName().split("\\.")[0]);
            }
        }
    }

    public static void testSortIsCorrect(String className){
        System.out.print("---测试 " + className + " 是否有效------");
        for(int i=0; i<50; i++){
            int[] numbers = getRandomInt(1000);
            invoke(numbers,className);
            for(int k=0; k<numbers.length-1; k++){
                if(numbers[k] > numbers[k+1]){
                    String errorMsg = "-----测试错误---" + className + "第"+k+"位:" + numbers[k] + "大于第"+(k+1)+"位:" + numbers[k+1];
                    System.out.println(errorMsg);
                    throw new RuntimeException(errorMsg);
                }
            }
        }
        System.out.println("-------" + className + "测试有效");
    }

    public static void testCoumputeTime(String className,int initNumber,int times,Object... args){
        long[] timeArray = new long[times];
        for(int i=initNumber,j=0;j<times;j++,i=i*10){
            timeArray[j] = coumputeTime(className,i);
        }
        System.out.print("时间增加比例:");
        for(int i = 1; i < times; i++){
            if(timeArray[i-1] != 0) {
                System.out.print(timeArray[i] / timeArray[i - 1] + ",");
            }
        }
        System.out.println();
    }
    public static long coumputeTime(String className,int length){
        int[] numbers = getRandomInt(length);
        System.out.print("测试"+className+",数量:" + length);
        long start = System.currentTimeMillis();
        invoke(numbers,className);
        long time = System.currentTimeMillis()-start;
        System.out.println(",耗时:"+time);
        return time;
    }


    public static void invoke(int[] numbers, String className,Object... args){
        try {
            Class sort = Class.forName("com.kelvin.util." + className);
            Class<?>[] paramTypes = new Class<?>[args.length+1];
            Object[] params = new Object[args.length + 1];
            params[0] = numbers;
            paramTypes[0] = int[].class;
            for(int i = 0; i<args.length; i++){
                paramTypes[i+1] = args[i].getClass();
                params[i+1] = args[i];
            }
            Method method = sort.getDeclaredMethod("sort",paramTypes);
            method.invoke(null,params);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static int[] getRandomInt(int length){
        int[] numbers = new int[length];
        for(int i=0; i< length;i++){
            numbers[i] = new Random().nextInt(length);
        }
        return numbers;
    }
}
