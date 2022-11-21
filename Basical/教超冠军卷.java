package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * “教育超市”是拼题 A 系统的一个衍生产品，发布了各种试卷和练习供用户选购。在试卷列表中，系统不仅列出了每份试卷的单价，还显示了当前的购买人次。本题就请你根据这些信息找出教育超市所有试卷中的销量（即购买人次）冠军和销售额冠军。
 *
 * 输入格式：
 * 输入首先在第一行中给出一个正整数 N（≤10
 * 4
 *  ），随后 N 行，每行给出一份卷子的独特 ID （由小写字母和数字组成的、长度不超过8位的字符串）、单价（为不超过 100 的正整数）和购买人次（为不超过 10
 * 6
 *   的非负整数）。
 *
 * 输出格式：
 * 在第一行中输出销量冠军的 ID 及其销量，第二行中输出销售额冠军的 ID 及其销售额。同行输出间以一个空格分隔。题目保证冠军是唯一的，不存在并列。
 *
 * 输入样例：
 * 4
 * zju007 39 10
 * pku2019 9 332
 * pat2018 95 79
 * qdu106 19 38
 * 输出样例：
 * pku2019 332
 * pat2018 7505
 */

class product{
    //产品id
    String id;
    //单价
    int price;
    //销量
    int sales;
    //销售额
    int sum;
    public product(String id, int price, int sales, int sum){
        this.id = id;
        this.price = price;
        this.sales = sales;
        this.sum = sum;
    }
}
public class 教超冠军卷 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<product> list = new ArrayList<>();
        //将数据放入顺序表中
        for (int i = 0; i < n; i++) {
            String[] datas = bf.readLine().split(" ");
            int price = Integer.parseInt(datas[1]);
            int sales = Integer.parseInt(datas[2]);
            list.add(new product(datas[0], price, sales, price * sales));
        }
        //找出销量最高值和销售总额最大值的下标
        int maxSales = list.get(0).sales, indexSales = 0;
        int maxSum = list.get(0).sum, indexSum = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).sales > maxSales){
                maxSales = list.get(i).sales;
                indexSales = i;
            }
            if(list.get(i).sum > maxSum){
                maxSum = list.get(i).sum;
                indexSum = i;
            }
        }
        System.out.println(list.get(indexSales).id + " " + list.get(indexSales).sales);
        System.out.println(list.get(indexSum).id + " " + list.get(indexSum).sum);
    }
}
