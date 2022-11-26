package competition;

import java.util.Scanner;

/**
 * 给定两个整数A和B，输出从A到B的所有整数以及这些数的和。
 *
 * 输入格式：
 * 输入在一行中给出2个整数A和B，其中−100≤A≤B≤100，其间以空格分隔。
 *
 * 输出格式：
 * 首先顺序输出从A到B的所有整数，每5个数字占一行，每个数字占5个字符宽度，向右对齐。最后在一行中按Sum = X的格式输出全部数字的和X。
 *
 * 输入样例：
 * -3 8
 * 输出样例：
 *    -3   -2   -1    0    1
 *     2    3    4    5    6
 *     7    8
 * Sum = 30
 */
public class 求证数段的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入a和b
        int a = sc.nextInt();
        int b = sc.nextInt();
        //计算总和
        int sum = 0;
        //计算数字的个数
        int j = 0;
        for (int i = a; i <= b; i++) {
            System.out.printf("%-5d", i);
            j++;
            sum += i;
            if(j % 5 == 0 ){
                System.out.println();
            }
        }
        //如果数字的个数正好是5的倍数,则输出Sum = sum就不需要换行,否则就需要换行
        if(j % 5 == 0){
            System.out.println("Sum = " + sum);
        }else{
            System.out.println("\nSum = " + sum);
        }
    }
}
