package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个长度不超过 10
 * 4
 *   的、仅由英文字母构成的字符串。请将字符重新调整顺序，按 PATestPATest.... 这样的顺序输出，并忽略其它字符。当然，六种字符的个数不一定是一样多的，若某种字符已经输出完，则余下的字符仍按 PATest 的顺序打印，直到所有字符都被输出。
 *
 * 输入格式：
 * 输入在一行中给出一个长度不超过 10
 * 4
 *   的、仅由英文字母构成的非空字符串。
 *
 * 输出格式：
 * 在一行中按题目要求输出排序后的字符串。题目保证输出非空。
 *
 * 输入样例：
 * redlesPayBestPATTopTeePHPereatitAPPT
 * 输出样例：
 * PATestPATestPTetPTePePee
 */
public class 输出PATest {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        //存储每一个字母出现的次数
        int[] count = new int[6];
        char[] letter = {'P', 'A', 'T', 'e', 's', 't'};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < letter.length; j++) {
                if(c == letter[j]){
                    count[j]++;
                }
            }
        }
        //重新排序并输出
        StringBuilder sb = new StringBuilder();
        int[] tmp = {0, 0, 0, 0, 0, 0};
        while(!Arrays.equals(count, tmp)){
            for (int i = 0; i < count.length; i++) {
                if(count[i] != 0){
                    sb.append(letter[i]);
                    count[i]--;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
