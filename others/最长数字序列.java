package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入一个字符串，求该字符串中最长连续数字序列出现的起始位置及其长度。
 *
 * 输入格式:
 * 输入一个字符串，可包含空格。
 *
 * 输出格式:
 * 输出内容：最长数字序列起始位置和长度空格隔开。输出尾部不能有空格。输入空串，输出"NULL"
 */
public class 最长数字序列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        //ArrayList<Character> chars=new ArrayList<>();
        //输入空字符串,输出null
        if("".equals(str)){
            System.out.println("NULL");
        }
        //否则循环遍历字符串
        else {
            //记录长度
            int len=0;
            //记录起始位置和最大长度
            int start=0,maxlen=0;
            for (int i = 0; i < str.length(); i++) {
                //chars.add(str.charAt(i));
                //如果是数字
                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    //计算数字序列的长度
                    len++;
                    if(i+1<str.length()){
                        if(str.charAt(i+1)<'0'||str.charAt(i+1)>'9'){
                            //开始的位置
                            start=i+1-len;
                            //最大长度
                            maxlen=len;
                        }
                    }
                }
                //如果不是数字
                else {
                    //如果长度大于最大长度
                    if(len>maxlen){
                        maxlen=len;
                        start=i-maxlen;
                    }
                    //将长度置为0
                    len=0;
                }
            }
            if(len>maxlen){
                maxlen=len;
                start=str.length()-maxlen;
            }
            System.out.println(start+" "+maxlen);
        }
    }
}
