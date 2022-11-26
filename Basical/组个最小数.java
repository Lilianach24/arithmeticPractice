package basicLevel;

import java.io.*;

/**
 * 给定数字 0-9 各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意 0 不能做首位）。例如：给定两个 0，两个 1，三个 5，一个 8，我们得到的最小的数就是 10015558。
 *
 * 现给定数字，请编写程序输出能够组成的最小的数。
 *
 * 输入格式：
 * 输入在一行中给出 10 个非负整数，顺序表示我们拥有数字 0、数字 1、……数字 9 的个数。整数间用一个空格分隔。10 个数字的总个数不超过 50，且至少拥有 1 个非 0 的数字。
 *
 * 输出格式：
 * 在一行中输出能够组成的最小的数。
 *
 * 输入样例：
 * 2 2 0 0 0 3 0 0 1 0
 * 输出样例：
 * 10015558
 */
public class 组个最小数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = bf.readLine().split(" ");
        int[] num = new int[nums.length];
        //计算数字的个数
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            num[i] = Integer.parseInt(nums[i]);
            sum += num[i];
        }
        //存放各个数字
        int[] number = new int[sum];
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            while(num[i] > 0){
                number[j++] = i;
                num[i]--;
            }
        }
        //遍历存放各个数字的数组,将第一个不为0的数字与第一个0做交换
        for (int i = 0; i < number.length; i++) {
            //如果数组种没有0,则不需要交换
            if(number[i] != 0 && i == 0){
                break;
            }
            if(number[i] != 0){
                int temp = number[i];
                number[i] = number[0];
                number[0] = temp;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int value : number) {
            sb.append(value);
        }
        System.out.println(sb.toString());
    }
}
