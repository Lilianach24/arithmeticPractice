package Unit1;

import java.util.*;

/**
 * 有n(n<=100)个整数，已经按照从小到大顺序排列好，现在另外给一个整数x，请将该数插入到序列中，并使新的序列仍然有序。
 * Input
 * 输入数据包含多个测试实例，每组数据由两行组成，第一行是n和m，第二行是已经有序的n个数的数列。n和m同时为0标示输入数据的结束，本行不做处理。
 * Output
 * 对于每个测试实例，输出插入新的元素后的数列。
 */
public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            if(n==0&&m==0){
                break;
            }
            ArrayList<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            list.add(m);
            Collections.sort(list);
            for (int i=0;i<list.size();i++) {
                if(i==list.size()-1){
                    System.out.println(list.get(i));
                }else {
                    System.out.print(list.get(i)+" ");
                }
            }
        }
    }
}
