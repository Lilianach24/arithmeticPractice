package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本题要求读入 N 名学生的成绩，将获得某一给定分数的学生人数输出。
 *
 * 输入格式：
 * 输入在第 1 行给出不超过 10
 * 5
 *   的正整数 N，即学生总人数。随后一行给出 N 名学生的百分制整数成绩，中间以空格分隔。最后一行给出要查询的分数个数 K（不超过 N 的正整数），随后是 K 个分数，中间以空格分隔。
 *
 * 输出格式：
 * 在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。
 *
 * 输入样例：
 * 10
 * 60 75 90 55 75 99 82 90 75 50
 * 3 75 90 88
 * 输出样例：
 * 3 2 0
 */
public class 统计同成绩的学生 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //将不同分数的人数存放在一个数组中
        int[] count = new int[101];
        String[] line = bf.readLine().split(" ");
        for (String s : line) {
            int score = Integer.parseInt(s);
            count[score]++;
        }
        String[] data = bf.readLine().split(" ");
        int k = Integer.parseInt(data[0]);
        for (int i = 1; i <= k; i++) {
            System.out.print(count[Integer.parseInt(data[i])]);
            if(i != k){
                System.out.print(" ");
            }
        }
    }
}
