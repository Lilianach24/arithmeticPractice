package competition;

import java.io.*;

/**
 * 给定一个长度不超过10000的、仅由英文字母构成的字符串。请将字符重新调整顺序，按GPLTGPLT....这样的顺序输出，并忽略其它字符。当然，四种字符（不区分大小写）的个数不一定是一样多的，若某种字符已经输出完，则余下的字符仍按GPLT的顺序打印，直到所有字符都被输出。
 *
 * 输入格式：
 * 输入在一行中给出一个长度不超过10000的、仅由英文字母构成的非空字符串。
 *
 * 输出格式：
 * 在一行中按题目要求输出排序后的字符串。题目保证输出非空。
 *
 * 输入样例：
 * pcTclnGloRgLrtLhgljkLhGFauPewSKgt
 * 输出样例：
 * GPLTGPLTGLTGLGLL
 */
public class 输出GPLT {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().toUpperCase();
        //定义一个计数器,分别计算GPLT的个数
        int[] count = new int[4];
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'G'){
                count[0]++;
            } else if(str.charAt(i) == 'P'){
                count[1]++;
            } else if(str.charAt(i) == 'L'){
                count[2]++;
            } else if(str.charAt(i) == 'T'){
                count[3]++;
            }
        }
        //找出四个字母中个数最多的字母
        int max = Math.max(Math.max(count[0], count[1]), Math.max(count[2], count[3]));
        for (int i = 0; i < max; i++) {
            if(count[0]-- > 0){
                System.out.print("G");
            }
            if(count[1]-- > 0){
                System.out.print("P");
            }
            if(count[2]-- > 0){
                System.out.print("L");
            }
            if(count[3]-- > 0){
                System.out.print("T");
            }
        }
    }
}
