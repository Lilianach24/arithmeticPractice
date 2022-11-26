package competition;

import java.io.*;

/**
 * 中国的古人写文字，是从右向左竖向排版的。本题就请你编写程序，把一段文字按古风排版。
 *
 * 输入格式：
 * 输入在第一行给出一个正整数N（<100），是每一列的字符数。第二行给出一个长度不超过1000的非空字符串，以回车结束。
 *
 * 输出格式：
 * 按古风格式排版给定的字符串，每列N个字符（除了最后一列可能不足N个）。
 *
 * 输入样例：
 * 4
 * This is a test case
 * 输出样例：
 * asa T
 * st ih
 * e tsi
 *  ce s
 */
public class 古风排版 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        //将字符串的排版放在一个二维数组里面
        int col = (int) Math.ceil(1.0 * str.length() / n);
        char[][] res = new char[n][col];
        int k = 0;
        for (int j = col - 1; j >= 0; j--) {
            for(int i = 0;i < n; i++){
                if(k < str.length()){
                    //将字符按照古风排版的样式放入数组中
                    res[i][j] = str.charAt(k++);
                }else{
                    //剩余的位置放入空格
                    res[i][j] = ' ';
                }
            }
        }

        //输出古风排版的最终结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
