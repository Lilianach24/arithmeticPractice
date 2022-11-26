package test2;

import java.io.*;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //couples[i]表示id为i的顾客出现的情况
        int couples[]=new int[100000];
        //appear[i]表示id为i的顾客出现的情况
        int appear[] = new int[100000];
        for (int i = 0; i < 100000; i++) {
            couples[i]=-1;
            appear[i]=-1;
        }
        for (int i = 0; i < n; i++) {
            String[] s=br.readLine().split(" ");
            int wife=Integer.parseInt(s[0]);
            int husband=Integer.parseInt(s[1]);
            couples[wife]=husband;
            couples[husband]=wife;
        }
        int m=Integer.parseInt(br.readLine());
        String[] guest=br.readLine().split(" ");
        int minus=0;
        for (int i = 0; i < m; i++) {
            int g=Integer.parseInt(guest[i]);
            if(couples[g]!=-1){
                appear[couples[g]]=1;
            }
            if(couples[g]!=-1&&appear[couples[g]]==1&&appear[g]==1){
                minus+=2;
            }
        }
        Arrays.sort(guest);
        boolean flag=false;
        System.out.println(guest.length-minus);
        for (String s : guest) {
            int g = Integer.parseInt(s);
            if (appear[g] != 1) {
                if (flag) {
                    System.out.print(" " + s);
                } else {
                    System.out.print(s);
                    flag = true;
                }
            }
        }
    }
}
