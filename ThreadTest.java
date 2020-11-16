package com.example.reidsspringboot;
/**
 * The triangle is the most balanced
 * @Auther: Mcfeng
 * @Date: 2020/11/10 14:12
 * @Description:
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        Thread m1=new Thread(new Runnable() {
            @Override
            public void run() {
                long old = System.currentTimeMillis();
                while(((System.currentTimeMillis()-old)/1000)<5){ System.out.println("红灯 亮");}
            }
        });
        Thread m2=new Thread(new Runnable() {
            @Override
            public void run() {
                long old = System.currentTimeMillis();
                while(((System.currentTimeMillis()-old)/1000)<4){ System.out.println("绿灯 亮");}
            }
        });
        Thread m3=new Thread(new Runnable() {
            @Override
            public void run() {
                long old = System.currentTimeMillis();
                while(((System.currentTimeMillis()-old)/1000)<2){ System.out.println("黄灯 亮");}
            }
        });

        int i=1;
        while (true){
            if (i>3){i=1;}
            if (i==1){
                m1.run();
                i++;
            }
            if (i==2){
                m2.run();
                i++;
            }
            if (i==3){
                m3.run();
                i++;
            }
        }

    }


}