package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Alan最近眼神不好使，经常分不清楚括号，所以想请你帮忙，给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，想让你帮忙编写程序确定括号是否都是正常闭合。
 *
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 空字符串被认定为True
 * 输入格式:
 * 输入空字符串或一行只包含'('，')'，'{'，'}'，'['，']' 的字符串。
 *
 * 输出格式:
 * 如果所有括号正确闭合，输出“True”，否则输出“False”。
 */
public class 有效括号判断 {
    public static boolean isMatch(String str){
        Stack<Character> brackets=new Stack<Character>();
        int i=0;
        while (i<str.length()) {
            char bra=str.charAt(i);
            //若匹配到左括号,进栈
            if(bra=='('||bra=='['||bra=='{'){
                brackets.push(str.charAt(i));
            }
            //若匹配到右括号
            if(bra==')'){
                //匹配到相应的左括号,出栈
                if(brackets.empty()||brackets.peek()!='('){
                    return false;
                }
                brackets.pop();
            }
            if(bra==']'){
                //匹配到相应的左括号,出栈
                if(brackets.empty()||brackets.peek()!='['){
                    return false;
                }
                brackets.pop();
            }
            if(bra=='}'){
                //匹配到相应的左括号,出栈
                if(brackets.empty()||brackets.peek()!='{'){
                    return false;
                }
                brackets.pop();
            }
            i++;
        }
        return brackets.empty();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入括号字符串
        String str=sc.nextLine();
        if(isMatch(str)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
