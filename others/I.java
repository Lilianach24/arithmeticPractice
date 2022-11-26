package Unit1;

import java.util.*;

/**
 * 团队队列问题
 */
public class I {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义一个队列
        Queue<String> qu=new LinkedList<String>();
        while (sc.hasNext()){
            //输入团队数量
            int t=sc.nextInt();
            //当t为0时终止
            if(t==0){
                break;
            }
            //输入团队描述:队员数,队员本身
            int n=sc.nextInt();
            for (int i = 0; i < n; i++) {
                //队员入队
                qu.offer(sc.next());
            }
        }
    }
}
