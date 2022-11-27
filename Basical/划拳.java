package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 划拳是古老中国酒文化的一个有趣的组成部分。酒桌上两人划拳的方法为：每人口中喊出一个数字，同时用手比划出一个数字。如果谁比划出的数字正好等于两人喊出的数字之和，谁就赢了，输家罚一杯酒。两人同赢或两人同输则继续下一轮，直到唯一的赢家出现。
 *
 * 下面给出甲、乙两人的划拳记录，请你统计他们最后分别喝了多少杯酒。
 *
 * 输入格式：
 * 输入第一行先给出一个正整数 N（≤100），随后 N 行，每行给出一轮划拳的记录，格式为：
 *
 * 甲喊 甲划 乙喊 乙划
 * 其中喊是喊出的数字，划是划出的数字，均为不超过 100 的正整数（两只手一起划）。
 *
 * 输出格式：
 * 在一行中先后输出甲、乙两人喝酒的杯数，其间以一个空格分隔。
 *
 * 输入样例：
 * 5
 * 8 10 9 12
 * 5 10 5 10
 * 3 8 5 12
 * 12 18 1 13
 * 4 16 12 15
 * 输出样例：
 * 1 2
 */
public class 划拳 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //分别记录甲喝的杯数和乙喝的杯数
        int num1 = 0;
        int num2 = 0;
        while(n > 0) {
            String[] line = bf.readLine().split(" ");
            int sum = Integer.parseInt(line[0]) + Integer.parseInt(line[2]);
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[3]);
            //甲赢,乙罚酒
            if(a == sum && b != sum){
                num2++;
            }else if(b == sum && a != sum){
                num1++;
            }
            n--;
        }
        System.out.println(num1 + " " + num2);
    }
}
