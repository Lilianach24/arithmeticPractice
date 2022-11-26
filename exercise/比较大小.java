package competition;

import java.util.Scanner;

/**
 * 本题要求将输入的任意3个整数从小到大输出。
 *
 * 输入格式:
 * 输入在一行中给出3个整数，其间以空格分隔。
 *
 * 输出格式:
 * 在一行中将3个整数从小到大输出，其间以“->”相连。
 *
 * 输入样例:
 * 4 2 8
 * 输出样例:
 * 2->4->8
 */
public class 比较大小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
//        if(a < b){
//            if(c < a){
//                System.out.println(c + "->" + a + "->" + b);
//            }else {
//                if(c < b){
//                    System.out.println(a + "->" + c + "->" + b);
//                }else{
//                    System.out.println(a + "->" + b + "->" + c);
//                }
//            }
//        }else {
//            if(c < b){
//                System.out.println(c + "->" + b + "->" + a);
//            }else {
//                if(a < c){
//                    System.out.println(b + "->" + a + "->" + c);
//                }else{
//                    System.out.println(b + "->" + c + "->" + a);
//                }
//            }
//        }
    }
}
