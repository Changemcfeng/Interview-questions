package com.example.reidsspringboot;

/**
 * @Auther: Mcfeng
 * @Date: 2020/10/28 17:09
 * @Description:
 */
public class CalculateTwo {
        public static int cal(int number){
            //计数器
            int count=0;
            for (int i=0;i<=number;i++){
                count=cal2(count,i);
            }
            return count;
        }
        //判断该数字有多少个2
        public static int cal2(int count,int temp){
            int number =temp;
            int index=0;
            //计算位数
            while (number>0){
                number=number/10;
                index++;
            }
            number =temp;
            //逐位判断，有2就计数器加1；
            for (int i=1;i<=index;i++){
                if (number%(Math.pow(10,i))==2){
                    count++;
                }
                //位数上升
                number=number/10;
            }
            return count;
        }
    }

}