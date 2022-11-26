package basicLevel;

import java.io.*;

/**
 * 输入两个非负 10 进制整数 A 和 B (≤2^30−1)，输出 A+B 的 D (1<D≤10)进制数。
 *
 * 输入格式：
 * 输入在一行中依次给出 3 个整数 A、B 和 D。
 *
 * 输出格式：
 * 输出 A+B 的 D 进制数。
 *
 * 输入样例：
 * 123 456 8
 * 输出样例：
 * 1103
 */
public class D进制的AaddB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int d = Integer.parseInt(line[2]);
        int sum = a + b;
//        Integer.toOctalString(sum);
        if(sum == 0){
            System.out.println(0);
        }else{
            StringBuilder sb = new StringBuilder();
            while(sum > 0){
                sb.append(sum % d);
                sum /= d;
            }
            System.out.println(sb.reverse().toString());
        }

    }
}
