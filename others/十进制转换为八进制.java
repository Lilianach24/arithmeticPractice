package test;

import java.util.Scanner;

/**
 * 利用栈（以顺序栈作存储结构）实现进制转换。给定一个十进制整数，编程将该数以八进制形式输出。
 *
 * 顺序栈的类型定义：
 *
 * #define MAXSIZE 100   // MAXSIZE为最大数据元素数目
 * typedef int ElemType;
 * typedef struct
 * {   ElemType  *base;
 *     ElemType  *top;
 * }SqStack;
 * 输入格式:
 * 输入一个十进制整数。
 *
 * 输出格式:
 * 输出转换后的八进制数。
 */
public class 十进制转换为八进制 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Integer.toOctalString(n));
    }
}
