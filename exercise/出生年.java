package competition;

import java.io.*;
import java.util.ArrayList;

/**
 * 以上是新浪微博中一奇葩贴：“我出生于1988年，直到25岁才遇到4个数字都不相同的年份。”也就是说，直到2013年才达到“4个数字都不相同”的要求。本题请你根据要求，自动填充“我出生于y年，直到x岁才遇到n个数字都不相同的年份”这句话。
 *
 * 输入格式：
 * 输入在一行中给出出生年份y和目标年份中不同数字的个数n，其中y在[1, 3000]之间，n可以是2、或3、或4。注意不足4位的年份要在前面补零，例如公元1年被认为是0001年，有2个不同的数字0和1。
 *
 * 输出格式：
 * 根据输入，输出x和能达到要求的年份。数字间以1个空格分隔，行首尾不得有多余空格。年份要按4位输出。注意：所谓“n个数字都不相同”是指不同的数字正好是n个。如“2013”被视为满足“4位数字都不同”的条件，但不被视为满足2位或3位数字不同的条件。
 *
 * 输入样例1：
 * 1988 4
 * 输出样例1：
 * 25 2013
 * 输入样例2：
 * 1 2
 * 输出样例2：
 * 0 0001
 */
public class 出生年 {
    //计算年份中数字的个数
    public static int count(int y){
        //存储年份中不同的数字
        ArrayList<Integer> list = new ArrayList<>();
        //不足4位的年份,因为要在前面补0, 所以如果年份中没有0要添加0到list中
        if(y < 1000){
            list.add(0);
        }
        while (y > 0){
            int num = y % 10;
            if(!list.contains(num)){
                list.add(num);
            }
            y /= 10;
        }
        return list.size();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int y = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        //x : 直到x岁,才能遇见n个数字都不同的年份
        int x = 0;
        while (n != count(y)){
            y++;
            x++;
        }

        System.out.printf("%d %04d", x, y);
    }
}
