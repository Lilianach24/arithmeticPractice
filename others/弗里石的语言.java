package 寒假百校真题大联赛;

import java.util.HashMap;
import java.util.Scanner;

public class 弗里石的语言 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<String, Boolean> map=new HashMap<String, Boolean>();
        boolean flag=false;
        for(int i=0;i<=n;i++) {
            String word=sc.nextLine();
            if(map.containsKey(word)) {
                System.out.println(word);
                flag=true;
            }else {
                map.put(word,true);
            }

        }
        if(!flag) {
            System.out.println("NO");
        }
    }
}
