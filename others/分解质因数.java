package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　求出区间[a,b]中所有整数的质因数分解。
 * 输入格式
 * 　　输入两个整数a，b。
 * 输出格式
 * 　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
 * 样例输入
 * 3 10
 * 样例输出
 * 3=3
 * 4=2*2
 * 5=5
 * 6=2*3
 * 7=7
 * 8=2*2*2
 * 9=3*3
 * 10=2*5
 * 提示
 * 　　先筛出所有素数，然后再分解。
 * 数据规模和约定
 * 　　2<=a<=b<=10000
 */
public class 分解质因数 {
    //存放素数的数组
    static int[] ans=new int[100000];
    //判断是否为素数
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
        int a=sc.nextInt();
        int b=sc.nextInt();
        //创建素数表
        int z=0;
        for (int i = 2; i < ans.length; i++) {
            if(isPrime(i)){
                ans[z]=i;
                z++;
            }
        }
        for (int i = a; i <= b; i++) {
            System.out.printf("%d=",i);
            if(i==1){
                System.out.printf("%d=%d",1,1);
            }else {
                int j=i,k=0;
                //i的质因数肯定是要小于i的
                while (ans[k] <= i) {
                    if(j==ans[k]){
                        System.out.printf("%d",ans[k]);
                        break;
                    }else {
                        //如果ans[j]是i的质因数
                        if(j%ans[k]==0){
                            System.out.printf("%d*",ans[k]);
                            j/=ans[k];
                        }else {
                            k++;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
