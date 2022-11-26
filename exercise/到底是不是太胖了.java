package competition;

import java.util.Scanner;

public class 到底是不是太胖了 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0){
            int h = sc.nextInt();
            int w = sc.nextInt();
            //标准体重
            double standard = 0.9 * (h - 100) * 2;
            if(Math.abs(w / 2.0 - standard) < standard * 0.1){
                System.out.println("You are wan mei!");
            }else if(w <= standard){
                System.out.println("You are tai shou le!");
            }else {
                System.out.println("You are tai pang le!");
            }
            n--;
        }
    }
}
