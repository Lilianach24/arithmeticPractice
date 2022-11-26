package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　FJ在沙盘上写了这样一些字符串：
 * 　　A1 = “A”
 * 　　A2 = “ABA”
 * 　　A3 = “ABACABA”
 * 　　A4 = “ABACABADABACABA”
 * 　　… …
 * 　　你能找出其中的规律并写所有的数列AN吗？
 * 输入格式
 * 　　仅有一个数：N ≤ 26。
 * 输出格式
 * 　　请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
 */
public class FJ的字符串 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] A=new String[26];
        A[0]="A";
        char[] a={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 1; i < n; i++) {
            //表示中间所要加的字母
            String a1=String.valueOf(a[i]);
            A[i]=A[i-1].concat(a1).concat(A[i-1]);
        }
        System.out.println(A[n-1]);
    }
}
