package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个长度不超过 10
 * 4
 *   的、仅由英文字母构成的字符串。请将字符重新调整顺序，按 StringString.... （注意区分大小写）这样的顺序输出，并忽略其它字符。当然，六种字符的个数不一定是一样多的，若某种字符已经输出完，则余下的字符仍按 String 的顺序打印，直到所有字符都被输出。例如 gnirtSSs 要调整成 StringS 输出，其中 s 是多余字符被忽略。
 *
 * 输入格式：
 * 输入在一行中给出一个长度不超过 10^4的、仅由英文字母构成的非空字符串。
 *
 * 输出格式：
 * 在一行中按题目要求输出排序后的字符串。题目保证输出非空。
 *
 * 输入样例：
 * sTRidlinSayBingStrropriiSHSiRiagIgtSSr
 * 输出样例：
 * StringStringSrigSriSiSii
 */
public class String复读机 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        //用一个数组存储String中每个字母出现的次数
        int[] count = new int[6];
        char[] str = {'S', 't', 'r', 'i', 'n', 'g'};
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            for (int j = 0; j < str.length; j++) {
                if(c == str[j]){
                    count[j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        //零数组，用于判断给定的字符串中出现的所有String字母都被加入到sb中
        int[] ling = {0, 0, 0, 0, 0, 0};
        do {
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    sb.append(str[i]);
                    count[i]--;
                }
            }
        } while (!Arrays.equals(count, ling));
        System.out.println(sb.toString());
    }
}
