package 寒假百校真题大联赛;

import java.util.Arrays;

/**
 * 本题为填空题，只需要算出结果后，在代码中使用输出语句将所填结果输出即可。
 *
 * 2,3,5,7,11,13,....是素数序列。 类似：7,37,67,97,127,157这样完全由素数组成的等差数列，叫等差素数数列。
 *
 * 上边的数列公差为 30，长度为 66。
 *
 * 2004年，格林与华人陶哲轩合作证明了：存在任意长度的素数等差数列。 这是数论领域一项惊人的成果！
 *
 * 有这一理论为基础，请你借助手中的计算机，满怀信心地搜索：
 *
 * 长度为 1010 的等差素数列，其公差最小值是多少？
 */
public class 等差素数列 {
    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //素数数组
        int[] arr=new int[10000];
        int j=0;
        for (int i = 2; i < 50000; i++) {
            //首先判断这个数是否为素数
            if(isPrime(i)){
                arr[j]=i;
                j++;
            }
        }
        //寻找长度为10的等差数列
        //枚举公差
        for (int d = 1; d < 10000; d++) {
            //枚举首项
            for (int a = 0; a < 10000; a++) {
                int a1=arr[a];
                //枚举长度
                for (int i = 0; i < 10; i++) {
                    int i1=Arrays.binarySearch(arr,a1+i*d);
                    //不是等差数列
                    if(i1<i){
                        break;
                    }
                    //是长度为10的等差数列
                    if(i==9&&i1>i){
                        System.out.println(d);
                    }
                }
            }
        }
    }
}
