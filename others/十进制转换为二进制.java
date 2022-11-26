package test;

import java.util.Scanner;
import java.util.Stack;

public class 十进制转换为二进制 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Integer.toBinaryString(n));
        /*//定义一个栈
        Stack<Integer> st=new Stack<Integer>();
        //将十进制转换为二进制
        int yu;
        while (n>0){
            yu=n%2;
            st.push(yu);
            n=n/2;
        }
        for (Integer integer : st) {
            System.out.print(integer);
        }*/
    }
}
