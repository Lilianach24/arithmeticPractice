package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 编程团体赛的规则为：每个参赛队由若干队员组成；所有队员独立比赛；参赛队的成绩为所有队员的成绩和；成绩最高的队获胜。
 *
 * 现给定所有队员的比赛成绩，请你编写程序找出冠军队。
 *
 * 输入格式：
 * 输入第一行给出一个正整数 N（≤10
 * 4
 *  ），即所有参赛队员总数。随后 N 行，每行给出一位队员的成绩，格式为：队伍编号-队员编号 成绩，其中队伍编号为 1 到 1000 的正整数，队员编号为 1 到 10 的正整数，成绩为 0 到 100 的整数。
 *
 * 输出格式：
 * 在一行中输出冠军队的编号和总成绩，其间以一个空格分隔。注意：题目保证冠军队是唯一的。
 *
 * 输入样例：
 * 6
 * 3-10 99
 * 11-5 87
 * 102-1 0
 * 102-3 100
 * 11-9 89
 * 3-2 61
 * 输出样例：
 * 11 176
 */
public class 编程团体赛 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        /*//存储每一队的总成绩
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = bf.readLine().split(" ");
            String[] id = data[0].split("[-]");
            map.put(id[0], map.getOrDefault(id[0], 0) + Integer.parseInt(data[1]));
        }
        //找出成绩最高的队伍
        String id = "";
        int score = 0;
        for(String ids : map.keySet()){
            if(map.get(ids) > score){
                score = map.get(ids);
                id = ids;
            }
        }
        System.out.println(id + " " + score);*/

        //下标表示队伍的编号,数组中的值记录队伍的分数
        int[] arr = new int[1001];
        //计算最高的分数和队伍编号
        int max = 0, index = 0;
        for (int i = 0; i < n; i++) {
            String[] data = bf.readLine().split(" ");
            String[] ids = data[0].split("[-]");
            int id = Integer.parseInt(ids[0]);
            arr[id] += Integer.parseInt(data[1]);
            if(arr[id] > max){
                max = arr[id];
                index = id;
            }
        }
        System.out.println(index + " " + max);
    }
}
