package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 为了用事实说明挖掘机技术到底哪家强，PAT 组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。
 *
 * 输入格式：
 * 输入在第 1 行给出不超过 10
 * 5
 *   的正整数 N，即参赛人数。随后 N 行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号（从 1 开始连续编号）、及其比赛成绩（百分制），中间以空格分隔。
 *
 * 输出格式：
 * 在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。
 *
 * 输入样例：
 * 6
 * 3 65
 * 2 80
 * 1 100
 * 2 70
 * 3 40
 * 3 0
 * 输出样例：
 * 2 150
 */
public class 挖掘机技术哪家强 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
//        //存储各个高校的总分,数组的下标即为高校的编号
//        int[] score = new int[n + 1];
//        //记录总分最大
//        int max = -1;
//        //记录总分最高的学校的编号
//        //测试点2 是总分为0的情况，高校的编号是从1开始的连续编号，所以max要从-1开始，id要从1开始
//        int id = 1;
//        for (int i = 0; i < n; i++) {
//            String[] line = bf.readLine().split(" ");
//            int index = Integer.parseInt(line[0]);
//            int num = Integer.parseInt(line[1]);
//            score[index] += num;
//            if(score[index] > max){
//                max = score[index];
//                id = index;
//            }
//        }
//        System.out.println(id + " " + max);

        HashMap<String, Integer> map = new HashMap<>();
        int max = -1;
        String id = "1";
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            int score = Integer.parseInt(line[1]);
            map.put(line[0], map.getOrDefault(line[0], 0) + score);
            if(map.get(line[0]) > max){
                max = map.get(line[0]);
                id = line[0];
            }
        }
        System.out.println(id + " " + map.get(id));
    }
}
