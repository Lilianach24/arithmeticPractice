package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入一行字符，其中包括任意合法的字符。要求编写程序，检验其中的括号 ( 和 ) 是否匹配。
 *
 * 输入格式:
 * 输入一行不超过1000个字符的字符串，以换行符结尾。
 *
 * 输出格式:
 * 输出括号匹配的检验结果，如果匹配，则输出 Yes!，否则输出 No!。
 */
public class 括号匹配检验 {
    public static boolean isMatch(String str){
        //定义一个栈
        Stack<Character> opor=new Stack<Character>();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch=str.charAt(i);
            //如果为
            if(ch=='('){
                opor.push(ch);
            }
            if(ch==')'){
                if(opor.empty()){
                    return false;
                }
                if(opor.peek()!='('){
                    return false;
                }
                opor.pop();
            }
        }
        return opor.empty();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(isMatch(str)){
            System.out.println("Yes!");
        }else {
            System.out.println("No!");
        }
    }
}
