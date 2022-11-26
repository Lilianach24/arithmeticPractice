package competition;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题的目标很简单，就是求两个正整数A和B的和，其中A和B都在区间[1,1000]。稍微有点麻烦的是，输入并不保证是两个正整数。
 *
 * 输入格式：
 * 输入在一行给出A和B，其间以空格分开。问题是A和B不一定是满足要求的正整数，有时候可能是超出范围的数字、负数、带小数点的实数、甚至是一堆乱码。
 *
 * 注意：我们把输入中出现的第1个空格认为是A和B的分隔。题目保证至少存在一个空格，并且B不是一个空字符串。
 *
 * 输出格式：
 * 如果输入的确是两个正整数，则按格式A + B = 和输出。如果某个输入不合要求，则在相应位置输出?，显然此时和也是?。
 *
 * 输入样例1：
 * 123 456
 * 输出样例1：
 * 123 + 456 = 579
 * 输入样例2：
 * 22. 18
 * 输出样例2：
 * ? + 18 = ?
 * 输入样例3：
 * -100 blabla bla...33
 * 输出样例3：
 * ? + ? = ?
 */
public class 正整数AaddB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        //找出第一个空格出现的位置
        int st = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                st = i;
                break;
            }
        }
        //分离出整数a和b
        String a = str.substring(0,st);
        String b = str.substring(st + 1);
        //指定匹配模式
        String pattern = "^\\d{1,3}$";
        //创建pattern对象
        Pattern r = Pattern.compile(pattern);
        //创建matcher对象
        Matcher m1 = r.matcher(a);
        Matcher m2 = r.matcher(b);
        //处理a和b, 题目保证b不是空字符串,但没保证a不是空字符串
        if(!"1000".equals(a) && !"".equals(a)){
            //匹配不符合规范的整数
            if(!m1.matches()){
                a = "?";
            }
        }
        //当a为空字符串,以及a为0都是不符合条件的
        if("".equals(a) || "0".equals(a)){
            a = "?";
        }
        if(!"1000".equals(b)){
            if(!m2.matches()){
                b = "?";
            }
        }
        if("0".equals(b)){
            b = "?";
        }
        //计算a和b的和
        if("?".equals(a) || "?".equals(b)){
            System.out.printf("%s + %s = ?", a, b);
        }else {
            int num1 = Integer.parseInt(a);
            int num2 = Integer.parseInt(b);
            System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
        }
    }
}
