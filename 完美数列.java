package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个正整数数列，和正整数 p，设这个数列中的最大值是 M，最小值是 m，如果 M≤mp，则称这个数列是完美数列。
 *
 * 现在给定参数 p 和一些正整数，请你从中选择尽可能多的数构成一个完美数列。
 *
 * 输入格式：
 * 输入第一行给出两个正整数 N 和 p，其中 N（≤10^5）是输入的正整数的个数，p（≤10^9）是给定的参数。第二行给出 N 个正整数，每个数不超过 10^9。
 *
 * 输出格式：
 * 在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。
 *
 * 输入样例：
 * 10 8
 * 2 3 20 4 5 1 6 7 8 9
 * 输出样例：
 * 8
 */
public class 完美数列 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int p = Integer.parseInt(line[1]);
        String[] data = bf.readLine().split(" ");
        //数组
        int[] nums = new int[n];
        for (int i = 0; i < data.length; i++) {
            nums[i] = Integer.parseInt(data[i]);
        }
        //给数组进行排序
        Arrays.sort(nums);
        //将数组中从后面开始，每一个数都作为完美数列的最大值，遍历寻找最小值，然后计算出完美数列的长度，
        // 如果遍历到计算出的长度比之前计算的要小，则结束循环
        int length;
        int res = 0;
        for (int j = n - 1; j >= 0; j--) {
            int max = nums[j];
            //最小值
            int min = (int) Math.ceil(1.0 * max / p);
            //找出最小值所处的位置
            int pos = search(nums, 0, j, min);
            length = j - pos + 1;
            if(res < length){
                res = length;
            }else{
                break;
            }
        }
        System.out.println(res);
    }
    public static int search(int[] nums, int left, int right, int number){
        while(left < right){
            int mid = left + (right - left) >> 1;
            if(number > nums[mid]){
                left = mid;
            }else if(number < nums[mid]){
                right = mid;
            }else{
                return mid;
            }
        }
        return left;
    }
}
