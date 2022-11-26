package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　输入一个正整数n，输出n!的值。
 * 　　其中n!=1*2*3*…*n。
 * 算法描述
 * 　　n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
 * 　　将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
 * 　　首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
 * 输入格式
 * 　　输入包含一个正整数n，n<=1000。
 * 输出格式
 * 　　输出n!的准确值。
 */
public class 阶乘计算 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入正整数n
        int n=sc.nextInt();
        //使用一个数组来表示一个大整数，res[0]表示个位，res[1]表示十位，依次类推
        int[] res=new int[10001];
        //首先将个位即res[0]设为1
        res[0]=1;
        //s表示每一位所乘的结果，c表示进位
        int s,c=0;
        for (int i = 1; i <= n; i++) {
            //res[]中的每一个元素都乘以i
            for (int j = 0; j < res.length-1; j++) {
                s=res[j]*i+c;
                res[j]=s%10;
                c=s/10;
            }
        }
        //倒序输出即为结果
        for (int i = res.length-1; i >= 0; i--) {
            if(res[i]!=0){
                for (int j = i; j >= 0; j--) {
                    System.out.print(res[j]);
                }
                break;
            }
        }
    }
}
