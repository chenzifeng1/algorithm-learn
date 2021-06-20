package leetcode.match;

/**
 * @ProjectName:
 * @ClassName: Match_5789
 * @Author: czf
 * @Description: 完整对局数
 * @Date: 2021/6/20 10:41
 * @Version: 1.0
 **/

public class Match_5789 {

    public static void main(String[] args) {
        String startTime = "20:00", finishTime = "06:00";
        String startTime1 = "12:01", finishTime1 = "12:44";
        String startTime2 = "00:00", finishTime2 = "23:59";
        String startTime3 = "01:45", finishTime3 = "15:19";
        System.out.println(numberOfRounds(startTime3,finishTime3));
    }


    public static int numberOfRounds(String startTime, String finishTime) {
        int startH = Integer.parseInt(startTime.split(":")[0]);
        int startM = Integer.parseInt(startTime.split(":")[1]);
        int endH = Integer.parseInt(finishTime.split(":")[0]);
        int endM = Integer.parseInt(finishTime.split(":")[1]);

        int result = 0;
        if ((startH * 60 + startM) > (endH * 60 + endM)) {
            // 结束时间小于开始时间
            result = (24 - (startH + 1 - endH)) * 4;
            result += startMinNum(startM);
            result += endMinNum(endM);
            return result;
        }

        result = (endH - (startH + 1)) * 4;
        result += startMinNum(startM);
        result += endMinNum(endM);
        return result;

    }

    private static int endMinNum(int m) {
        if (m >= 45) {
            return 3;
        } else if (m >= 30) {
            return 2;
        } else if (m >= 15) {
            return 1;
        } else {
            return 0;
        }
    }

    static int startMinNum(int m) {
        if (m == 0) {
            return 4;
        } else if (m <= 15) {
            return 3;
        } else if (m <= 30) {
            return 2;
        } else if (m <= 45) {
            return 1;
        } else {
            return 0;
        }

    }
}
