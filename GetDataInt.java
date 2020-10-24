package com.example.reidsspringboot;

/**<p>获取输入日期到今年有多少天(只能使用int)<br>
 * 作者:mcfeng</p>
 * @author <a href="https://blog.csdn.net/qq_41592652">mcfeng</a>
 * @version 1.0
 */
public class GetDataInt {
    /**
    *  <p>
     *  获取输入日期到今年有多少天
    *  </p>
    * @param  year 年
    * @param  month 月份
    * @param  date 天数
    * @return int类型
     *
    */
    public static int getData(int year, int month, int date) {
        if (verifyData(year, month, date) == 0) {
            int temp = month;
            if (temp == 1) {
                return date;
            }
            int count = 0;
            while (temp > 1) {
                temp--;
                count += fullData(year, temp);
            }
            return count + date;
        }
        return verifyData(year, month, date);
    }

    /**
   * <p>判断日期是否合理 合理返回0 不合理返回小于0的数</p>
     * @param  year 年
     * @param  month 月份
     * @param  date 天数
   * @return int类型
   */
    private static int verifyData(int year, int month, int date) {
        if (year <= 0 || month < 0 || month > 12) {
            return -4;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (date <= 31 && date > 0) {
                    return 0;
                }
                return -1;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    if (date <= 29 && date > 0) {
                        return 0;
                    }
                    return -2;
                } else {
                    if (date <= 28 && date > 0) {
                        return 0;
                    }
                    return -2;
                }
            default:
                if (date <= 30 && date > 0) {
                    return 0;
                }
                return -3;
        }
    }

    /**
      * 计算今年到这个月的天数
      * @param year 年
     * @param month 月
      * @return int
      */
    private static int fullData(int year, int month) {
        int datecount = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                datecount = 31;
                break;
            case 2:
                datecount += (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
                break;
            default:
                datecount += 30;
                break;
        }
        return datecount;
    }
}
