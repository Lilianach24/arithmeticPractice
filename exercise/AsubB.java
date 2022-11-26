package competition;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 本题要求你计算A−B。不过麻烦的是，A和B都是字符串 —— 即从字符串A中把字符串B所包含的字符全删掉，剩下的字符组成的就是字符串A−B。
 *
 * 输入格式：
 * 输入在2行中先后给出字符串A和B。两字符串的长度都不超过10^4
 *  ，并且保证每个字符串都是由可见的ASCII码和空白字符组成，最后以换行符结束。
 *
 * 输出格式：
 * 在一行中打印出A−B的结果字符串。
 *
 * 输入样例：
 * I love GPLT!  It's a fun game!
 * aeiou
 * 输出样例：
 * I lv GPLT!  It's  fn gm!
 */
public class AsubB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //输入A,B两个字符串,并把他们转换为字符数组
        char[] strA = bf.readLine().toCharArray();
        char[] strB = bf.readLine().toCharArray();
        //用于标记A中含有的B中的字符的为止
        int[] flag = new int[256];
        for (char c : strB) {
            flag[c] = 1;
        }
        for (char c : strA){
            if(flag[c] != 1){
                System.out.print(c);
            }
        }
    }
}
