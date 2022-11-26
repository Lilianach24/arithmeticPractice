package competition;

import java.io.*;
import java.util.ArrayList;

/**
 * 以上是朋友圈中一奇葩贴：“2月14情人节了，我决定造福大家。第2个赞和第14个赞的，我介绍你俩认识…………咱三吃饭…你俩请…”。现给出此贴下点赞的朋友名单，请你找出那两位要请客的倒霉蛋。
 *
 * 输入格式：
 * 输入按照点赞的先后顺序给出不知道多少个点赞的人名，每个人名占一行，为不超过10个英文字母的非空单词，以回车结束。一个英文句点.标志输入的结束，这个符号不算在点赞名单里。
 *
 * 输出格式：
 * 根据点赞情况在一行中输出结论：若存在第2个人A和第14个人B，则输出“A and B are inviting you to dinner...”；若只有A没有B，则输出“A is the only one for you...”；若连A都没有，则输出“Momo... No one is for you ...”。
 *
 * 输入样例1：
 * GaoXZh
 * Magi
 * Einst
 * Quark
 * LaoLao
 * FatMouse
 * ZhaShen
 * fantacy
 * latesum
 * SenSen
 * QuanQuan
 * whatever
 * whenever
 * Potaty
 * hahaha
 * .
 * 输出样例1：
 * Magi and Potaty are inviting you to dinner...
 * 输入样例2：
 * LaoLao
 * FatMouse
 * whoever
 * .
 * 输出样例2：
 * FatMouse is the only one for you...
 * 输入样例3：
 * LaoLao
 * .
 * 输出样例3：
 * Momo... No one is for you ...
 */
public class 情人节 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        //存放点赞的人
        ArrayList<String> list = new ArrayList<>();
        while(!".".equals(name)){
            list.add(name);
            name = bf.readLine();
        }
        if(list.size() >= 14){
            System.out.printf("%s and %s are inviting you to dinner...", list.get(1), list.get(13));
        }else if(list.size() >= 2){
            System.out.printf("%s is the only one for you...", list.get(1));
        }else{
            System.out.println("Momo... No one is for you ...");
        }
    }
}
