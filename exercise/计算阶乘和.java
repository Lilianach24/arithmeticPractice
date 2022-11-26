package competition;

import java.util.Scanner;

/**
 * 对于给定的正整数N，需要你计算 S=1!+2!+3!+...+N!。
 *
 * 输入格式：
 * 输入在一行中给出一个不超过10的正整数N。
 *
 * 输出格式：
 * 在一行中输出S的值。
 *
 * 输入样例：
 * 3
 * 输出样例：
 * 9
 */
public class 计算阶乘和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //计算和
        int sum = 0;
        while(n>0){
            //计算阶乘
            int mul = 1;
            for (int i = 1; i <= n; i++) {
                mul *= i;
            }
            sum += mul;
            n--;
        }
        //输出结果
        System.out.println(sum);
    }
}
