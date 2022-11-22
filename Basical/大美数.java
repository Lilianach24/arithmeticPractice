package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 若正整数 N 可以整除它的 4 个不同正因数之和，则称这样的正整数为“大美数”。本题就要求你判断任一给定的正整数是否是“大美数”。
 *
 * 输入格式：
 * 输入在第一行中给出正整数 K（≤10），随后一行给出 K 个待检测的、不超过 10
 * 4
 *   的正整数。
 *
 * 输出格式：
 * 对每个需要检测的数字，如果它是大美数就在一行中输出 Yes，否则输出 No。
 *
 * 输入样例：
 * 3
 * 18 29 40
 * 输出样例：
 * Yes
 * No
 * Yes
 */
public class 大美数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] data = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(data[i]);
            //将num的所有因数放入一个线性表中
            ArrayList<Integer> factor = new ArrayList<>();
            for (int j = 1; j <= Math.sqrt(num); j++) {
                if(num % j == 0){
                    factor.add(j);
                    //因子中可能存在重复的，所以需要判断是否已经添加了该因子
                    if(!factor.contains(num / j)){
                        factor.add(num / j);
                    }
                }
            }
            //如果该数的因数小于四，则该数不可能是大美数
            if(factor.size() < 4){
                System.out.println("No");
            }else {
                boolean flag = false;
                for (int j = 0; j < factor.size() - 3; j++) {
                    for (int k = j + 1; k < factor.size() - 2; k++) {
                        for (int l = k + 1; l < factor.size() - 1; l++) {
                            for (int m = l + 1; m < factor.size(); m++) {
                                //计算四个因数的和
                                int sum = factor.get(j) + factor.get(k) + factor.get(l) + factor.get(m);
                                //四个因数的和除以该整数
                                if(sum % num == 0){
                                    System.out.println("Yes");
                                    flag = true;
                                    break;
                                }
                            }
                            if(flag){
                                break;
                            }
                        }
                        if(flag){
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                if(!flag){
                    System.out.println("No");
                }
            }
        }
    }
}
