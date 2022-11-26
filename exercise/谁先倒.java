package competition;

import java.util.Scanner;

/**
 * 划拳是古老中国酒文化的一个有趣的组成部分。酒桌上两人划拳的方法为：每人口中喊出一个数字，同时用手比划出一个数字。如果谁比划出的数字正好等于两人喊出的数字之和，谁就输了，输家罚一杯酒。两人同赢或两人同输则继续下一轮，直到唯一的赢家出现。
 *
 * 下面给出甲、乙两人的酒量（最多能喝多少杯不倒）和划拳记录，请你判断两个人谁先倒。
 *
 * 输入格式：
 * 输入第一行先后给出甲、乙两人的酒量（不超过100的非负整数），以空格分隔。下一行给出一个正整数N（≤100），随后N行，每行给出一轮划拳的记录，格式为：
 *
 * 甲喊 甲划 乙喊 乙划
 * 其中喊是喊出的数字，划是划出的数字，均为不超过100的正整数（两只手一起划）。
 *
 * 输出格式：
 * 在第一行中输出先倒下的那个人：A代表甲，B代表乙。第二行中输出没倒的那个人喝了多少杯。题目保证有一个人倒下。注意程序处理到有人倒下就终止，后面的数据不必处理。
 *
 * 输入样例：
 * 1 1
 * 6
 * 8 10 9 12
 * 5 10 5 10
 * 3 8 5 12
 * 12 18 1 13
 * 4 16 12 15
 * 15 1 1 16
 * 输出样例：
 * A
 * 1
 */
public class 谁先倒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入两个人的酒量
        int numA = sc.nextInt();
        int numB = sc.nextInt();
        //输入n
        int n = sc.nextInt();
        //存储划拳记录
        int[] record = new int[4];
        //记录两个人罚酒的次数
        int countA = 0, countB = 0;
        while(n > 0){
            for (int i = 0; i < record.length; i++) {
                record[i] = sc.nextInt();
            }
            //如果两个人同赢或同输,则继续下一轮,否则需要罚酒并检查是否有人倒下
            //甲罚酒
            if(record[1] == record[0] + record[2] && record[1] != record[3]){
                countA++;
                //甲先倒下
                if( countA > numA){
                    System.out.println("A");
                    System.out.println(countB);
                    break;
                }
            }
            //乙罚酒
            if(record[3] == record[0] + record[2] && record[1] != record[3]){
                countB++;
                //乙先倒下
                if(countB > numB){
                    System.out.println("B");
                    System.out.println(countA);
                    break;
                }
            }
            n--;
        }
    }
}
