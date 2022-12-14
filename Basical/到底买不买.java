package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
 *
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如在图1中，第3串是小红想做的珠串；那么第1串可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；第2串不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 *
 * figbuy.jpg
 *
 * 图 1
 *
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例分别在 2 行中先后给出摊主的珠串和小红想做的珠串，两串都不超过 1000 个珠子。
 *
 * 输出格式：
 * 如果可以买，则在一行中输出 Yes 以及有多少多余的珠子；如果不可以买，则在一行中输出 No 以及缺了多少珠子。其间以 1 个空格分隔。
 *
 * 输入样例 1：
 * ppRYYGrrYBR2258
 * YrR8RrY
 * 输出样例 1：
 * Yes 8
 * 输入样例 2：
 * ppRYYGrrYB225
 * YrR8RrY
 * 输出样例 2：
 * No 2
 */
public class 到底买不买 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String need = bf.readLine();
        /*//将珠串中所有的珠子都放进链表中
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        //计算珠串中缺少的珠子个数
        int count = 0;
        for (int i = 0; i < need.length(); i++) {
            char c = need.charAt(i);
            int index = list.indexOf(c);
            //珠串中还有该颜色的珠子
            if(index >= 0){
                list.remove(index);
            }else{
                count++;
            }
        }
        //说明珠串中没有缺少珠子
        if(count == 0){
            System.out.println("Yes " + list.size());
        }else{
            System.out.println("No " + count);
        }*/

        //将所有珠子都放进map集合中
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //遍历需要的珠子，没遍历到一个减少一个珠子
        //记录缺少的珠子的个数
        int count = 0;
        for (int i = 0; i < need.length(); i++) {
            char c = need.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            //如果有小于0
            if(map.get(c) < 0){
                count++;
            }
        }
        //说明没有缺少珠子
        if(count == 0){
            System.out.println("Yes " + (str.length() - need.length()));
        }else{
            System.out.println("No " + count);
        }
    }
}
