package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 把 2019 各个数位上的数字 2、0、1、9 作为一个数列的前 4 项，用它们去构造一个无穷数列，其中第 n（>4）项是它前 4 项之和的个位数字。例如第 5 项为 2， 因为 2+0+1+9=12，个位数是 2。
 *
 * 本题就请你编写程序，列出这个序列的前 n 项。
 *
 * 输入格式：
 * 输入给出正整数 n（≤1000）。
 *
 * 输出格式：
 * 在一行中输出数列的前 n 项，数字间不要有空格。
 *
 * 输入样例：
 * 10
 * 输出样例：
 * 2019224758
 */
public class 数列2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("2019");
        if(n <= 4){
            System.out.println(sb.toString().substring(0, n));
        }else{
            //前四项的和
            int sum = 12;
            for (int i = 4; i < n; i++) {
                int num = sum % 10;
                sb.append(num);
                sum = sum + num - (sb.toString().charAt(i - 4) - '0');
            }
            System.out.println(sb);
        }
    }
}
