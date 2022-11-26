package test;

import java.util.*;

/**
 * 小明带着n个幼儿园的小朋友围成一圈分糖果，大家先随便拿偶数个，每个小朋友将手中的糖果分成两份，一份分给下一个小朋友（若进行编号，1号
 * 给2号，2号给3号，……n号给1号，此时i号小朋友的糖果数量是本人的一半加上前一个i-1号小朋友分的一半），此时若某个小朋友的糖果个数为奇数
 * 的话，小明就负责发一颗以构成偶数个。再分成两份，分一份给下一个小朋友……最后大家手上的糖果会变成一样多。若给定人数和开始每个小朋友手
 * 上的糖果数，编程计算小明至少要补发多少颗糖果。
 *
 * 输入格式:
 * 输入两行数据：第一行是一个整数，表示小朋友的数量；第二行是n个偶数（以空格分隔）表示每个小朋友开始时手上的糖果数量。
 *
 * 输出格式:
 * 输出一个整数，表示小明一共需要补发的糖果数量。
 */

/**
 * 循环单链表泛型类
 */

public class 分糖果 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入小朋友的数量
        int n=sc.nextInt();
        ArrayList<Integer> nums=new ArrayList<Integer>();
        //输入每个小朋友手上糖果的数量
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        boolean flag=true;
        //计算补发的数量
        int sum=0;
        while (flag){
            //遍历循环每个小朋友
            for (int i = 0; i < nums.size(); i++) {
                //如果某个小孩手中的糖果数量与前一个小孩的糖果数量不相等,则
                if(!nums.get(i).equals(nums.get((i - 1 + n)%n))){
                    int data=(nums.get(i)+nums.get((i-1+n)%n))/2;
                    nums.set(i,data);
                    //判断奇偶
                    if(nums.get(i)%2==1){
                        nums.set(i,data+1);
                    }
                }
            }
            //遍历循环所有小朋友,查看是否每个小朋友手中的糖果数量相等
            for (int i = 0; i < nums.size()-1; i++) {
                sum+=nums.get(i);
                if(!nums.get(i).equals(nums.get(i + 1))){
                    sum=0;
                    break;
                }
                if (i == nums.size() - 1 && nums.get(i).equals(nums.get(i - 1))) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
