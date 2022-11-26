package competition;

import java.util.Scanner;

/**
 * 本题的目标很简单，就是判断一个给定的正整数是否素数。
 *
 * 输入格式：
 * 输入在第一行给出一个正整数N（≤ 10），随后N行，每行给出一个小于2
 * 31
 *  的需要判断的正整数。
 *
 * 输出格式：
 * 对每个需要判断的正整数，如果它是素数，则在一行中输出Yes，否则输出No。
 *
 * 输入样例：
 * 2
 * 11
 * 111
 * 输出样例：
 * Yes
 * No
 */
public class 判断素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0){
            int num = sc.nextInt();
            if(num < 2){
                System.out.println("No");
            }else{
                boolean flag = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if(num % i == 0){
                        flag = false;
                        System.out.println("No");
                        break;
                    }
                }
                if(flag){
                    System.out.println("Yes");
                }
            }
            n--;
        }
    }
}
