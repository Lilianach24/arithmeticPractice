package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本题要求实现一种数字加密方法。首先固定一个加密用正整数 A，对任一正整数 B，将其每 1 位数字与 A 的对应位置上的数字进行以下运算：对奇数位，对应位的数字相加后对 13 取余——这里用 J 代表 10、Q 代表 11、K 代表 12；对偶数位，用 B 的数字减去 A 的数字，若结果为负数，则再加 10。这里令个位为第 1 位。
 *
 * 输入格式：
 * 输入在一行中依次给出 A 和 B，均为不超过 100 位的正整数，其间以空格分隔。
 *
 * 输出格式：
 * 在一行中输出加密后的结果。
 *
 * 输入样例：
 * 1234567 368782971
 * 输出样例：
 * 3695Q8118
 */
public class 数字加密 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] num = bf.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        a.append(num[0]).reverse();
        b.append(num[1]).reverse();
        int len = Math.max(a.length(), b.length());
        //进行加密
        for (int i = 0; i < len; i++) {
            //如果两个数字的长度不相等, 则在较短的数字前面添加0
            if(i >= a.length()){
                a.append(0);
            }
            if(i >= b.length()){
                b.append(0);
            }
            int digit;
            //对奇数位，对应位的数字相加后对 13 取余——这里用 J 代表 10、Q 代表 11、K 代表 12；
            if(i % 2 == 0){
                digit = (a.charAt(i) - '0') + (b.charAt(i) - '0');
                if(digit % 13 < 10){
                    sb.append(digit % 13);
                }else if( digit % 13 == 10){
                    sb.append("J");
                }else if(digit % 13 == 11){
                    sb.append("Q");
                }else {
                    sb.append("K");
                }
            }
            //对偶数位，用 B 的数字减去 A 的数字，若结果为负数，则再加 10
            else{
                digit = (b.charAt(i) - '0') - (a.charAt(i) - '0');
                if(digit < 0){
                    sb.append(10 + digit);
                }else{
                    sb.append(digit);
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
