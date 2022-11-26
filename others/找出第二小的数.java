package test;

import java.util.*;

/**
 * 求n个整数中第二小的数。
 * 相同的整数看成一个数。比如，有5个数分别是1,1,3,4,5，那么第二小的数就是3。
 *
 * 输入格式:
 * 输入包含多组测试数据。输入的第一行是一个整数C，表示有C组测试数据；
 * 每组测试数据的第一行是一个整数n，表示本组测试数据有n个整数（2<=n<=10），接着一行是n个整数（每个数均小于100）。
 *
 * 输出格式:
 * 为每组测试数据输出第二小的整数，如果不存在第二小的整数则输出“NO”，每组输出占一行。
 */
public class 找出第二小的数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入c组测试数据
        int c=sc.nextInt();
        //定义一个顺序表
        ArrayList<Integer> num=new ArrayList<Integer>();
        while (c>0){
            //清空顺序表
            num.clear();
            //输入n个测试数据
            int n=sc.nextInt();
            for (int i = 0; i < n; i++) {
                num.add(sc.nextInt());
            }
            //排序
            Collections.sort(num);
            //定义最小的一个数
            int min=num.get(0);
            for (int i = 0; i < n; i++) {
                //找到第二小的数
                if(num.get(i)>min){
                    System.out.println(num.get(i));
                    break;
                }
                //如果不存在,则输出NO
                if(i==n-1&&num.get(i)==min){
                    System.out.println("NO");
                }
            }
            c--;
        }
    }
}
