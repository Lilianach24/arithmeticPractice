package basicLevel;

import java.io.*;
import java.util.HashMap;

/**
 * 输入格式：
 * 输入第 1 行给出正整数 N（≤10^5），即双方交锋的次数。随后 N 行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。
 * C 代表“锤子”、J 代表“剪刀”、B 代表“布”，第 1 个字母代表甲方，第 2 个代表乙方，中间有 1 个空格。
 *
 * 输出格式：
 * 输出第 1、2 行分别给出甲、乙的胜、平、负次数，数字间以 1 个空格分隔。
 * 第 3 行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有 1 个空格。如果解不唯一，则输出按字母序最小的解。
 *
 * 输入样例：
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 * 输出样例：
 * 5 3 2
 * 2 3 5
 * B B
 */
public class 锤子剪刀布2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //只需要记录甲乙分别的胜局,就可以算出甲,乙的胜平负分别是多少,分别记胜平负局是1, 0, -1
        int sum1 = 0, sum2 = 0;
        //第二个就是要记录甲和乙获胜时的手势就是解题的关键, 用一个二维数组存储甲乙两人获胜时的手势,按照BCJ存储
        int[][] point = new int[2][3];
        for (int i = 0; i < n; i++) {
            String[] player = bf.readLine().split(" ");
            //非平局
            if (!player[0].equals(player[1])) {
                if("B".equals(player[0])){
                    //甲赢
                    if("C".equals(player[1])){
                        point[0][0]++;
                    }
                    //乙赢
                    else{
                        point[1][2]++;
                    }
                }else if("C".equals(player[0])){
                    if("J".equals(player[1])){
                        point[0][1]++;
                    }else{
                        point[1][0]++;
                    }
                }else{
                    if("B".equals(player[1])){
                        point[0][2]++;
                    }else{
                        point[1][1]++;
                    }
                }
            }
        }
        //输出甲乙胜平负
        sum1 = point[0][0] + point[0][1] + point[0][2];
        sum2 = point[1][0] + point[1][1] + point[1][2];
        int ping = n - sum1 - sum2;
        System.out.println(sum1 + " " + ping + " " + sum2);
        System.out.println(sum2 + " " + ping + " " + sum1);
        //输出甲乙获胜时出的最多的手势
        System.out.println(result(point[0]) + " " + result(point[1]));
    }
    public static String result(int[] point){
        int flag = 0;
        for (int i = 0; i < point.length; i++) {
            if(point[i] > point[flag]){
                flag = i;
            }
        }
        if(flag == 0){
            return "B";
        }else if(flag == 1){
            return "C";
        }else {
            return "J";
        }
    }
}
