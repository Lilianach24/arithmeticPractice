package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 A 和 B，本题要求你输出 A+B，即两个字符串的并集。要求先输出 A，再输出 B，但重复的字符必须被剔除。
 *
 * 输入格式：
 * 输入在两行中分别给出 A 和 B，均为长度不超过 10
 * 6
 *  的、由可见 ASCII 字符 (即码值为32~126)和空格组成的、由回车标识结束的非空字符串。
 *
 * 输出格式：
 * 在一行中输出题面要求的 A 和 B 的和。
 *
 * 输入样例：
 * This is a sample test
 * to show you_How it works
 * 输出样例：
 * This ampletowyu_Hrk
 */
public class 字符串Aadd {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine();
        String b = bf.readLine();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(!list.contains(c)){
                list.add(c);
            }
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if(!list.contains(c)){
                list.add(c);
            }
        }
        for (char s : list) {
            System.out.print(s);
        }
    }
}
