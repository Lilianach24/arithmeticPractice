package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
 * 输入格式
 * 　　输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
 * 输出格式
 * 　　输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
 */
public class 回形取数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] arr=new int[m][n];
        //存放结果的数组
        int[] res=new int[m*n];
        //输入矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        int c=0,r=0;
        int x=m-1,y=n-1;
        int k=0;
        while (c<=x&&r<=y){
            //先输出第一列
            for (int i = c; i <= x && y >= r; i++) {
                res[k]=arr[i][r];
                k++;
            }
            r++;
            //然后输出最后一行
            for (int i = r; i <= y && x >= c; i++) {
                res[k]=arr[x][i];
                k++;
            }
            x--;
            //输出左边一列
            for (int i = x; i >= c && y >= r; i--) {
                res[k]=arr[i][y];
                k++;
            }
            y--;
            //输出最上边的一行
            for (int i = y; i >= r && x >= c; i--) {
                res[k]=arr[c][i];
                k++;
            }
            c++;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if(i!=res.length-1){
                System.out.print(" ");
            }
        }
    }
}
