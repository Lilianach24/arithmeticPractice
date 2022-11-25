package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 若想评比出一种“最好吃”的月饼，那势必在吃货界引发一场腥风血雨…… 在这里我们用数字说话，给出全国各地各种月饼的销量，要求你从中找出销量冠军，认定为最好吃的月饼。
 *
 * 输入格式：
 * 输入首先给出两个正整数 N（≤1000）和 M（≤100），分别为月饼的种类数（于是默认月饼种类从 1 到 N 编号）和参与统计的城市数量。
 *
 * 接下来 M 行，每行给出 N 个非负整数（均不超过 1 百万），其中第 i 个整数为第 i 种月饼的销量（块）。数字间以空格分隔。
 *
 * 输出格式：
 * 在第一行中输出最大销量，第二行输出销量最大的月饼的种类编号。如果冠军不唯一，则按编号递增顺序输出并列冠军。数字间以 1 个空格分隔，行首尾不得有多余空格。
 *
 * 输入样例：
 * 5 3
 * 1001 992 0 233 6
 * 8 0 2018 0 2008
 * 36 18 0 1024 4
 * 输出样例：
 * 2018
 * 3 5
 */
public class 最好吃的月饼 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bf.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int[] sales = new int[n];
        //计算每一种月饼的销售总和
        for (int i = 0; i < m; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                sales[j] += Integer.parseInt(line[j]);
            }
        }
        //找出最大销量
        int[] tmp = Arrays.copyOfRange(sales, 0, n);
        Arrays.sort(tmp);
        int max = tmp[n - 1];
        System.out.println(max);
        //找出最大销量的月饼的种类编号
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(sales[i] == max){
                if(count == 0){
                    System.out.print(i + 1);
                }else {
                    System.out.println(" " + (i + 1));
                }
                count++;
            }
        }
    }
}
