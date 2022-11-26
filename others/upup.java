package test;

import java.util.Scanner;

/**
 * Bear_2 常常因为长不高而自卑，所以他特别喜欢 upup ，现在他想请你帮他从字符串 S(1<=∣S∣<=10^3) 中找出有多少个 upup 。例如， upupup 中有两个 upup 。
 *
 * 输入格式:
 * 在一行中给出一个仅由小写字母 u,p 构成的字符串 S(1<=∣S∣<=10^3)。
 *
 * 输出格式:
 * 在一行中输出有多少个 upup。
 */
public class upup {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int count=0;
        for (int i = 0; i < str.length()-3; i++) {
            String s=str.substring(i,i+4);
            if("upup".equals(s)){
                count++;
            }
        }
        System.out.println(count);
    }
}
