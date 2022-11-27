package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 火星人是以 13 进制计数的：
 *
 * 地球人的 0 被火星人称为 tret。
 * 地球人数字 1 到 12 的火星文分别为：jan, feb, mar, apr, may, jun, jly, aug, sep, oct, nov, dec。
 * 火星人将进位以后的 12 个高位数字分别称为：tam, hel, maa, huh, tou, kes, hei, elo, syy, lok, mer, jou。
 * 例如地球人的数字 29 翻译成火星文就是 hel mar；而火星文 elo nov 对应地球数字 115。为了方便交流，请你编写程序实现地球和火星数字之间的互译。
 *
 * 输入格式：
 * 输入第一行给出一个正整数 N（<100），随后 N 行，每行给出一个 [0, 169) 区间内的数字 —— 或者是地球文，或者是火星文。
 *
 * 输出格式：
 * 对应输入的每一行，在一行中输出翻译后的另一种语言的数字。
 *
 * 输入样例：
 * 4
 * 29
 * 5
 * elo nov
 * tam
 * 输出样例：
 * hel mar
 * may
 * 115
 * 13
 */
public class 火星数字 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //地球人数字 0 到 12 的火星文
        String[] number = {"tret", "jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec"};
        //火星人将进位以后的 12 个高位数字
        String[] high = {"tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"};
        //地球数字由数字组成，火星数字由字母组成
        while(n > 0){
            String num = bf.readLine();
            char c = num.charAt(0);
            //地球数字
            if(c >= '0' && c <= '9'){
                int geo = Integer.parseInt(num);
                if(geo < 13){
                    System.out.println(number[geo]);
                }else{
                    //如果转换为火星数字后的个位是零，则不需要翻译
                    if(geo % 13 == 0){
                        System.out.println(high[geo / 13 - 1]);
                    }else{
                        System.out.println(high[geo / 13 - 1] + " " + number[geo % 13]);
                    }
                }
            }
            //火星数字
            else{
                //火星数字的长度是4，则翻译成地球数字是0
                if(num.length() == 4){
                    System.out.println(0);
                }
                //如果火星数字的长度是3，则是地球数字的1-12,或者只有高位存在
                else if(num.length() == 3){
                    for (int i = 0; i < number.length; i++) {
                        if(number[i].equals(num)){
                            System.out.println(i);
                            break;
                        }
                    }
                    for (int i = 0; i < high.length; i++) {
                        if(high[i].equals(num)){
                            System.out.println(13 * (i + 1));
                            break;
                        }
                    }
                }
                //否则就是两位数的火星数字
                else{
                    String[] data = num.split(" ");
                    int res = 0;
                    for (int i = 0; i < high.length; i++) {
                        if(high[i].equals(data[0])){
                            res += 13 * (i + 1);
                            break;
                        }
                    }
                    for (int i = 0; i < number.length; i++) {
                        if(number[i].equals(data[1])){
                            res += i;
                            break;
                        }
                    }
                    System.out.println(res);
                }
            }
            n--;
        }
    }
}
