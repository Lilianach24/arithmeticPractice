package basicLevel;

import java.io.*;

/**
 *科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式 [+-][1-9].[0-9]+E[+-][0-9]+，即数字的整数部分只有 1 位，小数部分至少有 1 位，该数字及其指数部分的正负号即使对正数也必定明确给出。
 *
 * 现以科学计数法的格式给出实数 A，请编写程序按普通数字表示法输出 A，并保证所有有效位都被保留。
 *
 * 输入格式：
 * 每个输入包含 1 个测试用例，即一个以科学计数法表示的实数 A。该数字的存储长度不超过 9999 字节，且其指数的绝对值不超过 9999。
 *
 * 输出格式：
 * 对每个测试用例，在一行中按普通数字表示法输出 A，并保证所有有效位都被保留，包括末尾的 0。
 *
 * 输入样例 1：
 * +1.23400E-03
 * 输出样例 1：
 * 0.00123400
 * 输入样例 2：
 * -1.2E+10
 * 输出样例 2：
 * -12000000000
 */
public class 科学计数法 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        //首先求出指数部分是正数还是负数,以及指数的值
        //表示指数为正数
        boolean flag = true;
        String exp = "";
        int ind = 0;
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == 'E'){
                if(num.charAt(i + 1) == '-'){
                    flag = false;
                }
                exp = num.substring(i + 2);
                ind = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        //添加符号
        if(num.charAt(0) == '-'){
            sb.append(num.charAt(0));
        }
        int ex = Integer.parseInt(exp);
        String decimal = num.substring(3,ind);
        //指数是正数
        if(flag){
            //添加整数位
            if(num.charAt(1) != '0'){
                sb.append(num.charAt(1));
            }
            //添加小数位
            if(ex < decimal.length()){
                sb.append(decimal, 0, ex).append('.').append(decimal.substring(ex));
            }else{
                sb.append(decimal);
                for (int i = 0; i < ex - decimal.length(); i++) {
                    sb.append(0);
                }
            }
        }else{
            sb.append("0.");
            for (int i = 0; i < ex - 1; i++) {
                sb.append(0);
            }
            for (int i = 1; i < ind; i++) {
                if(num.charAt(i) == '.'){
                    continue;
                }
                sb.append(num.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
