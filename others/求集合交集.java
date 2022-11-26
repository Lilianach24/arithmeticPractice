package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 求整数集合A与整数集合B的交集。
 *
 * 输入格式:
 * 输入有三行：
 * 第一行是A和B的元素个数m和n（m,n <=100）；
 * 第二行是集合A的m个元素；
 * 第三行是集合B的n个元素。
 *
 * 输出格式:
 * 输出交集的所有元素（按照在A集合出现的顺序输出，最后一个输出后面没有空格）。 若交集为空，输出“NULL”。
 */
public class 求集合交集 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入集合A,B的元素个数
        int na=sc.nextInt();
        int nb=sc.nextInt();
        //定义三个顺序表,分别代表A,B集合和交集
        ArrayList<Integer> listA=new ArrayList<Integer>();
        ArrayList<Integer> listB=new ArrayList<Integer>();
        ArrayList<Integer> intersection=new ArrayList<Integer>();
        //输入集合A
        for (int i = 0; i < na; i++) {
            listA.add(sc.nextInt());
        }
        //输入集合B
        for (int i = 0; i < nb; i++) {
            listB.add(sc.nextInt());
        }
        //判断集合B中的元素是否也存在与集合A中
        for (Integer integer : listA) {
            if (listB.contains(integer)) {
                intersection.add(integer);
            }
        }
        int len=intersection.size();
        //如果交集为空,输出NULL
        if(len==0){
            System.out.println("NULL");
        }else {
            for (int i = 0; i < len; i++) {
                System.out.print(intersection.get(i));
                if(i!=len-1){
                    System.out.print(" ");
                }
            }
        }
    }
}
