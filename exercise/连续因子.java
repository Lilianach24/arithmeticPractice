package competition;

import java.io.*;

/**
 * 一个正整数 N 的因子中可能存在若干连续的数字。例如 630 可以分解为 3×5×6×7，其中 5、6、7 就是 3 个连续的数字。给定任一正整数 N，要求编写程序求出最长连续因子的个数，并输出最小的连续因子序列。
 *
 * 输入格式：
 * 输入在一行中给出一个正整数 N（1<N<2^31）。
 *
 * 输出格式：
 * 首先在第 1 行输出最长连续因子的个数；然后在第 2 行中按 因子1*因子2*……*因子k 的格式输出最小的连续因子序列，其中因子按递增顺序输出，1 不算在内。
 *
 * 输入样例：
 * 630
 * 输出样例：
 * 3
 * 5*6*7
 */
public class 连续因子 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //首先找出最长的连续因子
        //记录最长连续因子的个数
        int count = 0;
        //记录连续因子开始的位置
        int start = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            //计算从i开始,能连续的因子有多少个
            int num = 0;
            int j = i;
            int s = n;
            while (s % j == 0){
                s /= j;
                j++;
                num++;
            }
            //如果计算的连续因子的长度比之前计算的长
            if(num > count){
                start = i;
                count = num;
            }
        }
        if(count != 0){
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                System.out.print(start + i);
                if(i != count - 1){
                    System.out.print("*");
                }
            }
        }
        //如果输入的数字为质数,则最长连续因子就是其本身一个数
        else{
            System.out.println(1);
            System.out.println(n);
        }
    }
}
