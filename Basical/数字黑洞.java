package basicLevel;

import java.io.*;
import java.util.Arrays;

/**
 * 给定任一个各位数字不完全相同的 4 位正整数，如果我们先把 4 个数字按非递增排序，再按非递减排序，然后用第 1 个数字减第 2 个数字，将得到一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的 6174，这个神奇的数字也叫 Kaprekar 常数。
 *
 * 例如，我们从6767开始，将得到
 *
 * 7766 - 6677 = 1089
 * 9810 - 0189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 * 7641 - 1467 = 6174
 * ... ...
 * 现给定任意 4 位正整数，请编写程序演示到达黑洞的过程。
 *
 * 输入格式：
 * 输入给出一个 (0,10
 * 4
 *  ) 区间内的正整数 N。
 *
 * 输出格式：
 * 如果 N 的 4 位数字全相等，则在一行内输出 N - N = 0000；否则将计算的每一步在一行内输出，直到 6174 作为差出现，输出格式见样例。注意每个数字按 4 位数格式输出。
 *
 * 输入样例 1：
 * 6767
 * 输出样例 1：
 * 7766 - 6677 = 1089
 * 9810 - 0189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 * 输入样例 2：
 * 2222
 * 输出样例 2：
 * 2222 - 2222 = 0000
 */
public class 数字黑洞 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] num1 = bf.readLine().toCharArray();
        //将数字按照递增排列
        Arrays.sort(num1);
        String n1 = toString(num1);
        String n2 = toString(reverse(num1));

        while(true){
            //如果两个数相等
            if(n1.equals(n2)){
                System.out.printf("%s - %s = 0000\n", n2, n1);
                break;
            }
            int b = Integer.parseInt(n1);
            int a = Integer.parseInt(n2);
            int res = a - b;
            System.out.printf("%s - %s = %s\n", n2, n1, toString(String.valueOf(res).toCharArray()));
            //计算所得结果为6174则终止循环
            if(res == 6174){
                break;
            }
            //先把计算所得结果转换成字符数组,然后转换成字符串(为了保留出现在第一个位置的0),最后转换成数字进行计算
            char[] num = String.valueOf(res).toCharArray();
            Arrays.sort(num);
            n1 = toString(num);
            n2 = toString(reverse(num));
        }
    }
    public static char[] reverse(char[] num){
        int i = 0, j = num.length - 1;
        while (i < j){
            char c = num[i];
            num[i++] = num[j];
            num[j--] = c;
        }
        return num;
    }
    public static String toString(char[] num){
        String s = "";
        if(num.length < 4){
            for (int i = 0; i < 4 - num.length; i++) {
                s = s.concat("0");
            }
        }
        for (char c : num) {
            s = s.concat(String.valueOf(c));
        }
        return s;
    }
}
