package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或
 * 同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
 * 输入格式
 * 　　输入的第一行为一个整数n，表示棋盘的大小。
 * 　　接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
 * 输出格式
 * 　　输出一个整数，表示总共有多少种放法。
 */
public class 皇后问题 {
    //表示有n个黑皇后和白皇后
    static int n;
    //表示棋盘
    static int[][] map=new int[10][10];
    //表示棋盘放置白皇后的位置
    static int[] posw=new int[10];
    //表示棋盘放置黑皇后的位置
    static int[] posb=new int[10];
    //表示可行的放法的种数
    static int count;
    //约束函数:判断第t个皇后是否能放置在第i的位置
    //判断白皇后
    public static boolean place_w(int t){
        //判断第t个皇后是否与前t-1个皇后的位置发生冲突
        for (int i = 1; i < t; i++) {
            if(posw[i]==posw[t]||Math.abs(t-i)==Math.abs(posw[t]-posw[i])){
                return false;
            }
        }
        return true;
    }
    //判断黑皇后
    public static boolean place_b(int t){
        for (int i = 1; i < t; i++) {
            if(posb[i]==posb[t]||Math.abs(t-i)==Math.abs(posb[t]-posb[i])){
                return false;
            }
        }
        return true;
    }
    //按条件搜索求解
    //搜索白皇后
    public static void backTrack_w(int t){
        if(t>n){
            //白皇后搜索完,继续搜索黑皇后
            backTrack_b(1);
        }
        else {
            //分别判断n个分支
            for (int i = 1; i <= n; i++) {
                //判断该位置是否能放置皇后
                if(map[t][i]==0){
                    continue;
                }
                //在该位置上放置白皇后
                posw[t]=i;
                //判断能否放置白皇后
                if(place_w(t)){
                    backTrack_w(t+1);
                }
            }
        }
    }
    //搜索黑皇后
    public static void backTrack_b(int t){
        if(t>n){
            //黑皇后也搜索完成,放置种数加一
            count++;
        }else {
            for (int i = 1; i <= n; i++) {
                if(map[t][i]==0){
                    continue;
                }
                //判断该位置是否已经放置白皇后
                if(posw[t]==i){
                    continue;
                }
                posb[t]=i;
                if(place_b(t)){
                    backTrack_b(t+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入棋盘大小
        n=sc.nextInt();
        //输入棋盘
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        count=0;
        //先放置白皇后
        backTrack_w(1);
        System.out.println(count);
    }
}
