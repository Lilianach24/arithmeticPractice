package Unit1;

import java.util.Scanner;

/**
 * 约瑟夫的问题是众所周知的。对于那些不熟悉原问题的人:在n个人中，1 2…，n，每m个站在圆圈里的人将被处决，只有最后一个人的生命将被拯救。
 * 约瑟夫很聪明地选择了最后一个人的位置，从而救了他的命，给了我们关于这件事的信息。例如，当n = 6 m = 5时，将按照5、4、6、2、3和1的顺
 * 序执行。
 *
 * 假设有k个好人和k个坏人。在这个圆中，前k个是好人，后k个是坏人。你必须确定最小的m使所有的坏人都在第一个好人之前被处决。
 * Input
 * The input file consists of separate lines containing k. The last line in the input file contains 0. You can suppose that 0 < k < 14.
 * Output
 * The output file will consist of separate lines containing m corresponding to k in the input file.
 */
public class D {
    //储存k的值
    public static int[] ans = new int[14];
    public static int Joseph(int k){
        //分别表示剩余的人数,和被杀人员序号
        int rest,p;
        if(ans[k]!=0){
            return ans[k];
        }
        for (int m = k+1;; m++) {
            for (rest = 2*k,p=0; rest > k; rest--) {
                p=(p+m-1)%rest;
                //如果p<k,则p是好人
                if(p<k){
                    //p为好人时重置剩余的人为0,结束m的枚举
                    rest=0;
                }
            }
            //剩下k个人,且k个人都为好人
            if(rest==k){
                //则返回这样的m值
                ans[k]=m;
                return m;
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
            System.out.println(Joseph(k));
        }
    }
}
