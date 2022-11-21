package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 设一个数 A 的最低 D 位形成的数是 ad。如果把 ad
 * ​
 *   截下来移到 A 的最高位前面，就形成了一个新的数 B。B 是 A 的多少倍？例如将 12345 的最低 2 位 45 截下来放到 123 的前面，就得到 45123，它约是 12345 的 3.66 倍。
 *
 * 输入格式：
 * 输入在一行中给出一个正整数 A（≤10
 * 9
 *  ）和要截取的位数 D。题目保证 D 不超过 A 的总位数。
 *
 * 输出格式：
 * 计算 B 是 A 的多少倍，输出小数点后 2 位。
 *
 * 输入样例 1：
 * 12345 2
 * 输出样例 1：
 * 3.66
 * 输入样例 2：
 * 12345 5
 * 输出样例 2：
 * 1.00
 */
public class B是A的多少倍 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bf.readLine().split(" ");
        int d = Integer.parseInt(data[1]);
        float a = Float.parseFloat(data[0]);
        float b = Float.parseFloat(data[0].substring(data[0].length() - d).concat(data[0].substring(0, data[0].length() - d)));
        System.out.printf("%.2f", b / a);
    }
}
