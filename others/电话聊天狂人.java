package test2;

import java.io.*;
import java.util.TreeMap;


/**
 * 给定大量手机用户通话记录，找出其中通话次数最多的聊天狂人。
 *
 * 输入格式:
 * 输入首先给出正整数N（≤10^5），为通话记录条数。随后N行，每行给出一条通话记录。简单起见，这里只列出拨出方和接收方的11位数字构成的手机号码，其中以空格分隔。
 *
 * 输出格式:
 * 在一行中给出聊天狂人的手机号码及其通话次数，其间以空格分隔。如果这样的人不唯一，则输出狂人中最小的号码及其通话次数，并且附加给出并列狂人的人数。
 */
public class 电话聊天狂人 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        //输入通话记录条数
        int n= Integer.parseInt(bf.readLine());
        //定义存储通话记录条数的map集合
        TreeMap<String, Integer> map=new TreeMap<String,Integer>();
        for (int i = 0; i < n; i++) {
            String[] tele=bf.readLine().split(" ");
            if(map.containsKey(tele[0])){
                //这个号码有多条通话记录
                map.put(tele[0],map.get(tele[0])+1);
            }else {
                //这个号码还没有通话记录
                map.put(tele[0],1);
            }
            if(map.containsKey(tele[1])){
                map.put(tele[1],map.get(tele[1])+1);
            }else {
                map.put(tele[1],1);
            }
        }
        //分别记录聊天狂人的号码,次数,和聊天狂人的个数
        String telephone="";
        int max=0,men=0;
        for (String str:map.keySet()) {
            if(map.get(str)>max){
                max=map.get(str);
                telephone=str;
                men=1;
            }else if(map.get(str)==max){
                men++;
            }
        }
        //聊天狂人不止一个
        if(men>1){
            System.out.println(telephone+" "+max+" "+men);
        }else {
            System.out.println(telephone+" "+max);
        }
    }
}
