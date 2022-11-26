package competition;

import java.util.Scanner;

/**
 * 天梯赛每年有大量参赛队员，要保证同一所学校的所有队员都不能相邻，分配座位就成为一件比较麻烦的事情。为此我们制定如下策略：假设某赛场有 N 所学校参赛，第 i 所学校有 M[i] 支队伍，每队 10 位参赛选手。令每校选手排成一列纵队，第 i+1 队的选手排在第 i 队选手之后。从第 1 所学校开始，各校的第 1 位队员顺次入座，然后是各校的第 2 位队员…… 以此类推。如果最后只剩下 1 所学校的队伍还没有分配座位，则需要安排他们的队员隔位就坐。本题就要求你编写程序，自动为各校生成队员的座位号，从 1 开始编号。
 *
 * 输入格式：
 * 输入在一行中给出参赛的高校数 N （不超过100的正整数）；第二行给出 N 个不超过10的正整数，其中第 i 个数对应第 i 所高校的参赛队伍数，数字间以空格分隔。
 *
 * 输出格式：
 * 从第 1 所高校的第 1 支队伍开始，顺次输出队员的座位号。每队占一行，座位号间以 1 个空格分隔，行首尾不得有多余空格。另外，每所高校的第一行按“#X”输出该校的编号X，从 1 开始。
 *
 * 输入样例：
 * 3
 * 3 4 2
 * 输出样例：
 * #1
 * 1 4 7 10 13 16 19 22 25 28
 * 31 34 37 40 43 46 49 52 55 58
 * 61 63 65 67 69 71 73 75 77 79
 * #2
 * 2 5 8 11 14 17 20 23 26 29
 * 32 35 38 41 44 47 50 53 56 59
 * 62 64 66 68 70 72 74 76 78 80
 * 82 84 86 88 90 92 94 96 98 100
 * #3
 * 3 6 9 12 15 18 21 24 27 30
 * 33 36 39 42 45 48 51 54 57 60
 */
public class 天梯赛作为分配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        //记录队伍数最大的数
        int max = 0;
        for (int i = 0; i < m.length; i++) {
            m[i] = sc.nextInt();
            if(m[i]>max){
                max = m[i];
            }
        }
        //存储不同高校的座位号
        int[][] nums = new int[n][max * 10];
        for (int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i] * 10;j++){
                nums[i][j] = 1;
            }
        }
        int number = 0;
        //判断是否有剩下最后一个学校的队伍没有分配
        int flag = 0;
        for(int i = 0; i < max * 10; i++){
            for(int j = 0; j < n; j++){
                if(nums[j][i] == 1 && flag != j){
                    nums[j][i] = number++;
                    //上一个人所在的行
                    flag = j;
                }else if(nums[j][i] == 1 && flag == j){
                    number += 1;
                    nums[j][i] = number++;
                    flag = j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("#%d\n", i + 1);
            for (int j = 0; j < nums[i].length; j++) {
                if(nums[i][j] != 0){
                    System.out.print(nums[i][j]);
                }else{
                    continue;
                }
                if((j + 1) % 10 == 0){
                    System.out.println();
                }else if(j != nums[i].length - 1){
                    System.out.print(" ");
                }else {
                    System.out.println();
                }
            }
        }
    }
}
