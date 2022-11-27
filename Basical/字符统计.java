package com.company.basical;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 请编写程序，找出一段给定文字中出现最频繁的那个英文字母。
 *
 * 输入格式：
 * 输入在一行中给出一个长度不超过 1000 的字符串。字符串由 ASCII 码表中任意可见字符及空格组成，至少包含 1 个英文字母，以回车结束（回车不算在内）。
 *
 * 输出格式：
 * 在一行中输出出现频率最高的那个英文字母及其出现次数，其间以空格分隔。如果有并列，则输出按字母序最小的那个字母。统计时不区分大小写，输出小写字母。
 *
 * 输入样例：
 * This is a simple TEST.  There ARE numbers and other symbols 1&2&3...........
 * 输出样例：
 * e 7
 */
public class 字符统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        //统计每个出现的英文字母出现的次数
        int[] cnt = new int[26];
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z'){
                cnt[c - 'a']++;
            }
        }
        //英文字母出现次数及其最多的字母的位置
        int count = 0;
        char index = 0;
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] > count){
                count = cnt[i];
                index = (char)(i + 'a');
            }
        }
        System.out.println(index + " " + count);

    }
}
