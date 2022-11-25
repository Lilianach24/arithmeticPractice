package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文字会是怎样？
 *
 * 输入格式：
 * 输入在 2 行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过 10^5
 *   个字符的串。可用的字符包括字母 [a-z, A-Z]、数字 0-9、以及下划线 _（代表空格）、,、.、-、+（代表上档键）。题目保证第 2 行输入的文字串非空。
 *
 * 注意：如果上档键坏掉了，那么大写的英文字母无法被打出。
 *
 * 输出格式：
 * 在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。
 *
 * 输入样例：
 * 7+IE.
 * 7_This_is_a_test.
 * 输出样例：
 * _hs_s_a_tst
 */
public class 旧键盘打字 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String should = bf.readLine();
        //存储坏掉的键
        ArrayList<Character> bad = new ArrayList<>();
        //是否存在上档键
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //如果是字母坏键的话，把该字母的大小写都存进bad中
            if(c >= 'A' && c <= 'Z'){
                bad.add(c);
                bad.add((char) (c + 32));
            }else{
                bad.add(c);
            }
            if(str.charAt(i) == '+'){
                flag = true;
            }
        }
        //存储实际输出的字符
        StringBuilder real = new StringBuilder();
        for (int i = 0; i < should.length(); i++) {
            char c = should.charAt(i);
            //首先判断是否是坏键
            if(!bad.contains(c)){
                //如果该键不是坏键，且该键是字母，则需要判断上档键是否坏了
                if(c >= 'A' && c <= 'Z'){
                    if(!flag){
                        real.append(c);
                    }
                }else {
                    real.append(c);
                }
            }
        }
        System.out.println(real.toString());
    }
}
