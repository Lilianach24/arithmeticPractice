package competition;

import java.io.*;

/**
 * 本题的要求很简单，就是求N个数字的和。麻烦的是，这些数字是以有理数分子/分母的形式给出的，你输出的和也必须是有理数的形式。
 *
 * 输入格式：
 * 输入第一行给出一个正整数N（≤100）。随后一行按格式a1/b1 a2/b2 ...给出N个有理数。题目保证所有分子和分母都在长整型范围内。另外，负数的符号一定出现在分子前面。
 *
 * 输出格式：
 * 输出上述数字和的最简形式 —— 即将结果写成整数部分 分数部分，其中分数部分写成分子/分母，要求分子小于分母，且它们没有公因子。如果结果的整数部分为0，则只输出分数部分。
 *
 * 输入样例1：
 * 5
 * 2/5 4/15 1/30 -2/60 8/3
 * 输出样例1：
 * 3 1/3
 * 输入样例2：
 * 2
 * 4/3 2/3
 * 输出样例2：
 * 2
 * 输入样例3：
 * 3
 * 1/3 -1/6 1/8
 * 输出样例3：
 * 7/24
 */
public class 求n个数的和 {
    /**
     * 求最大公因数: (欧几里得算法) 吸纳用两个数中较大的数除以较小的数,如有余数,则用较小的那个数继续除以余数,按照这样的方法一直除下去,
     *              除到余数为0为止, 则最后的除数就是两个数的最大公因数
     * @param a
     * @param b
     * @return 最大公因数
     */
    public static int GCD(int a, int b){
        return a > b ? (a % b == 0 ? b : GCD(b, a % b)) : (b % a == 0 ? a : GCD(a, b % a));
    }

    /**
     * 最小公倍数: 两数的乘积/两数的最大公因数
     * @param x
     * @param y
     * @return 最小公倍数
     */
    public static int LCM(int x, int y){
        return (x * y) / GCD(x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //获取数据
        int n = Integer.parseInt(bf.readLine());
        String[] fraction = bf.readLine().split(" ");
        //将分子和分母分别放在两个数组中
        //分子
        int[] numerator = new int[n];
        //分母
        int[] denominator = new int[n];
        for (int i = 0; i < n; i++) {
            //获得两个数的分子和分母
            String[] nums = fraction[i].split("/");
            numerator[i] = Integer.parseInt(nums[0]);
            denominator[i] = Integer.parseInt(nums[1]);
        }
        //计算
        for (int i = 0; i < n - 1; i++) {
            //求分母的最小公倍数
            int multiple = LCM(denominator[i], denominator[i + 1]);
            //两数分子相加
            int sum = (numerator[i] * (multiple / denominator[i])) + (numerator[i + 1] * (multiple / denominator[i + 1]));
            //如果分子相加等于0,则直接进行下一轮循环
            if(sum == 0){
                numerator[i+1] = 0;
                denominator[i+1] = multiple;
                continue;
            }
            //分子分母进行约分
            //求最大公因数
            int factor = GCD(Math.abs(sum), multiple);
            //将约分后所得的分子分母放在下一位
            numerator[i + 1] = sum / factor;
            denominator[i + 1] = multiple / factor;
        }
        //输出结果  结果为0
        if(numerator[n - 1] != 0){
            //是假分数
            if(Math.abs(numerator[n - 1]) >= denominator[n - 1]){
                //求得整数部分
                int in = numerator[n - 1] / denominator[n - 1];
                //分数部分为0
                if(Math.abs(numerator[n - 1]) % denominator[n - 1] == 0){
                    System.out.println(in);
                }
                //分数部分不为0
                else{
                    System.out.print(in + " ");
                    System.out.println(numerator[n - 1] - denominator[n - 1] * in + "/" + denominator[n - 1]);
                }
            }
            //是真分数
            else{
                System.out.println(numerator[n - 1] + "/" + denominator[n - 1]);
            }
        }else{
            System.out.println(0);
        }
    }
}
