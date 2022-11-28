package com.company.basical;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 给定一个正数数列，我们可以从中截取任意的连续的几个数，称为片段。例如，给定数列 { 0.1, 0.2, 0.3, 0.4 }，我们有 (0.1) (0.1, 0.2) (0.1, 0.2, 0.3) (0.1, 0.2, 0.3, 0.4) (0.2) (0.2, 0.3) (0.2, 0.3, 0.4) (0.3) (0.3, 0.4) (0.4) 这 10 个片段。
 *
 * 给定正整数数列，求出全部片段包含的所有的数之和。如本例中 10 个片段总和是 0.1 + 0.3 + 0.6 + 1.0 + 0.2 + 0.5 + 0.9 + 0.3 + 0.7 + 0.4 = 5.0。
 *
 * 输入格式：
 * 输入第一行给出一个不超过 10
 * 5
 *   的正整数 N，表示数列中数的个数，第二行给出 N 个不超过 1.0 的正数，是数列中的数，其间以一个空格分隔。
 *
 * 输出格式：
 * 在一行中输出该序列所有片段包含的数之和，精确到小数点后 2 位。
 *
 * 输入样例：
 * 4
 * 0.1 0.2 0.3 0.4
 * 输出样例：
 * 5.00
 */
public class 数列的片段和 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(bf);
        in.nextToken();
//        int n = Integer.parseInt(bf.readLine());
//        String[] data = bf.readLine().split(" ");
        /*//计算所有片段之和
        float res = 0;
        for (int i = 0; i < n; i++) {
            //计算每一个片段之和
            float sum = 0;
            for (int j = i; j < n; j++) {
                float num = Float.parseFloat(data[j]);
                sum += num;
                res += sum;
            }
        }
        System.out.printf("%.2f", res);*/

        double n = in.nval;
        //计算所有片段之和
        double res = 0;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            double num = in.nval;
            res += num * 1000 * (n - i) * (i + 1);
        }
        System.out.printf("%.2f", res / 1000);
    }
}
