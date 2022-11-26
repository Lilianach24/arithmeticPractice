package basicLevel;

import java.io.*;
import java.util.HashMap;

/**
 * 输入格式：
 * 输入第 1 行给出正整数 N（≤10^5），即双方交锋的次数。随后 N 行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。
 * C 代表“锤子”、J 代表“剪刀”、B 代表“布”，第 1 个字母代表甲方，第 2 个代表乙方，中间有 1 个空格。
 *
 * 输出格式：
 * 输出第 1、2 行分别给出甲、乙的胜、平、负次数，数字间以 1 个空格分隔。
 * 第 3 行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有 1 个空格。如果解不唯一，则输出按字母序最小的解。
 *
 * 输入样例：
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 * 输出样例：
 * 5 3 2
 * 2 3 5
 * B B
 */
public class 锤子剪刀布 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //只需要记录甲乙分别的胜局,就可以算出甲,乙的胜平负分别是多少,分别记胜平负局是1, 0, -1
        int sum1 = 0, sum2 = 0;
        //第二个就是要记录甲和乙获胜时的手势就是解题的关键, 用两个hashmap分别存储甲乙两人获胜时的手势
        HashMap<String, Integer> map1 = new HashMap<>(3);
        HashMap<String, Integer> map2 = new HashMap<>(3);

        for (int i = 0; i < n; i++) {
            String[] player = bf.readLine().split(" ");
            int result = result(player[0], player[1]);
            //甲获胜
            if(result == 1){
                sum1++;
                if(map1.containsKey(player[0])){
                    int num1 = map1.get(player[0]);
                    map1.replace(player[0], num1, num1 + 1);
                }else {
                    map1.put(player[0], 1);
                }
            }
            //乙获胜
            else if(result == -1){
                sum2++;
                if(map2.containsKey(player[1])){
                    int num2 = map2.get(player[1]);
                    map2.replace(player[1], num2, num2 + 1);
                }else {
                    map2.put(player[1], 1);
                }
            }
        }
        //输出甲乙胜平负
        int ping = n - sum1 - sum2;
        System.out.println(sum1 + " " + ping + " " + sum2);
        System.out.println(sum2 + " " + ping + " " + sum1);
        //输出甲乙获胜时出的最多的手势
        int max1 = 0;
        String point1 = "B";
        for (String s : map1.keySet()) {
            if(map1.get(s) >= max1){
                max1 = map1.get(s);
                point1 = s;
            }
        }
        int max2 = 0;
        String point2 = "B";
        for (String s : map2.keySet()) {
            if (map2.get(s) >= max2) {
                max2 = map2.get(s);
                point2 = s;
            }
        }
        System.out.println(point1 + " " + point2);
    }
    public static int result(String a, String b){
        if(a.equals(b)){
            return 0;
        }else if(("C".equals(a) && "J".equals(b)) || ("J".equals(a) && "B".equals(b)) || ("B".equals(a) && "C".equals(b))){
            return 1;
        }else{
            return -1;
        }
    }
}
