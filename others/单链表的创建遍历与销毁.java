package test;

/**
 * 从键盘输入任意多个正整数，输入以-1结束。逆序输出这些整数(不包括-1)。 提示： 1、逆序创建单链表。结点数据域是整型数。每输入一个整数，
 * 向链表中插入一个结点。当输入-1时结束链表的创建。 2、遍历链表，输出结点数据域的值。 3、遍历完成后，要求销毁该链表。
 *
 * 输入格式:
 * 任意多的正整数，输入序列以-1结束。
 *
 * 输出格式:
 * 逆序输出这些整数（不包括-1）。
 */

import java.util.LinkedList;
import java.util.Scanner;

public class 单链表的创建遍历与销毁 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //创建单链表
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (sc.hasNext()){
            int x=sc.nextInt();
            //输入-1时结束
            if(x==-1){
                break;
            }
            list.add(x);
        }
        //遍历链表,输出结点域的值
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
            if(i==0){
                //最后销毁链表
                list.clear();
            }
        }
    }
}
