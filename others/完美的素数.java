package test;

import java.util.Scanner;

/**
 * 素数又称质数。指一个大于1的自然数，除了1和此整数自身外，不能被其他自然数整除的数。我们定义：如果一个素数是完美的素数，当且仅当它的
 * 每一位数字之和也是一个素数。现在给你一个正整数，你需要写个程序判断一下这个数按照上面的定义是不是一个完美的素数。
 *
 * 输入格式:
 * 输入包含多组测试数据。 每组测试数据只包含一个正整数 n (1 < n <= 10^6)。
 *
 * 输出格式:
 * 对于每组测试数据，如果 n 是完美的素数，输出“YES”，否则输出“NO”(输出均不含引号)。
 */
public class 完美的素数 {
    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            //输入数字x
            int x=sc.nextInt();
            //计录每一位数字之和
            int sum=0;
            //首先判断是否为素数
            if(isPrime(x)){
                //然后判断它的每一位数字之和是否也为素数
                while (x>0){
                    sum+=x%10;
                    x/=10;
                }
                if(isPrime(sum)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else {
                System.out.println("NO");
            }
        }
    }
}
