package com.example.reidsspringboot;

/**
 * @program: ArrayRotate
 * @Auther: Mcfeng
 * @Date: 2020/10/26 16:28
 * @Description: 将二维数组旋转90度
 */
public class ArrayRotate {
   //将二维数组（n*n）旋转90度
    public static int[][] rotateTwoArray(int[][] array) {
        //行长度
        int row = array.length;
        //列长度
        int column = array[0].length;
        //临时数组
        int[][] temp = new int[row][array[0].length];
        //使用对角线依次往里循环
        for (int i = 0; i < row; i++) {
            //往下一个环形区域进行斜线等价互换
            for (int k = i; k <= column - i - 1; k++) {
                //斜线等价互换（冒泡常用）
                //将数组第一行的值赋给新数组的最右侧一列
                temp[k][column - i - 1] = array[i][k];
                //将数组最右侧一列的值赋给新数组最下面一列的值（逆序赋值给新数组）
                temp[row - i - 1][column-k-1] = array[k][column - i - 1];
                //将数组最下面一列的值赋值给新数组左侧一列（逆序赋值给新数组）
                temp[column-k-1][i] = array[row - i - 1][column-k-1];
                //将数组左侧一列的值赋给新数组第一行（回到开始）
                temp[i][k] = array[column-k-1][i];
            }
        }
        return temp;
    }
}
