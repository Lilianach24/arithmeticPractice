package competition;

/**
 * 每个 PAT 考生在参加考试时都会被分配两个座位号，一个是试机座位，一个是考试座位。正常情况下，考生在入场时先得到试机座位号码，入座进入
 * 试机状态后，系统会显示该考生的考试座位号码，考试时考生需要换到考试座位就座。但有些考生迟到了，试机已经结束，他们只能拿着领到的试机座
 * 位号码求助于你，从后台查出他们的考试座位号码。
 *
 * 输入格式：
 * 输入第一行给出一个正整数 N（≤1000），随后 N 行，每行给出一个考生的信息：准考证号 试机座位号 考试座位号。其中准考证号由 16 位数字组
 * 成，座位从 1 到 N 编号。输入保证每个人的准考证号都不同，并且任何时候都不会把两个人分配到同一个座位上。
 *
 * 考生信息之后，给出一个正整数 M（≤N），随后一行中给出 M 个待查询的试机座位号码，以空格分隔。
 *
 * 输出格式：
 * 对应每个需要查询的试机座位号码，在一行中输出对应考生的准考证号和考试座位号码，中间用 1 个空格分隔。
 *
 * 输入样例：
 * 4
 * 3310120150912233 2 4
 * 3310120150912119 4 1
 * 3310120150912126 1 3
 * 3310120150912002 3 2
 * 2
 * 3 4
 * 输出样例：
 * 3310120150912002 2
 * 3310120150912119 1
 */

import java.io.*;

public class 考试座位号 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //存放考生的准考证号和考试座位号
        String[] students = new String[n];
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            //插入数据
            String s = line[0].concat(" ").concat(line[2]);
            students[Integer.parseInt(line[1]) - 1] = s;
        }
        //输入待查询的试机座位号码
        int m = Integer.parseInt(bf.readLine());
        String[] cmpIds = bf.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int cmpId = Integer.parseInt(cmpIds[i]);
            //根据考生的试机座位号码直接获取考生信息
            System.out.println(students[cmpId - 1]);
        }
    }
}
