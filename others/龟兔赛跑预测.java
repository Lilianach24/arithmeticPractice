package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　话说这个世界上有各种各样的兔子和乌龟，但是研究发现，所有的兔子和乌龟都有一个共同的特点——喜欢赛跑。于是世界上各个角落都不断在发生
 * 着乌龟和兔子的比赛，小华对此很感兴趣，于是决定研究不同兔子和乌龟的赛跑。他发现，兔子虽然跑比乌龟快，但它们有众所周知的毛病——骄傲且懒
 * 惰，于是在与乌龟的比赛中，一旦任一秒结束后兔子发现自己领先t米或以上，它们就会停下来休息s秒。对于不同的兔子，t，s的数值是不同的，但是
 * 所有的乌龟却是一致——它们不到终点决不停止。
 * 　　然而有些比赛相当漫长，全程观看会耗费大量时间，而小华发现只要在每场比赛开始后记录下兔子和乌龟的数据——兔子的速度v1（表示每秒兔子
 * 能跑v1米），乌龟的速度v2，以及兔子对应的t，s值，以及赛道的长度l——就能预测出比赛的结果。但是小华很懒，不想通过手工计算推测出比赛的
 * 结果，于是他找到了你——清华大学计算机系的高才生——请求帮助，请你写一个程序，对于输入的一场比赛的数据v1，v2，t，s，l，预测该场比赛的结果。
 * 输入格式
 * 　　输入只有一行，包含用空格隔开的五个正整数v1，v2，t，s，l，其中(v1,v2<=100;t<=300;s<=10;l<=10000且为v1,v2的公倍数)
 * 输出格式
 * 　　输出包含两行，第一行输出比赛结果——一个大写字母“T”或“R”或“D”，分别表示乌龟获胜，兔子获胜，或者两者同时到达终点。
 * 　　第二行输出一个正整数，表示获胜者（或者双方同时）到达终点所耗费的时间（秒数）。
 */
public class 龟兔赛跑预测 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v1=sc.nextInt();
        int v2=sc.nextInt();
        int t=sc.nextInt();
        int s=sc.nextInt();
        int l=sc.nextInt();
        //兔子和乌龟跑完全程分别所需要的时间
        int time1=1,time2=1;
        //记录兔子一共停下来休息多少次
        int count=0;
        for(int i=1;;i++){
            //首先判断是否有到达终点的
            int s1=v1*time1;
            int s2=v2*time2;
            //兔子赢了
            if(s1>=l&&s2<l){
                System.out.println("R");
                System.out.println(time1+s*count);
                break;
            }
            //乌龟赢了
            else if(s2>=l&&s1<l){
                System.out.println("T");
                System.out.println(l/v2);
                //System.out.println(s2);
                break;
            }
            //兔子和乌龟同时到达终点
            else if(s2 >= l && s1 == s2){
                System.out.println("D");
                System.out.println(time2);
                break;
            }
            //还没有谁到达终点,然后判断是否距离是否有t米
            else{
                if(s1-s2>=t){
                    //兔子领先乌龟t米及以上,则兔子停下来休息s秒
                    time2+=s;
                    count++;
                }else {
                    time1++;
                    time2++;
                }
            }
        }
    }
}
