package competition;

import java.io.*;
import java.util.*;

/**
 * 给定一个 k 位整数 N=d(k−1)*10^k−1+⋯+d1*10^1+d0(0≤di≤9, i=0,⋯,k−1, d(k−1)>0)，请编写程序统计每种不同的个位数字出现的次数。
 * 例如：给定 N=100311，则有 2 个 0，3 个 1，和 1 个 3。
 *
 * 输入格式：
 * 每个输入包含 1 个测试用例，即一个不超过 1000 位的正整数 N。
 *
 * 输出格式：
 * 对 N 中每一种不同的个位数字，以 D:M 的格式在一行中输出该位数字 D 及其在 N 中出现的次数 M。要求按 D 的升序输出。
 *
 * 输入样例：
 * 100311
 * 输出样例：
 * 0:2
 * 1:3
 * 3:1
 */
public class 个位数统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //输入数字
        String n = bf.readLine();
        HashMap<Character,Integer> hashMap = new HashMap<>(10);
        //将输入数字中所含的数字放入HashMap中并计算个数
        for(int i=0;i<n.length();i++){
            if(!hashMap.containsKey(n.charAt(i))){
                hashMap.put(n.charAt(i),1);
            }else{
                int count = hashMap.get(n.charAt(i));
                hashMap.put(n.charAt(i),count+1);
            }
        }
        //遍历HashMap
        for (Character c : hashMap.keySet()) {
            System.out.println(c + ":" + hashMap.get(c));
        }
    }
}
