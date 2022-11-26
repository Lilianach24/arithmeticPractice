package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个初始为空的栈和一系列压栈、弹栈操作，请编写程序输出每次弹栈的元素。栈的元素值均为整数。
 *
 * 输入格式:
 * 输入第1行为1个正整数n，表示操作个数；接下来n行，每行表示一个操作，格式为1 d或0。1 d表示将整数d压栈，0表示弹栈。n不超过20000。
 *
 * 输出格式:
 * 按顺序输出每次弹栈的元素，每个元素一行。若某弹栈操作不合法（如在栈空时弹栈），则对该操作输出invalid。
 */
public class 栈的实现及基本操作 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入操作个数
        int n=sc.nextInt();
        //建立一个栈
        Stack<Integer> num=new Stack<Integer>();
        int x,y;
        for (int i = 0; i < n; i++) {
            x=sc.nextInt();
            //如果x为1,将y入栈
            if(x==1){
                y=sc.nextInt();
                num.push(y);
            }else {
                if(!num.empty()){
                    System.out.println(num.pop());
                }else {
                    System.out.println("invalid");
                }
            }
        }
    }
}
