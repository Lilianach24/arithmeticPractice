package Unit1;

import java.util.ArrayList;
import java.util.Scanner;

public class DJoseph {
    public static int Joseth(int k){
        //1.构建循环链表,包含2*k个结点,分别存储1-2*k的值
        //t指向新建循环单链表的尾结点
        int n=2*k;
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        //记录首结点
        ArrayList<Integer> first=null;
        ArrayList<Integer> last;
        //构成一个首结点为first的循环单链表

        //2.寻找最小的m的值
        //默认从头开始
        for (int m = k+1;; m++) {
            int count=0;
            while (n>k){
                count++;
                if(count==m){
//                    first.next= first.next.next;
                    n--;
                }
                if(n==k){
                    return m;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int k=sc.nextInt();
            if(k==0){
                break;
            }
            System.out.println(Joseth(k));
        }
    }
}
