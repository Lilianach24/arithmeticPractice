package com.company.basical;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱 P 和他实付的钱 A，你的任务是写一个程序来计算他应该被找的零钱。
 *
 * 输入格式：
 * 输入在 1 行中分别给出 P 和 A，格式为 Galleon.Sickle.Knut，其间用 1 个空格分隔。这里 Galleon 是 [0, 10^7 ] 区间内的整数，Sickle 是 [0, 17) 区间内的整数，Knut 是 [0, 29) 区间内的整数。
 *
 * 输出格式：
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
 *
 * 输入样例 1：
 * 10.16.27 14.1.28
 * 输出样例 1：
 * 3.2.1
 * 输入样例 2：
 * 14.1.28 10.16.27
 * 输出样例 2：
 * -3.2.1
 */
public class 在霍格沃茨找零钱 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String[] data1 = line[0].split("[.]");
        int p = Integer.parseInt(data1[0]) * 17 * 29 + Integer.parseInt(data1[1]) * 29 + Integer.parseInt(data1[2]);
        String[] data2 = line[1].split("[.]");
        int a = Integer.parseInt(data2[0]) * 17 * 29 + Integer.parseInt(data2[1]) * 29 + Integer.parseInt(data2[2]);
        //该找的零钱
        int change = Math.abs(a - p);
        int galleon = change / 17 / 29;
        int sickle = (change - galleon * 17 * 29) / 29;
        int knut = change - galleon * 17 * 29 - sickle * 29;
        if(a - p < 0){
            System.out.println("-" + galleon + "." + sickle + "." + knut);
        }else{
            System.out.println(galleon + "." + sickle + "." + knut);
        }
    }
}
