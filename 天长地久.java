package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * “天长地久数”是指一个 K 位正整数 A，其满足条件为：A 的各位数字之和为 m，A+1 的各位数字之和为 n，且 m 与 n 的最大公约数是一个大于 2 的素数。本题就请你找出这些天长地久数。
 *
 * 输入格式：
 * 输入在第一行给出正整数 N（≤5），随后 N 行，每行给出一对 K（3<K<10）和 m（1<m<90），其含义如题面所述。
 *
 * 输出格式：
 * 对每一对输入的 K 和 m，首先在一行中输出 Case X，其中 X 是输出的编号（从 1 开始）；然后一行输出对应的 n 和 A，数字间以空格分隔。如果解不唯一，则每组解占一行，按 n 的递增序输出；若仍不唯一，则按 A 的递增序输出。若解不存在，则在一行中输出 No Solution。
 *
 * 输入样例：
 * 2
 * 6 45
 * 7 80
 * 输出样例：
 * Case 1
 * 10 189999
 * 10 279999
 * 10 369999
 * 10 459999
 * 10 549999
 * 10 639999
 * 10 729999
 * 10 819999
 * 10 909999
 * Case 2
 * No Solution
 */
class pair{
    int n;
    int a;
    public pair(int n, int a){
        this.n = n;
        this.a = a;
    }
    public String toString(){
        return n + " " + a;
    }
}
class cmp implements Comparator<pair>{

    @Override
    public int compare(pair o1, pair o2) {
        if(o1.n == o2.n){
            return o1.a - o2.a;
        }else{
            return o1.n - o2.n;
        }
    }
}
public class 天长地久 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        //如果正整数A的个位数上是1-8，则gcd(A, A+1)恒等于1,所以不符合条件
        //如果正整数A的后面只有一个9, 则gcd(A, A+1) = {1, 2, 4, 8} ,不符合条件
        //如果正整数A的后面有三个9, 则gcd(A, A+1) = {1, 17}, 符合条件
        for (int i = 1; i <= N; i++) {
            String[] data = bf.readLine().split(" ");
            System.out.println("Case " + i);
            int k = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);
            //存储结果的集合
            List<pair> list = new LinkedList<>();
            for (int j = (int) (99 + Math.pow(10, k - 1)); j <= (int) (Math.pow(10, k) - 1); j++) {
                int n = digital_sum(j + 1);
                if(digital_sum(j) == m && gcd(m, n) > 2 && isPrime(gcd(m, n))){
                    list.add(new pair(n, j));
                }
            }
            if(list.isEmpty()){
                System.out.println("No Solution");
            }else{
                list.sort(new cmp());
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(list.get(j).toString());
                }
            }
        }
    }
    public static int gcd(int m, int n){
        return n == 0 ? m : gcd(n, m % n);
    }
    public static boolean isPrime(int num){
        //题目要求m和n的最大公约数是大于2的指数,所以这里从3开始
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int digital_sum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
