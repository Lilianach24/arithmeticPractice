package 寒假百校真题大联赛;

import java.util.Scanner;

/**
 * 小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。 小蓝准备用这些卡片来拼一些数，他想从 1 开始拼出正整数，每拼一个， 就保存起来，卡
 * 片就不能用来拼其它数了。 小蓝想知道自己能从 1 拼到多少。 例如，当小蓝有 30 张卡片，其中 0 到 9 各 3 张，则小蓝可以拼出 1 到 10，
 * 但是拼 11 时卡片 1 已经只有一张了，不够拼出 11。 现在小蓝手里有 0 到 9 的卡片各 2021
 * 张，共 20210 张，请问小蓝可以从 1 拼到多少？
 */
public class 卡片 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        boolean flag=true;
        int i=1,j;
        int num=0;
        while(flag){
            j=i;
            while(j>0){
                if(j%10==1){
                    num++;
                }
                j/=10;
            }
            if(num>=2021){
                System.out.println(i);
                flag=false;
            }
            i++;
        }
        scan.close();
    }
}
