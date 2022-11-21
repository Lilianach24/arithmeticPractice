package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 2019 年浙江大学将要庆祝成立 122 周年。为了准备校庆，校友会收集了所有校友的身份证号。现在需要请你编写程序，根据来参加校庆的所有人士的身份证号，统计来了多少校友。
 *
 * 输入格式：
 * 输入在第一行给出不超过 10^5
 *   的正整数 N，随后 N 行，每行给出一位校友的身份证号（18 位由数字和大写字母X组成的字符串）。题目保证身份证号不重复。
 *
 * 随后给出前来参加校庆的所有人士的信息：首先是一个不超过 10^5
 *   的正整数 M，随后 M 行，每行给出一位人士的身份证号。题目保证身份证号不重复。
 *
 * 输出格式：
 * 首先在第一行输出参加校庆的校友的人数。然后在第二行输出最年长的校友的身份证号 —— 注意身份证第 7-14 位给出的是 yyyymmdd 格式的生日。如果没有校友来，则在第二行输出最年长的来宾的身份证号。题目保证这样的校友或来宾必是唯一的。
 *
 * 输入样例：
 * 5
 * 372928196906118710
 * 610481197806202213
 * 440684198612150417
 * 13072819571002001X
 * 150702193604190912
 * 6
 * 530125197901260019
 * 150702193604190912
 * 220221196701020034
 * 610481197806202213
 * 440684198612150417
 * 370205198709275042
 * 输出样例：
 * 3
 * 150702193604190912
 */
public class 校庆 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //存储校友的省份证号
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(bf.readLine());
        }
        int m = Integer.parseInt(bf.readLine());
        //存储来宾的省份证号
        ArrayList<String> visit = new ArrayList<>();
        //存储来宾中校友的身份证号
        ArrayList<String> visitList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String id = bf.readLine();
            visit.add(id);
            if(list.contains(id)){
                visitList.add(id);
            }
        }
        System.out.println(visitList.size());
        //如果来宾中没有校友, 则需要输出来宾中最年长的省份证号
        int index = 0;
        if(visitList.isEmpty()){
            String age = visit.get(0).substring(6, 14);
            for (int i = 1; i < visit.size(); i++) {
                String nextage = visit.get(i).substring(6, 14);
                if(nextage.compareTo(age) < 0){
                    age = nextage;
                    index = i;
                }
            }
            System.out.println(visit.get(index));
        }else{
            String age = visitList.get(0).substring(6, 14);
            for (int i = 0; i < visitList.size(); i++) {
                String nextage = visitList.get(i).substring(6, 14);
                if(nextage.compareTo(age) < 0){
                    age = nextage;
                    index = i;
                }
            }
            System.out.println(visitList.get(index));
        }
    }
}
