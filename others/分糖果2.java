package test;

import java.util.Scanner;

public class 分糖果2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入小朋友的数量
        int n=sc.nextInt();
        int[][] candy=new int[n][2];
        //输入每个小朋友手上糖果的数量
        for (int i = 0; i < n; i++) {
            candy[i][0]=sc.nextInt();
        }
        boolean flag=true;
        int sum=0;
        while (flag){
            //每个孩子需要分给下一个孩子糖果的数量
            for (int i = 0; i < n; i++) {
                candy[i][1]=candy[i][0]/2;
            }
            //遍历循环所有小朋友,查看是否每个小朋友手中的糖果数量相等
            for (int i = 0; i < n; i++) {
                if(candy[i][0]!=candy[(i+1+n)%n][0]){
                    break;
                }
                if (i == n - 1 && candy[i][0]==candy[0][0]) {
                    flag = false;
                    System.out.println(sum);
                    break;
                }
            }
            //遍历循环每个小朋友
            for (int i = 0; i < n; i++) {
                int num=candy[i][1]+candy[(i-1+n)%n][1];
                candy[i][0]=num;
                //判断奇偶,如果为奇数个糖果,则需补发一颗
                if(candy[i][0]%2==1){
                    sum++;
                    candy[i][0]++;
                }
            }
        }
    }
}
