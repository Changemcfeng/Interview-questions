package com.example.reidsspringboot;
/**
 * The triangle is the most balanced
 */

import java.util.Arrays;

/**
 * @program: springboot
 * @Auther: Mcfeng
 * @Date: 2020/10/26 10:35
 * @Description: 打印杨辉三角
 */
public class YHTriangle {

    public static void main(String[] args) {
        YHPrint(0);
    }
    //打印空格和二维数组
    public static void YHPrint(int row) {
        int [][] array=YHArray(row);
        int len = array.length;

        for (int i = 0; i < len; i++) {
            //打印空格(n n-1 n-2 ... 1)
            for (int j = len - i; j > 0; j--) {
                System.out.print(" ");
            }
            //打印二维数组+空格
            for (int k=0;k<=i;k++){
                System.out.print(array[i][k]);
                System.out.print(" ");
            }
            //换行
            System.out.println();
        }
    }
    //生成杨辉数组（利用init[i][k]=init[i-1][k-1]+init[i-1][k]性质）
    private static int[][] YHArray(int row) {
        if (row <= 0) {
            return new int[0][0];
        }
        int temprow = row;
        int[][] init = new int[row][row];
        init[0][0] = 1;
        for (int i = 1; i < row; i++) {
            init[i][0]=init[i][i]=1;
            if (i>1){
                for (int k=1;k<i;k++){
                    init[i][k]=init[i-1][k-1]+init[i-1][k];
                }
            }
        }
        return init;
    }

}
