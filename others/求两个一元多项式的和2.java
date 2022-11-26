package test;

import java.util.ArrayList;
import java.util.Scanner;

public class 求两个一元多项式的和2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入第一行多项式
        int n=sc.nextInt();
        ArrayList<Integer> poly1=new ArrayList<Integer>();
        for (int i = 0; i < 2*n; i++) {
            poly1.add(sc.nextInt());
        }
        //输入第二个多项式
        int m=sc.nextInt();
        ArrayList<Integer> poly2=new ArrayList<Integer>();
        for (int i = 0; i < 2*m; i++) {
            poly2.add(sc.nextInt());
        }
        //如果是0多项式,则输出0
        if(n==0&&m==0){
            System.out.println(0+" "+0);
        }else {
            //定义存储求和的结果的顺序表
            ArrayList<Integer> result=new ArrayList<Integer>();
            //求出两个多项式中更短的一个
            int x=Math.min(n,m);
            int i=1,j=1;
            for (;i < 2*x;) {
                //如果第一个多项式或者第二个多项式的前面的项的系数不相等的话,就直接存储到结果表中,然后跳过这一项
                if(poly1.get(i)>poly2.get(j)){
                    result.add(poly1.get(i-1));
                    result.add(poly1.get(i));
                    i+=2;
                }else if(poly1.get(i)<poly2.get(j)){
                    result.add(poly2.get(j-1));
                    result.add(poly2.get(j));
                    j+=2;
                }
                //否则就计算和,然后将结果存储到结果表中
                else {
                    int c=poly1.get(i-1)+poly2.get(j-1);
                    if(c==0){
                        result.add(0);
                        result.add(0);
                    }else {
                        result.add(c);
                        result.add(poly1.get(i));
                    }
                    i+=2;
                    j+=2;
                }
            }
            //最后将剩余的项存储到结果表中
            //表示多项式一更长
            if(x<n){
                for (int k = i-1; k < 2*n; k++) {
                    result.add(poly1.get(k));
                }
            }
            //表示多项式二更长
            if(x<m){
                for (int k = j-1; k < 2*m; k++) {
                    result.add(poly2.get(k));
                }
            }

            //最后输出结果
            for (int k = 0; k < result.size(); k++) {
                System.out.print(result.get(k));
                if(k!=result.size()-1){
                    System.out.print(" ");
                }
            }
        }

    }
}
