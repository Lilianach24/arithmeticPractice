package 寒假百校真题大联赛;

/**
 * 求1个整数的第k位数字有很多种方法。 以下的方法就是一种。
 *
 * 请仔细分析源码，填写划线部分缺少的内容。
 */

import java.util.*;
public class 取位数
{
    static int len(int x){
        if(x<10) {
            return 1;
        }
        return len(x/10)+1;
    }

    // 取x的第k位数字
    static int f(int x, int k){
        if(len(x)-k==0) {
            return x%10;
        }
        return  f(x/10,k);
    }

    public static void main(String[] args)
    {
        int x = 23513;
        //System.out.println(len(x));
        System.out.println(f(x,3));
        System.out.println(f(893275,2));
    }
}
