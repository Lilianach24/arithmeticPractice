package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 若一个线性表L采用顺序存储结构存储，其中所有的元素为整数。设计一个算法，删除元素值在[x,y]之间的所有元素，要求算法的时间复杂度为O(n)，空间复杂度为O(1)。
 *
 * 输入格式:
 * 三行数据，第一行是顺序表的元素个数，第二行是顺序表的元素，第三行是x和y。
 *
 * 输出格式:
 * 删除元素值在[x,y]之间的所有元素后的顺序表。
 */
public class 顺序表区间元素删除 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义一个顺序表
        ArrayList<Integer> list=new ArrayList<>();
        //输入元素的个数
        int n=sc.nextInt();
        //输入顺序表元素
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        //输入x,y
        int x=sc.nextInt(),y=sc.nextInt();
        //删除元素值在[x,y]之间的数
        // 用k记录结果顺序表中元素的个数，从头开始遍历，将不在【x，y】之间的数重新插入list中
        int k=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)<x||list.get(i)>y){
                list.set(k,list.get(i));
                k++;
            }
        }
        //结束循环之后有效长度为k，循环输出
        for (int i = 0; i < k; i++) {
            if(i!=k-1){
                System.out.print(list.get(i)+" ");
            }else {
                System.out.print(list.get(i));
            }
        }
    }
}
