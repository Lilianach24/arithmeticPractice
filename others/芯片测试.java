package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　有n（2≤n≤20）块芯片，有好有坏，已知好芯片比坏芯片多。
 * 　　每个芯片都能用来测试其他芯片。用好芯片测试其他芯片时，能正确给出被测试芯片是好还是坏。而用坏芯片测试其他芯片时，会随机给出好或
 * 是坏的测试结果（即此结果与被测试芯片实际的好坏无关）。
 * 　　给出所有芯片的测试结果，问哪些芯片是好芯片。
 * 输入格式
 * 　　输入数据第一行为一个整数n，表示芯片个数。
 * 　　第二行到第n+1行为n*n的一张表，每行n个数据。表中的每个数据为0或1，在这n行中的第i行第j列（1≤i, j≤n）的数据表示用第i块芯片测试
 * 第j块芯片时得到的测试结果，1表示好，0表示坏，i=j时一律为1（并不表示该芯片对本身的测试结果。芯片不能对本身进行测试）。
 * 输出格式
 * 　　按从小到大的顺序输出所有好芯片的编号
 */
public class 芯片测试 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //存放芯片测试结果的数组
        int[][] res=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j]=sc.nextInt();
            }
        }
        //存放好芯片的编号
        int[] num=new int[n];
        //因为已知好芯片比坏芯片多,所以某一列测试结果为1的个数大于n/2(除自身外),即为好芯片
        for (int j = 0; j < n; j++) {
            //记录测试结果为1的个数
            int count=0;
            for (int i = 0; i < n; i++) {
                int s=res[i][j];
                if(s==1&&i!=j){
                    count++;
                }
            }
            if(count>=(n/2)){
                num[j]=j+1;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i]!=0){
                System.out.print(num[i]);
                if(i!=num.length-1){
                    System.out.print(" ");
                }
            }
        }
    }
}
