package com.company.basical;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 根据维基百科的定义：
 *
 * 插入排序是迭代算法，逐一获得输入数据，逐步产生有序的输出序列。每步迭代中，算法从输入序列中取出一元素，将之插入有序序列中正确的位置。如此迭代直到全部元素有序。
 *
 * 归并排序进行如下迭代操作：首先将原始序列看成 N 个只包含 1 个元素的有序子序列，然后每次迭代归并两个相邻的有序子序列，直到最后只剩下 1 个有序的序列。
 *
 * 现给定原始序列和由某排序算法产生的中间序列，请你判断该算法究竟是哪种排序算法？
 *
 * 输入格式：
 * 输入在第一行给出正整数 N (≤100)；随后一行给出原始序列的 N 个整数；最后一行给出由某排序算法产生的中间序列。这里假设排序的目标序列是升序。数字间以空格分隔。
 *
 * 输出格式：
 * 首先在第 1 行中输出Insertion Sort表示插入排序、或Merge Sort表示归并排序；然后在第 2 行中输出用该排序算法再迭代一轮的结果序列。题目保证每组测试的结果是唯一的。数字间以空格分隔，且行首尾不得有多余空格。
 *
 * 输入样例 1：
 * 10
 * 3 1 2 8 7 5 9 4 6 0
 * 1 2 3 7 8 5 9 4 6 0
 * 输出样例 1：
 * Insertion Sort
 * 1 2 3 5 7 8 9 4 6 0
 * 输入样例 2：
 * 10
 * 3 1 2 8 7 5 9 4 0 6
 * 1 3 2 8 5 7 4 9 0 6
 * 输出样例 2：
 * Merge Sort
 * 1 2 3 8 4 5 7 9 0 6
 */
public class 插入与归并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //存储原始数组
        int[] org = new int[n];
        for (int i = 0; i < n; i++) {
            org[i] = sc.nextInt();
        }
        //存储中间序列
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = sc.nextInt();
        }
        //如果中间序列的前面有序，且后面还没有排好序的数字与原数组完全一致，则该算法用的是插入排序，否则就是归并排序
        //记录还没有排好序的位置
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if(sorted[i] > sorted[i + 1]){
                index = i + 1;
                break;
            }
        }
        //判断后面还没有排好序的数字是否与原数组一致
        String type = "Insertion Sort";
        for (int i = index; i < n; i++) {
            if(sorted[i] != org[i]){
                type = "Merge Sort";
                break;
            }
        }
        //如果是插入排序
        if(type.equals("Insertion Sort")){
            for (int j = index; j > 0; j--) {
                if(sorted[j] < sorted[j - 1]){
                    int tmp = sorted[j];
                    sorted[j] = sorted[j - 1];
                    sorted[j - 1] = tmp;
                }
            }
        }else{
            //模拟归并排序，直到与中间序列相同
            /*index = 2 * index;
            for (int i = 0; i < n; i += index) {
                int next = Math.min(i + index, n);
                Arrays.sort(sorted, i, next);
            }*/
            int d = 1;
            boolean flag = true;
            while(flag){
                flag = false;
                for (int i = 0; i < n; i++) {
                    if (org[i] != sorted[i]) {
                        flag = true;
                        break;
                    }
                }
                d *= 2;
                for (int i = 0; i < n / d; i++) {
                    Arrays.sort(org, i * d, (i + 1) * d);
                }
                Arrays.sort(org, n / d * d, n);
            }
            sorted = Arrays.copyOfRange(org, 0, n);
        }
        System.out.println(type);
        for (int i = 0; i < n; i++) {
            System.out.print(sorted[i]);
            if(i != n - 1){
                System.out.print(" ");
            }
        }
    }
}
