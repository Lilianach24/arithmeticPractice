package test;

import java.util.Scanner;

/**
 * 监护室每小时测量一次病人的血压，若收缩压在90 - 140之间并且舒张压在60 - 90之间（包含端点值）则称之为正常，现给出某病人若干次测量的
 * 血压值，计算病人保持正常血压的最长小时数。
 *
 * 输入格式:
 * 第一行为一个正整数n，n < 100 其后有n行，每行2个正整数，分别为一次测量的收缩压和舒张压，中间以一个空格分隔。
 *
 * 输出格式:
 * 输出仅一行，血压连续正常的最长小时数。
 */
public class 正常血压 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入n
        int n=sc.nextInt();
        int[][] blood=new int[n][2];
        for (int i = 0; i < n; i++) {
            blood[i][0]=sc.nextInt();
            blood[i][1]=sc.nextInt();
        }
        //计算正常血压的时长,和最长时长
        int time=0,maxtime=0;
        for (int i = 0; i < n; i++) {
            //如果收缩压正常
            if((blood[i][0]>=90&&blood[i][0]<=140)&&(blood[i][1]>=60&&blood[i][1]<=90)){
                //舒张压正常,时间加1
                time++;
            }
            //否则时间归零
            else {
                if(time>maxtime){
                    maxtime=time;
                }
                time=0;
            }
        }
        if(time>maxtime){
            maxtime=time;
        }
        System.out.println(maxtime);
    }
}
