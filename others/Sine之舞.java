package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
 * 　　不妨设
 * 　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
 * 　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
 * 　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
 * 输入格式
 * 　　仅有一个数：N<201。
 * 输出格式
 * 　　请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
 */
public class Sine之舞 {
    public static String A(int n){
        String s;
        if(n==1){
            return "sin(1)";
        }else {
            //当n>1时,就相当于将"n-1"替换为"(n-1)+sin(n)"或"(n-1)-sin(n)",例如当n=2,就相当于将"1"替换为"1-sin(2)"
            if(n%2==1){
                return A(n-1).replace(""+(n-1),(n-1)+"+sin("+n+")");
            }else {
                return A(n-1).replace(""+(n-1),(n-1)+"-sin("+n+")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder S= new StringBuilder();
        //先添加好(
        for (int i = 1; i < n; i++) {
            S.append("(");
        }
        int j=n;
        for (int i = 1; i <= n; i++) {
            if(i!=n){
                S.append(A(i)).append("+").append(j).append(")");
            }else {
                S.append(A(i)).append("+").append(j);
            }
            j--;
        }
        System.out.println(S);
    }
}
