package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 乒乓球早期曾采用21分制，经过改革后现在的赛制主流采用11分制，现在需要对多年比赛的统计数据进行一些分析。 具体通过以下方式进行分析，首
 * 先将比赛每个球的胜负列成一张表，然后分别计算在11分制和21分制下，双方的比赛结果（截至记录末尾）。 比如现在有这么一份记录，（其中W表
 * 示我国队员获得一分，L表示外国对手获得一分）： WWWWWWWWWWWWWWWWWWWWW WLW。
 * 在11分制下，此时比赛的结果是我国队员第一局11比0获胜，第二局11比0获胜，正在进行第三局，当前比分1比1。而在21分制下，此时比赛结果是我
 * 国队员第一局21比0获胜，正在进行第二局，比分2比1。如果一局比赛刚开始，则此时比分为0比0。 你的程序就是要对于一系列比赛信息的输入
 * （WL形式），输出正确的结果。
 *
 * 输入格式:
 * 每个输入文件包含若干行字符串（每行至多20个字母），字符串有大写的W、L和E组成。其中E表示比赛信息结束，程序应该忽略E之后的所有内容。
 *
 *
 * 输出格式:
 * 输出由两部分组成，每部分有若干行，每一行对应一局比赛的比分（按比赛信息输入顺序）。其中第一部分是11分制下的结果，第二部分是21分制下的结果，两部分之间由一个空行分隔。
 */
public class 自动判分 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义一个线性表
        ArrayList<Character> comp=new ArrayList<Character>();
        //将比赛结构存储到线性表中
        boolean flag=true;
        while (flag){
            String str=sc.nextLine();
            for (int i = 0; i < str.length(); i++) {
                //若字符串中有E表示结束
                if(str.charAt(i)=='E'){
                    flag=false;
                    break;
                }
                comp.add(str.charAt(i));
            }
        }
        //分别表示我国和外国的得分情况
        int chi=0,fori=0;
        //输出11分制比赛结果
        for (Character character : comp) {
            if (character == 'W') {
                chi++;
            } else {
                fori++;
            }
            //11分制是指在一局比赛中先得11分的为胜利方,当出现10平后,就要看哪一方先领先2分,领先2分的为胜利方
            if (chi >= 11 || fori >= 11) {
                if(chi - fori >= 2 || fori - chi >= 2){
                    System.out.println(chi + ":" + fori);
                    chi = 0;
                    fori = 0;
                }
            }
        }
        System.out.println(chi+":"+fori);
        System.out.println();
        //输出21分制比赛结果
        chi=0;fori=0;
        for (Character character : comp) {
            if (character == 'W') {
                chi++;
            } else {
                fori++;
            }
            if (chi >= 21 || fori >= 21) {
                if (chi - fori >= 2 || fori - chi >= 2) {
                    System.out.println(chi + ":" + fori);
                    chi = 0;
                    fori = 0;
                }
            }
        }
        System.out.println(chi+":"+fori);
    }
}
