package test.SqStackTest;

import linear.SqStack;

/**
 * @author cl
 *
 * 设计一个算法,利用顺序栈检查用户输入的表达式中的括号是否配对(假设表达式中可能包含小括号,中括号和大括号),并用相关数据进行测试
 */
public class Example1 {
    public static boolean isMatch(String str){
        int i=0;
        char e;
        //建立一个顺序栈
        SqStack<Character> st=new SqStack<Character>();
        while (i<str.length()){
            e=str.charAt(i);
            if(e=='('||e=='['||e=='{'){
                //将左括号进栈
                st.push(e);
            }
            else {
                if(e==')'){
                    //栈空返回false
                    if(st.isEmpty()){
                        return false;
                    }
                    //栈顶不是匹配的"("返回false
                    if(st.peek()!='('){
                        return false;
                    }
                    st.pop();
                }
                if(e==']'){
                    //栈空返回false
                    if(st.isEmpty()){
                        return false;
                    }
                    //栈顶不是匹配的"["返回false
                    if(st.peek()!='['){
                        return false;
                    }
                    st.pop();
                }
                if(e=='}'){
                    //栈空返回false
                    if(st.isEmpty()){
                        return false;
                    }
                    //栈顶不是匹配的"{"返回false
                    if(st.peek()!='{'){
                        return false;
                    }
                    st.pop();
                }
            }
            i++;
        }
        //栈空返回ture
        //否则返回false
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("测试1");
        String str="([)]";
        if(isMatch(str)){
            System.out.println(str+"中括号时匹配的");
        }else {
            System.out.println(str+"中括号时不匹配的");
        }
        System.out.println("测试2");
        str="([])";
        if(isMatch(str)){
            System.out.println(str+"中括号时匹配的");
        }else {
            System.out.println(str+"中括号时不匹配的");
        }
    }
}
