package basicLevel;

import java.util.Scanner;

public class 数字分类 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        //存储结果的数组
        int[] res = new int[5];
        //计算数字对5求余得2和4的个数
        int count2=0,count3=0;
        for (int i = 0; i < n; i++) {
            //记录数对5求余的余数
            int b=arr[i]%5;
            if(b==0){
                //A1= 能被 5 整除的数字中所有偶数的和；
                if(arr[i]%2==0){
                    res[0] += arr[i];
                }
            }else if(b==1){
                //A2= 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1−n2+n3−n4⋯；
                count2++;
                if(count2%2==1){
                    res[1] += arr[i];
                }else {
                    res[1] -= arr[i];
                }
            }else if(b==2){
                //A3= 被 5 除后余 2 的数字的个数；
                res[2]++;
            }else if(b==3){
                //A4= 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
                res[3] += arr[i];
                count3++;
            }else {
                //A5= 被 5 除后余 4 的数字中最大数字。
                if(arr[i]>res[4]){
                    res[4] = arr[i];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] == 0){
                //对于A2的数字也有可能计算的结果为0,所以需要特殊处理
                if(i == 1 && count2 != 0){
                    System.out.print(res[i]);
                }else{
                    System.out.print("N");
                }
            }else{
                if(i == 3){
                    System.out.printf("%.1f", 1.0 * res[i] / count3);
                }else{
                    System.out.print(res[i]);
                }
            }
            if(i != res.length - 1){
                System.out.print(" ");
            }
        }

    }
}
