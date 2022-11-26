package competition;

import java.io.*;

/**
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 *
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 输入格式:
 * 输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。
 *
 * 输出格式:
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 *
 * 输入样例:
 * 19 *
 * 输出样例:
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 2
 */
public class 打印沙漏 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //输入数据
        String[] line = bf.readLine().split(" ");
        //获得正整数n
        int n = Integer.parseInt(line[0]);
        //计算漏斗的一半有几行
        int row = (int)(Math.sqrt((int)((n + 1) / 2)));
        //打印漏斗
        for(int i = row;i > 0;i--){
            for(int k = 0; k < row - i; k++){
                System.out.print(" ");
            }
            for(int j = 2 * i - 1; j > 0;j--){
                System.out.print(line[1]);
            }
            System.out.println();
        }
        for(int i = 2;i <= row;i++){
            for(int k = row - i; k > 0; k--){
                System.out.print(" ");
            }
            for(int j = 2 * i - 1; j > 0;j--){
                System.out.print(line[1]);
            }
            System.out.println();
        }
        //输出剩余的符号数
        System.out.println(n - (2 * row * row - 1));
    }
}
