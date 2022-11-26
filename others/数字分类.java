package pta;

import java.util.Scanner;

/**
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
 * A1= 能被 5 整除的数字中所有偶数的和；
 * A2= 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1−n2+n3−n4⋯；
 * A3= 被 5 除后余 2 的数字的个数；
 * A4= 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
 * A5= 被 5 除后余 4 的数字中最大数字。
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。数字间以空格分隔。
 *
 * 输出格式：
 * 对给定的 N 个正整数，按题目要求计算 A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出 N。
 */
public class 数字分类 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, sum2 = 0, num5 = 0;
        double sum4 = 0;
        for (int i = 0; i < n; i++) {
            //记录数对5求余的余数
            int b = arr[i] % 5;
            if (b == 0) {
                //A1= 能被 5 整除的数字中所有偶数的和；
                if (arr[i] % 2 == 0) {
                    a1 += arr[i];
                }
            } else if (b == 1) {
                //A2= 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1−n2+n3−n4⋯；
                sum2++;
                if (sum2 % 2 == 1) {
                    a2 += arr[i];
                } else {
                    a2 -= arr[i];
                }
            } else if (b == 2) {
                //A3= 被 5 除后余 2 的数字的个数；
                a3++;
            } else if (b == 3) {
                //A4= 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
                sum4 += arr[i];
                a4++;
            } else {
                //A5= 被 5 除后余 4 的数字中最大数字。
                num5++;
                if (arr[i] > a5) {
                    a5 = arr[i];
                }
            }
        }
        int[] a = {a1, a2, a3};
        for (int value : a) {
            if (value == 0) {
                System.out.print("N ");
            } else {
                System.out.print(value + " ");
            }
        }
        if (a4 == 0) {
            System.out.print("N ");
        } else {
            System.out.printf("%.1f ", sum4 / a4);
        }
        if (num5 == 0) {
            System.out.print("N");
        } else {
            System.out.print(a5);
        }
    }
}
