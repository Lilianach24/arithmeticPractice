package test.SqStackTest;

import linear.SqStack;

/**
 * @author cl
 *
 * 利用顺序栈判断用户输入的字符串表达式是否为回文
 */
public class Example2 {
    public static boolean isPalindrome(String str){
        SqStack<Character> st=new SqStack<>();
        int n=str.length();
        int i=0;
        //使str的前半部分进栈
        while (i<n/2){
            st.push(str.charAt(i));
            i++;
        }
        //n为奇数时,跳过中间的字符
        if(n%2==1){
            i++;
        }
        //遍历后半部分str
        while (i<n){
            if(st.pop()!=str.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("测试1");
        String str="abcbda";
        if(isPalindrome(str)){
            System.out.println(str+"是回文");
        }else {
            System.out.println(str+"不是回文");
        }
        System.out.println("测试2");
        str="1221";
        if(isPalindrome(str)){
            System.out.println(str+"是回文");
        }else {
            System.out.println(str+"不是回文");
        }
    }
}
