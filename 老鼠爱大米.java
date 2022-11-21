package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 翁恺老师曾经设计过一款 Java 挑战游戏，叫“老鼠爱大米”（或许因为他的外号叫“胖胖鼠”）。每个玩家用 Java 代码控制一只鼠，目标是抢吃尽可能多的大米让自己变成胖胖鼠，最胖的那只就是冠军。
 *
 * 因为游戏时间不能太长，我们把玩家分成 N 组，每组 M 只老鼠同场竞技，然后从 N 个分组冠军中直接选出最胖的冠军胖胖鼠。现在就请你写个程序来得到冠军的体重。
 *
 * 输入格式：
 * 输入在第一行中给出 2 个正整数：N（≤100）为组数，M（≤10）为每组玩家个数。随后 N 行，每行给出一组玩家控制的 M 只老鼠最后的体重，均为不超过 10
 * 4
 *   的非负整数。数字间以空格分隔。
 *
 * 输出格式：
 * 首先在第一行顺次输出各组冠军的体重，数字间以 1 个空格分隔，行首尾不得有多余空格。随后在第二行输出冠军胖胖鼠的体重。
 *
 * 输入样例：
 * 3 5
 * 62 53 88 72 81
 * 12 31 9 0 2
 * 91 42 39 6 48
 * 输出样例：
 * 88 31 91
 * 91
 */
public class 老鼠爱大米 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        //存储每组的冠军
        int[] top = new int[n];
        for(int k = 0; k < n; k++){
            //存放每一组的老鼠的体重
            int[] weight = new int[m];
            String[] data = bf.readLine().split(" ");
            int win = 0;
            for (int i = 0; i < data.length; i++) {
                weight[i] = Integer.parseInt(data[i]);
                if(weight[i] > win){
                    win = weight[i];
                }
            }
            top[k] = win;
        }
        int winner = 0;
        for (int i = 0; i < top.length; i++) {
            if(top[i] > winner){
                winner = top[i];
            }
            System.out.print(top[i]);
            if(i != top.length - 1){
                System.out.print(" ");
            }else {
                System.out.println();
            }
        }
        System.out.println(winner);
    }
}
