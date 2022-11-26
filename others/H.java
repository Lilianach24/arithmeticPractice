package Unit1;

import java.util.*;

/**
 * ACboy请求帮助问题
 */
public class H {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //第一行输入测试用例的个数
        int n=sc.nextInt();
        //定义一个栈
        Stack<Integer> st=new Stack<Integer>();
        //定义一个队列
        Queue<Integer> qu=new LinkedList<Integer>();
        while (n>0){
            //第一行输入一个整数和一个单词
            int m=sc.nextInt();
            String str=sc.next();
            //清空栈和队列
            st.clear();
            qu.clear();
            //输入命令
            String str2;
            int num;

            if("FIFO".equals(str)){
                //代表"先进先出"
                for (int i = 0; i < m; i++) {
                    str2=sc.next();
                    if("IN".equals(str2)){
                        num=sc.nextInt();
                        qu.offer(num);
                    }else {
                        if(!qu.isEmpty()){
                            System.out.println(qu.poll());
                        }else {
                            System.out.println("None");
                        }
                    }

                }
            }
            if("FILO".equals(str)){
                //代表"先进后出"
                for (int i = 0; i < m; i++) {
                    str2=sc.next();
                    if("IN".equals(str2)){
                        num=sc.nextInt();
                        st.push(num);
                    }else {
                        if(!st.empty()){
                            System.out.println(st.pop());
                        }else {
                            System.out.println("None");
                        }
                    }
                }
            }
            n--;
        }
    }
}
