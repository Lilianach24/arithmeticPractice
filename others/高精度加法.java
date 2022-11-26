package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
 * 算法描述
 * 　　由于a和b都比较大，所以不能直接使用语言中的标准数据类型来存储。对于这种问题，一般使用数组来处理。
 * 　　定义一个数组A，A[0]用于存储a的个位，A[1]用于存储a的十位，依此类推。同样可以用一个数组B来存储b。
 * 　　计算c = a + b的时候，首先将A[0]与B[0]相加，如果有进位产生，则把进位（即和的十位数）存入r，把和的个位数存入C[0]，即C[0]等于
 *     (A[0]+B[0])%10。然后计算A[1]与B[1]相加，这时还应将低位进上来的值r也加起来，即C[1]应该是A[1]、B[1]和r三个数的和．如果又有进位产
 *     生，则仍可将新的进位存入到r中，和的个位存到C[1]中。依此类推，即可求出C的所有位。
 * 　　最后将C输出即可。
 * 输入格式
 * 　　输入包括两行，第一行为一个非负整数a，第二行为一个非负整数b。两个整数都不超过100位，两数的最高位都不是0。
 * 输出格式
 * 　　输出一行，表示a + b的值。
 */
public class 高精度加法 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义一个数组A，A[0]用于存储a的个位，A[1]用于存储a的十位，依此类推
        int[] a=new int[101];
        //定义一个数组b
        int[] b=new int[101];
        String A=sc.next();
        String B=sc.next();
        int na=0,nb=0;
        for (int i = A.length()-1; i >=0; i--) {
            //字符0的ASCII码值是48,所以转换为数字0时需要减去48
            a[na]=A.charAt(i)-48;
            na++;
        }
        for (int i = B.length()-1; i >= 0; i--) {
            b[nb]=B.charAt(i)-48;
            nb++;
        }
        //存储结果的数组
        int[] res=new int[101];
        //s表示每一位的总结果,r表示进位
        int s,r=0;
        for (int i = 0; i < res.length; i++) {
            s=a[i]+b[i]+r;
            res[i]=s%10;
            r=s/10;
        }
        //倒序输出即为结果
        for (int i = res.length-1; i >= 0; i--) {
            if(res[i]!=0){
                for (int j = i; j >= 0; j--) {
                    System.out.print(res[j]);
                }
                break;
            }
        }
    }
}
