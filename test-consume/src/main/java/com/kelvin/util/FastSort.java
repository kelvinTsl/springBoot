package com.kelvin.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangshulei on 2017/9/27.
 */
public class FastSort {

    public static void sort(int[] numbers){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            res.add(numbers[i]);
        }
        res = sort(res);
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = res.get(i);
        }
    }

    public static List<Integer> sort(List<Integer> numbers){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int one = numbers.get(0);
        for(int i=1,j=0,k=0; i<numbers.size(); i++){
            if(one > numbers.get(i)){
                list1.add(numbers.get(i));
                j++;
            }else{
                list2.add(numbers.get(i));
                k++;
            }
        }
        if(list1.size() > 1){
            list1 = sort(list1);
        }
        if(list2.size() > 1){
            list2 = sort(list2);
        }
        for(int i=0; i<list1.size();i++){
            result.add(list1.get(i));
        }
        result.add(one);
        for(int i=0; i<list2.size();i++){
            result.add(list2.get(i));
        }
        return result;
    }

    public static void main(String[] args){
        int[] numbers = {2,1,3,4,5,34,34,6,34,643,534,543,5};
        sort(numbers);
        for(int i : numbers){
            System.out.print(i + ",");
        }
    }
}
