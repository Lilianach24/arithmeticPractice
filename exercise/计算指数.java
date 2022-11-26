package competition;

import java.util.Scanner;

/**
 * 真的没骗你，这道才是简单题 —— 对任意给定的不超过 10 的正整数 n，要求你输出 2^n。不难吧？
 *
 * 输入格式：
 * 输入在一行中给出一个不超过 10 的正整数 n。
 *
 * 输出格式：
 * 在一行中按照格式 2^n = 计算结果 输出 2^n的值。
 *
 * 输入样例：
 * 5
 * 输出样例：
 * 2^5 = 32
 */
public class 计算指数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = (int) Math.pow(2, n);
        System.out.printf("2^%d = %d", n, result);
    }
}
