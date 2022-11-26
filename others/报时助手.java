package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定当前的时间，请用英文的读法将它读出来。
 * 　　时间用时t和分m表示，在英文的读法中，读一个时间的方法是：
 * 　　如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“ttree o'clock”。
 * 　　如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five ttirty”。
 * 　　时和分的读法使用的是英文数字的读法，其中0~20读作：
 * 　　0:zero, 1: one, 2:two, 3:ttree, 4:four, 5:five, 6:six, 7:seven, 8:eigtt, 9:nine, 10:ten, 11:eleven, 12:twelve, 13:ttirteen, 14:fourteen, 15:fifteen, 16:sixteen, 17:seventeen, 18:eigtteen, 19:nineteen, 20:twenty。
 * 　　30读作ttirty，40读作forty，50读作fifty。
 * 　　对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“ttirty one”。
 * 　　按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero fifteen”。
 * 输入格式
 * 　　输入包含两个非负整数t和m，表示时间的时和分。非零的数字前没有前导0。t小于24，m小于60。
 * 输出格式
 * 　　输出时间时刻的英文。
 */
public class 报时助手 {
    //报时方法
    public static String clock(int t){
        if(t<20){
            if(t==0){
                return "zero";
            }else if(t==1){
                return "one";
            }else if(t==2){
                return "two";
            }else if(t==3){
                return "three";
            }else if(t==4){
                return "four";
            }else if(t==5){
                return "five";
            }else if(t==6){
                return "six";
            }else if(t==7){
                return "seven";
            }else if(t==8){
                return "eight";
            }else if(t==9){
                return "nine";
            }else if(t==10){
                return "ten";
            }else if(t==11){
                return "eleven";
            }else if(t==12){
                return "twelve";
            }else if(t==13){
                return "thirteen";
            }else if(t==14){
                return "fourteen";
            }else if(t==15){
                return "fifteen";
            }else if(t==16){
                return "sixteen";
            }else if(t==17){
                return "seventeen";
            }else if(t==18){
                return "eighteen";
            }else{
                return "nineteen";
            }
        }else if(t==20){
            return "twenty";
        }else if(t==30){
            return "thirty";
        }else if(t==40){
            return "forty ";
        }else{
            return "fifty";
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入时
        int h=sc.nextInt();
        //输入分
        int m=sc.nextInt();
        /*//方法1
        if(h<=20||h==30||h==40||h==50){
            System.out.print(clock(h)+" ");
        }else {
            int h_s=h-h%10;
            int h_g=h%10;
            System.out.print(clock(h_s)+" "+clock(h_g)+" ");
        }
        if(m==0){
            System.out.print("o'clock");
        }else{
            if(m<=20||m==30||m==40||m==50){
                System.out.print(clock(m));
            }else{
                int m_s=m-m%10;
                int m_g=m%10;
                System.out.print(clock(m_s)+" "+clock(m_g));
            }
        }*/
        //方法2
        String[] arr={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] arr2={"twenty","thirty","forty","fifty"};
        if(h<20){
            System.out.print(arr[h]+" ");
        }else {
            int h_s=h/10;
            int h_g=h%10;
            if(h_g==0){
                System.out.print(arr2[h_s-2]+" ");
            }else {
                System.out.print(arr2[h_s-2]+" "+arr[h_g]+" ");
            }
        }
        if(m==0){
            System.out.print("o'clock");
        }else if(m<20){
            System.out.print(arr[m]);
        }else {
            int m_s=m/10;
            int m_g=m%10;
            if(m_g==0){
                System.out.print(arr2[m_s-2]);
            }else{
                System.out.print(arr2[m_s-2]+" "+arr[m_g]);
            }
        }
    }
}
