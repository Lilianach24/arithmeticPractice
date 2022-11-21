package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入格式：
 * 输入首先给出 26 个英文大写字母 A-Z，每个字母用一个 7×5 的、由 C 和 . 组成的矩阵构成。最后在一行中给出一个句子，以回车结束。句子是由若干个单词（每个包含不超过 10 个连续的大写英文字母）组成的，单词间以任何非大写英文字母分隔。
 *
 * 题目保证至少给出一个单词。
 *
 * 输出格式：
 * 对每个单词，将其每个字母用矩阵形式在一行中输出，字母间有一列空格分隔。单词的首尾不得有多余空格。
 *
 * 相邻的两个单词间必须有一空行分隔。输出的首尾不得有多余空行。
 *
 * 输入样例：
 * ..C..
 * .C.C.
 * C...C
 * CCCCC
 * C...C
 * C...C
 * C...C
 * CCCC.
 * C...C
 * C...C
 * CCCC.
 * C...C
 * C...C
 * CCCC.
 * .CCC.
 * C...C
 * C....
 * C....
 * C....
 * C...C
 * .CCC.
 * CCCC.
 * C...C
 * C...C
 * C...C
 * C...C
 * C...C
 * CCCC.
 * CCCCC
 * C....
 * C....
 * CCCC.
 * C....
 * C....
 * CCCCC
 * CCCCC
 * C....
 * C....
 * CCCC.
 * C....
 * C....
 * C....
 * CCCC.
 * C...C
 * C....
 * C.CCC
 * C...C
 * C...C
 * CCCC.
 * C...C
 * C...C
 * C...C
 * CCCCC
 * C...C
 * C...C
 * C...C
 * CCCCC
 * ..C..
 * ..C..
 * ..C..
 * ..C..
 * ..C..
 * CCCCC
 * CCCCC
 * ....C
 * ....C
 * ....C
 * ....C
 * C...C
 * .CCC.
 * C...C
 * C..C.
 * C.C..
 * CC...
 * C.C..
 * C..C.
 * C...C
 * C....
 * C....
 * C....
 * C....
 * C....
 * C....
 * CCCCC
 * C...C
 * C...C
 * CC.CC
 * C.C.C
 * C...C
 * C...C
 * C...C
 * C...C
 * C...C
 * CC..C
 * C.C.C
 * C..CC
 * C...C
 * C...C
 * .CCC.
 * C...C
 * C...C
 * C...C
 * C...C
 * C...C
 * .CCC.
 * CCCC.
 * C...C
 * C...C
 * CCCC.
 * C....
 * C....
 * C....
 * .CCC.
 * C...C
 * C...C
 * C...C
 * C.C.C
 * C..CC
 * .CCC.
 * CCCC.
 * C...C
 * CCCC.
 * CC...
 * C.C..
 * C..C.
 * C...C
 * .CCC.
 * C...C
 * C....
 * .CCC.
 * ....C
 * C...C
 * .CCC.
 * CCCCC
 * ..C..
 * ..C..
 * ..C..
 * ..C..
 * ..C..
 * ..C..
 * C...C
 * C...C
 * C...C
 * C...C
 * C...C
 * C...C
 * .CCC.
 * C...C
 * C...C
 * C...C
 * C...C
 * C...C
 * .C.C.
 * ..C..
 * C...C
 * C...C
 * C...C
 * C.C.C
 * CC.CC
 * C...C
 * C...C
 * C...C
 * C...C
 * .C.C.
 * ..C..
 * .C.C.
 * C...C
 * C...C
 * C...C
 * C...C
 * .C.C.
 * ..C..
 * ..C..
 * ..C..
 * ..C..
 * CCCCC
 * ....C
 * ...C.
 * ..C..
 * .C...
 * C....
 * CCCCC
 * HELLO~WORLD!
 * 输出样例：
 * C...C CCCCC C.... C.... .CCC.
 * C...C C.... C.... C.... C...C
 * C...C C.... C.... C.... C...C
 * CCCCC CCCC. C.... C.... C...C
 * C...C C.... C.... C.... C...C
 * C...C C.... C.... C.... C...C
 * C...C CCCCC CCCCC CCCCC .CCC.
 *
 * C...C .CCC. CCCC. C.... CCCC.
 * C...C C...C C...C C.... C...C
 * C...C C...C CCCC. C.... C...C
 * C.C.C C...C CC... C.... C...C
 * CC.CC C...C C.C.. C.... C...C
 * C...C C...C C..C. C.... C...C
 * C...C .CCC. C...C CCCCC CCCC.
 */
public class 擅长C {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //将表示26个字母的字符数组放在一个数组中
        String[][] letter = new String[26][7];
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                letter[i][j] = bf.readLine();
            }
        }
        String str = bf.readLine();
        //将句子前面的非大写字母去掉 (正则表达式匹配去不掉前面的空格，所以我们需要手动去掉）=》测试点1
        String sentence = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                sentence = str.substring(i);
                break;
            }
        }
        //将句子分割成单词
        //测试点1，2，单词之间可能有多个非大写英文字母，所以这里通配符 ’+‘ 表示匹配一次或多次
        String[] words = sentence.split("[^A-Z]+");
        for (int i = 0; i < words.length; i++) {
            //将每一个单词中的字母按照对应的位置一行一行的拼接在一起之后输出
            for (int k = 0; k < 7; k++) {
                StringBuilder line = new StringBuilder();
                for (int l = 0; l < words[i].length(); l++) {
                    int index = words[i].charAt(l) - 'A';
                    line.append(letter[index][k]);
                    if(l != words[i].length() - 1){
                        line.append(" ");
                    }
                }
                System.out.println(line.toString());
            }
            if(i != words.length - 1){
                System.out.println();
            }
        }
    }
}
