package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串 APPAPT 中包含了两个单词 PAT，其中第一个 PAT 是第 2 位(P)，第 4 位(A)，第 6 位(T)；第二个 PAT 是第 3 位(P)，第 4 位(A)，第 6 位(T)。
 *
 * 现给定字符串，问一共可以形成多少个 PAT？
 *
 * 输入格式：
 * 输入只有一行，包含一个字符串，长度不超过10
 * 5
 *  ，只包含 P、A、T 三种字母。
 *
 * 输出格式：
 * 在一行中输出给定字符串中包含多少个 PAT。由于结果可能比较大，只输出对 1000000007 取余数的结果。
 *
 * 输入样例：
 * APPAPT
 * 输出样例：
 * 2
 */
public class 有几个PAT {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int MOD = 1000000007;
        //记录对于每一个位置而言，其前面的P有多少个
        int[] nums = new int[str.length()];
        int cntp = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'P'){
                cntp++;
            }
            nums[i] = cntp;
        }
        //记录每一个A后面的T有多少个
        int cntt = 0;
        //计算有多少个PAT
        int sum = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == 'T'){
                cntt++;
            }
            if(str.charAt(i) == 'A'){
                sum = (sum + (nums[i] * cntt) % MOD) % MOD;
            }
        }
        System.out.println(sum);
    }
}
