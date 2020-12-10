package com.example.reidsspringboot.gof23.test;


import java.math.BigDecimal;
import java.util.Scanner;


/**
 * The triangle is the most balanced
 */
//题目：要求：
//数值大于等于1024即向更大的单位转换
//数值小于1即向更小的单位转换
//最小支持Byte，最大支持到TB，超出范围则保持当前单位，不考虑 1/2条件。
//输入数值+单位，输出转换后的数值+单位，如输入： 10240KB，输出10MB（忽略单位字母大小写）
//小数位超过两位，四舍五入保留两位小数
//注意异常处理，如输入错误
//测试用例（请在程序输出一下数据转换后的结果）：
//2048MB：2G
//29340578605Byte：27.33GB
//0.009MB：9.22KB
//4096000GB：4000TB
//3000：输入不正确（或其他类似提示

//空字符 在asc表中最小；
//trim只能左右的空格，中间的空格是无法去除的
//使用replace(" ","")
//replace 的参数是 char 和 CharSequence，即可以支持字符的替换，也支持字符串的替换(CharSequence 即字符串序列的意思，说白了也就是字符串)；
//replaceAll 的参数是 regex，即基于正则表达式的替换。比如，可以通过 replaceAll ("\d", “*”) 把一个字符串所有的数字字符都换成星号；
//String 类执行了替换操作后，返回一个新的对象，源字符串的内容是没有发生改变的。
public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Conversion.handler(s));
    }


}

class Conversion{
    public static String handler(String input){
        String conform = conform(input);
        String[] split;
        BigDecimal number;
        if (suitableUnit(conform)){
            split= conform.split("\\|");
            number= new BigDecimal(split[0]);
            while (number.compareTo(new BigDecimal(1024))>=0){
                BigDecimal divide = number.divide(new BigDecimal(1024));
                BigDecimal bigDecimal = divide.setScale(2, BigDecimal.ROUND_HALF_UP);
                String s = bigDecimal.stripTrailingZeros().toPlainString();
                String  sp = carryOver(split[1]);
                if (!sp.equals(split[1])){
                    number=new BigDecimal(s);
                    split[1]=sp;
                }else {
                    break;
                }

            }
            while (number.compareTo(new BigDecimal(0))>0 &&number.compareTo(new BigDecimal(1))<0)
            {
                BigDecimal divide = number.multiply(new BigDecimal(1024));
                BigDecimal bigDecimal = divide.setScale(2, BigDecimal.ROUND_HALF_UP);
                String s = bigDecimal.stripTrailingZeros().toPlainString();
                String  sp = adbcate(split[1]);
                if (!sp.equals(split[1])){
                    number=new BigDecimal(s);
                    split[1]=sp;
                }
                else {break;}
            }
            return number+split[1];
        }
        else {
            return "";
        }
    }
    private static String conform(String input){
        String temp=input.replace(" ","").toUpperCase();
        String[] split = temp.split("[^0-9]");
        if (split.length==1 && split[0].length()>0){
            String substring = temp.substring(split[0].length());
            String[] split1 = substring.split("[^a-zA-Z]");
            if (split1[0].length()>0 &&split1.length==1){
                return split[0]+"|"+split1[0];
            }
        }

        if (split.length>1 && split[0].length()>0){
             temp=temp.substring(split[0].length());
            if (temp.substring(0,1).equals(".")){
                temp=temp.substring(1);
                String conform = conform(temp);
                return split[0]+"."+conform;
            }

        }
        System.out.println("输入格式有误");
        return "";
    }
    private static boolean suitableUnit(String input) {
        if (input.equals("")){return false;}
        String[] split = input.split("\\|");
        switch (split[1]) {
            case "TB":
            case "MB":
            case "KB":
            case "BYTE":
                return true;
            default:
                System.out.println("无此单位");
                return false;
        }
    }
    private static String carryOver(String input){

        if (input.equals("BYTE")){
            return "KB";
        }
        if (input.equals("KB")){
            return "MB";
        }
        if (input.equals("MB")){
            return "TB";
        }
        System.out.println("已经达到极限了");
        return input;
    }
    private static String adbcate(String input){
        if (input.equals("KB")){
            return "BYTE";
        }
        if (input.equals("MB")){
            return "KB";
        }
        if (input.equals("TB")){
            return "MB";
        }
        System.out.println("已经到极限了");
        return input;
    }

}