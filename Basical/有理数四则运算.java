package com.company.basical;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本题要求编写程序，计算 2 个有理数的和、差、积、商。
 *
 * 输入格式：
 * 输入在一行中按照 a1/b1 a2/b2 的格式给出两个分数形式的有理数，其中分子和分母全是整型范围内的整数，负号只可能出现在分子前，分母不为 0。
 *
 * 输出格式：
 * 分别在 4 行中按照 有理数1 运算符 有理数2 = 结果 的格式顺序输出 2 个有理数的和、差、积、商。注意输出的每个有理数必须是该有理数的最简形式 k a/b，其中 k 是整数部分，a/b 是最简分数部分；若为负数，则须加括号；若除法分母为 0，则输出 Inf。题目保证正确的输出中没有超过整型范围的整数。
 *
 * 输入样例 1：
 * 2/3 -4/2
 * 输出样例 1：
 * 2/3 + (-2) = (-1 1/3)
 * 2/3 - (-2) = 2 2/3
 * 2/3 * (-2) = (-1 1/3)
 * 2/3 / (-2) = (-1/3)
 * 输入样例 2：
 * 5/3 0/6
 * 输出样例 2：
 * 1 2/3 + 0 = 1 2/3
 * 1 2/3 - 0 = 1 2/3
 * 1 2/3 * 0 = 0
 * 1 2/3 / 0 = Inf
 */
public class 有理数四则运算 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bf.readLine().split(" ");
        //将两个数的分子分母分开
        String[] num1 = data[0].split("/");
        String[] num2 = data[1].split("/");
        long a1 = Long.parseLong(num1[0]);
        long b1 = Long.parseLong(num1[1]);
        long a2 = Long.parseLong(num2[0]);
        long b2 = Long.parseLong(num2[1]);
        //首先对题目所给的数据进行化简
        String a = simplify(a1, b1);
        String b = simplify(a2, b2);
        //计算加法
        StringBuilder res = new StringBuilder();
        res.append(a).append(" + ").append(b).append(" = ");
        long lcm = lcm(b1, b2);
        res.append(simplify(a1 * (lcm / b1) + a2 * (lcm / b2), lcm));
        System.out.println(res.toString());
        //计算减法
        res = new StringBuilder();
        res.append(a).append(" - ").append(b).append(" = ");
        res.append(simplify(a1 * (lcm /b1) - a2 * (lcm / b2), lcm));
        System.out.println(res.toString());
        //计算乘法
        res = new StringBuilder();
        res.append(a).append(" * ").append(b).append(" = ");
        res.append(simplify(a1 * a2, b1 * b2));
        System.out.println(res.toString());
        //计算除法
        res = new StringBuilder();
        res.append(a).append(" / ").append(b).append(" = ");
        //除以一个数，等于乘以他的倒数，但是如果第二个数是负数，则需要把负号移到分母上
        if(a2 < 0){
            a1 = -a1;
        }
        res.append(simplify(a1 * b2, b1 * Math.abs(a2)));
        System.out.println(res.toString());
    }
    public static long gcd(long a, long b){
        if(a < b){
            long tmp = a;
            a = b;
            b = tmp;
        }
        return a % b == 0 ? b : gcd(b, a % b);
    }
    public static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
    //求分数的最简形式
    public static String simplify(long a, long b){
        if(b == 0){
            return "Inf";
        }
        if(a == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        //如果是负数，需要添加括号
        boolean flag = false;
        if(a < 0){
            flag = true;
            sb.append("(");
        }
        if(Math.abs(a) >= Math.abs(b)){
            long z = a / b;
            sb.append(z);
            a = Math.abs(a - z * b);
            if(a != 0){
                sb.append(" ");
                if(gcd(a, b) > 1){
                    sb.append(a / gcd(a, b)).append("/").append(b / gcd(a, b));
                }else{
                    sb.append(a).append("/").append(b);
                }
            }
        }else{
            long gcd = gcd(Math.abs(a), b);
            if(gcd > 1){
                sb.append(a / gcd).append("/").append(b / gcd);
            }else{
                sb.append(a).append("/").append(b);
            }
        }
        if(flag){
            sb.append(")");
        }
        return sb.toString();
    }
}
