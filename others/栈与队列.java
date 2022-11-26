package test;

import java.util.*;

/**
 * 使用栈与队列逐个处理字符串中的每个字符
 *
 * 将line中的字符依次入栈，然后输出栈中元素个数与栈顶元素。
 * 输入一个字符x(待删除字符)。然后将栈中元素依次出栈并输出，出栈时将不等于x的字符依次入队列，以空格分隔。
 * 输出队列元素个数，队头与队尾，以空格分隔。
 * 最后输出队列中所有元素。
 *
 * 输入格式:
 * 输入一个个字符串 输入一个字符x(待删除字符)
 *
 * 输出格式:
 * 栈中元素个数 栈顶元素
 * 栈中符合条件的元素(以空格分隔)
 * 队列中元素个数 队头元素 队尾元素
 * 队列中所有元素(以空格分隔)
 */
public class 栈与队列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        //定义一个栈
        Stack<Character> st=new Stack<Character>();
        //定义一个队列
        Queue<Character> qu=new LinkedList<Character>();
        //输入一个字符
        char x=sc.next().charAt(0);
        //将line中的字符依次入栈，然后输出栈中元素个数与栈顶元素
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }
        System.out.println(st.size()+" "+st.peek());
        //找出队尾元素
        char e=st.peek();
        //将栈中的元素依次出栈
        for (int i = 0; i < str.length(); i++) {
            //将不等于x的字符存储到队列中
            if(st.peek()!=x){
                qu.offer(st.peek());
                if(i==str.length()-1){
                    e=st.peek();
                }
            }
            if(!st.empty()){
                System.out.print(st.pop());
            }
        }
        System.out.println();
        //输出队列中元素个数,队头,队尾元素,队尾元素即栈底元素
        int len=qu.size();
        System.out.println(len+" "+qu.peek()+" "+e);
        //输出队列中的元素
        for (int i = 0; i < len; i++) {
            System.out.print(qu.poll());
        }
    }
}
