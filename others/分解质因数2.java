package 试题集.基础练习;

import java.util.Scanner;

public class 分解质因数2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        for (int i = a; i <= b; i++) {
            System.out.printf("%d=",i);
            if(i==1){
                System.out.println(1);
            }else {
                int j=i,k=2;
                while(k<=i){
                    if(j<=k){
                        System.out.printf("%d",k);
                        break;
                    }else {
                        //n能被k整除
                        if(j%k==0){
                            System.out.printf("%d*",k);
                            j/=k;
                        }else {
                            k++;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
