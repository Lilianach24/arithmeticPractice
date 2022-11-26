package competition;

import java.util.Scanner;

/**
 * 给定两个矩阵A和B，要求你计算它们的乘积矩阵AB。需要注意的是，只有规模匹配的矩阵才可以相乘。即若A有R
 * a
 * ​
 *  行、C
 * a
 * ​
 *  列，B有R
 * b
 * ​
 *  行、C
 * b
 * ​
 *  列，则只有C
 * a
 * ​
 *  与R
 * b
 * ​
 *  相等时，两个矩阵才能相乘。
 *
 * 输入格式：
 * 输入先后给出两个矩阵A和B。对于每个矩阵，首先在一行中给出其行数R和列数C，随后R行，每行给出C个整数，以1个空格分隔，且行首尾没有多余的空格。输入保证两个矩阵的R和C都是正数，并且所有整数的绝对值不超过100。
 *
 * 输出格式：
 * 若输入的两个矩阵的规模是匹配的，则按照输入的格式输出乘积矩阵AB，否则输出Error: Ca != Rb，其中Ca是A的列数，Rb是B的行数。
 *
 * 输入样例1：
 * 2 3
 * 1 2 3
 * 4 5 6
 * 3 4
 * 7 8 9 0
 * -1 -2 -3 -4
 * 5 6 7 8
 * 输出样例1：
 * 2 4
 * 20 22 24 16
 * 53 58 63 28
 * 输入样例2：
 * 3 2
 * 38 26
 * 43 -5
 * 0 17
 * 3 2
 * -11 57
 * 99 68
 * 81 72
 * 输出样例2：
 * Error: 2 != 3
 */
public class 矩阵A乘以B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowA = sc.nextInt();
        int colA = sc.nextInt();
        int[][] a = new int[rowA][colA];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int rowB = sc.nextInt();
        int colB = sc.nextInt();
        int[][] b = new int[rowB][colB];
        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < colB; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        if(colA != rowB){
            System.out.printf("Error: %d != %d", colA, rowB);
        }else{
            int[][] res = new int[rowA][colB];
            System.out.println(rowA + " " + colB);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    int k = 0;
                    while(k < colA){
                        res[i][j] += a[i][k] * b[k][j];
                        k++;
                    }
                    System.out.print(res[i][j]);
                    if(j != res[i].length - 1){
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
