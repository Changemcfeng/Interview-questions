package com.example.reidsspringboot;
/**
 * @program: reids-springboot
 * @Auther: Mcfeng
 * @Date: 2020/10/26 20:02
 * @Description: 不使用+实现加法
 */
public class BitAdd {
    public static int bitAdd(int a, int b) {
        //">>"是右移，将左边的对象往右移动（/2）
        //"<<"是左移，将右边的对象往左移（*2）
        //异或，1^1=0 1^0=1 0^1=1, 与加法类似（但是不能进位）
        int temp = a ^ b;
        //与， 1&1 =1 1&0=0 0&0=0 ,判断进位，如果再将结果*2（左移两位）不就与进位一个效果
        int temp2 = (a & b) << 1;
        //将进位后的数与之前异或的数，再异或，不就是加法吗？
        int sum = temp ^ temp2;
        return sum;
    }
}