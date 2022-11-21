package com.company.basical;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 所谓缘分数是指这样一对正整数 a 和 b，其中 a 和它的小弟 a−1 的立方差正好是另一个整数 c 的平方，而 c 正好是 b 和它的小弟 b−1 的平方和。
 * 例如 8^3 −7^3=169=13^2 ，而 13=3^2 +2^2，于是 8 和 3 就是一对缘分数。
 *
 * 给定 a 所在的区间 [m,n]，是否存在缘分数？
 *
 * 输入格式：
 * 输入给出区间的两个端点 0<m<n≤25000，其间以空格分隔。
 *
 * 输出格式：
 * 按照 a 从小到大的顺序，每行输出一对缘分数，数字间以空格分隔。如果无解，则输出 No Solution。
 *
 * 输入样例 1：
 * 8 200
 * 输出样例 1：
 * 8 3
 * 105 10
 * 输入样例 2：
 * 9 100
 * 输出样例 2：
 * No Solution
 */
public class 缘分数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bf.readLine().split(" ");
        int m = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);
        //计算给出的范围是否有解
        int count = 0;
        for (int i = m; i <= n; i++) {
            double res = i*i*i-(i-1)*(i-1)*(i-1);
            //加入该i存在对应的缘分数，则求出其对应的缘分数
            int j = (int) ((1 + Math.sqrt(2.0 * Math.sqrt(res) - 1)) / 2);
            //判断求出的缘份数是否为整数, 如果是整数则j为i的缘分数
            //最后一个测试点：1 1 题目要求是a和b为不同的数
            if(res == Math.pow(j*j + (j-1)*(j-1), 2) && i != j){
                System.out.println(i + " " + j);
                count++;
            }
        }
        if(count == 0){
            System.out.println("No Solution");
        }
    }
}
