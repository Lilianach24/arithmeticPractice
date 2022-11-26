package basicLevel;

import java.io.*;
import java.util.ArrayList;

/**
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。
 *
 * 输入格式：
 * 输入在 2 行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过 80 个字符的串，由字母 A-Z（包括大、小写）、数字 0-9、以及下划线 _（代表空格）组成。题目保证 2 个字符串均非空。
 *
 * 输出格式：
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有 1 个坏键。
 *
 * 输入样例：
 * 7_This_is_a_test
 * _hs_s_a_es
 * 输出样例：
 * 7TI
 */
public class 旧键盘 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String outo = bf.readLine().toUpperCase();
        String real = bf.readLine().toUpperCase();
        int i, j = 0;
        //存储坏掉的键
        ArrayList<Character> list = new ArrayList<>();
        for (i = 0; i < outo.length() && j < real.length(); i++) {
            char c = outo.charAt(i);
            if(c == real.charAt(j)){
                //如果前面没有输入的键后面输入了, 则这个键盘没有坏,将其移除list
                if(list.contains(c)){
                    list.remove(c);
                }
                j++;
            }else{
                if(!list.contains(c)){
                    list.add(c);
                }
            }
        }
        for (int k = i; i < outo.length(); i++) {
            if(!list.contains(outo.charAt(k))){
                list.add(outo.charAt(k));
            }
        }
        for (char c : list) {
            System.out.print(c);
        }
    }
}
