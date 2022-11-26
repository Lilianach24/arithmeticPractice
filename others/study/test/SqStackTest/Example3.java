package test.SqStackTest;


import linear.SqStack;

/**
 * @author cl
 *
 * 有1~n的n个元素,通过一个栈可以产生多种出栈序列,设计一个算法判断序列b是否为一个合法的出栈序列,并给出操作过程
 */
public class Example3 {
    static String op="";
    public static boolean isSerial(int[] b){
        int i,j,n=b.length;
        Integer e;
        int[] a=new int[n];
        SqStack<Integer> st=new SqStack<>();
        //将1~n放入数组a中
        for (i = 0; i < n; i++) {
            a[i]=i+1;
        }
        //a和b均没有遍历完
        i=0;j=0;
        while (i<n&&j<n){
            //a[i]进栈
            st.push(a[i]);
            op+=" 元素"+a[i]+"进栈\n";
            i++;
            //使栈中与b序列相同的元素出栈
            while (!st.isEmpty()&&st.peek()==b[j]){
                e=st.pop();
                op+=" 元素"+e+"出栈\n";
                j++;
            }

            /*if(st.isEmpty()||st.peek()!=b[j]){
                st.push(a[j]);
                op+=" 元素"+a[i]+"进栈\n";
                i++;
            }
            else {
                e=st.pop();
                op+=" 元素"+e+"出栈\n";
                j++;
            }*/
        }
        /*while (!st.isEmpty()&&st.peek()==b[j]){
            e=st.pop();
            j++;
        }*/
        return j==n;
    }
    public static void solve(int[] b){
        for (int value : b) {
            System.out.print(" " + value);
        }
        if(isSerial(b)){
            System.out.println("是合法的出栈序列");
            System.out.println(op);
        }else {
            System.out.println("不是合法的出栈序列");
        }
    }

    public static void main(String[] args) {
        System.out.println("测试1");
        int[] b={1,3,2,4};
        solve(b);
        System.out.println("测试2");
        int[] c={4,3,2,1};
        solve(c);
    }
}
