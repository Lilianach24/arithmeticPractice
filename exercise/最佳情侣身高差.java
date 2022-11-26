package competition;

import java.util.Scanner;

public class 最佳情侣身高差 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 0){
            String s = sc.next();
            float height = sc.nextFloat();
            if("M".equals(s)){
                System.out.printf("%.2f\n", height / 1.09);
            }else{
                System.out.printf("%.2f\n", height * 1.09);
            }
            n--;
        }
    }
}
