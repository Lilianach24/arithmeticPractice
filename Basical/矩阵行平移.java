package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个 n×n 的整数矩阵。对任一给定的正整数 k<n，我们将矩阵的奇数行的元素整体向右依次平移 1、……、k、1、……、k、…… 个位置，平移空出的位置用整数 x 补。你需要计算出结果矩阵的每一列元素的和。
 *
 * 输入格式：
 * 输入第一行给出 3 个正整数：n（<100）、k（<n）、x（<100），分别如题面所述。
 *
 * 接下来 n 行，每行给出 n 个不超过 100 的正整数，为矩阵元素的值。数字间以空格分隔。
 *
 * 输出格式：
 * 在一行中输出平移后第 1 到 n 列元素的和。数字间以 1 个空格分隔，行首尾不得有多余空格。
 *
 * 输入样例：
 * 7 2 99
 * 11 87 23 67 20 75 89
 * 37 94 27 91 63 50 11
 * 44 38 50 26 40 26 24
 * 73 85 63 28 62 18 68
 * 15 83 27 97 88 25 43
 * 23 78 98 20 30 81 99
 * 77 36 48 59 25 34 22
 * 输出样例：
 * 529 481 479 263 417 342 343
 * 样例解读
 *
 * 需要平移的是第 1、3、5、7 行。给定 k=2，应该将这三列顺次整体向右平移 1、2、1、2 位（如果有更多行，就应该按照 1、2、1、2、1、2 …… 这个规律顺次向右平移），左端的空位用 99 来填充。平移后的矩阵变成：
 *
 * 99 11 87 23 67 20 75
 * 37 94 27 91 63 50 11
 * 99 99 44 38 50 26 40
 * 73 85 63 28 62 18 68
 * 99 15 83 27 97 88 25
 * 23 78 98 20 30 81 99
 * 99 99 77 36 48 59 25
 */
public class 矩阵行平移 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bf.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);
        int x = Integer.parseInt(data[2]);
        //存储矩阵的数组
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(line[j]);
            }
        }
        //记录该行是第几行奇数行
        int count = 1;
        for (int i = 0; i < n; i++) {
            //如果是奇数行，则需要将改行平移count位
            if(i % 2 == 0){
                for (int j = n - 1; j >= 0; j--) {
                    if(j - count >= 0){
                        nums[i][j] = nums[i][j - count];
                    }else{
                        nums[i][j] = x;
                    }
                }
                count++;
                //如果奇数行到达了k行，则又从1开始数
                if(count > k){
                    count = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            //计算每一列的和
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += nums[j][i];
            }
            System.out.print(sum);
            if(i != n - 1){
                System.out.print(" ");
            }
        }
    }
}
