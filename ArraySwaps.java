package com.example.reidsspringboot;
/**
 * The triangle is the most balanced
 */

import java.util.Arrays;

/**
 * @program: reids-springboot
 * @Auther: Mcfeng
 * @Date: 2020/10/26 12:30
 * @Description: 二维数组行列互换
 */
public class ArraySwaps {

    //数组的行和列互换（前提是数组的行等于列）
    public static void swampTwoArray(int[][] array){
        int temp;
        int len=array.length;
        for (int i=0;i<len;i++){
            int len1=array[i].length;
            for (int k=i;k<len1;k++){
                temp=array[i][k];
                array[i][k]=array[k][i];
                array[k][i]=temp;
            }
        }
    }
    //打印二维数组
    public static void printTwoArray(int[][] array){
        for (int[] arr:array) {
            System.out.println(Arrays.toString(arr));
        }
    }
}