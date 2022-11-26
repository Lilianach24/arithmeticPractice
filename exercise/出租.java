package competition;

import java.io.*;
import java.util.*;

/**
 * 下面是新浪微博上曾经很火的一张图：
 *
 *
 *
 * 一时间网上一片求救声，急问这个怎么破。其实这段代码很简单，index数组就是arr数组的下标，index[0]=2 对应 arr[2]=1，index[1]=0 对应 arr[0]=8，index[2]=3 对应 arr[3]=0，以此类推…… 很容易得到电话号码是18013820100。
 *
 * 本题要求你编写一个程序，为任何一个电话号码生成这段代码 —— 事实上，只要生成最前面两行就可以了，后面内容是不变的。
 *
 * 输入格式：
 * 输入在一行中给出一个由11位数字组成的手机号码。
 *
 * 输出格式：
 * 为输入的号码生成代码的前两行，其中arr中的数字必须按递减顺序给出。
 *
 * 输入样例：
 * 18013820100
 * 输出样例：
 * int[] arr = new int[]{8,3,2,1,0};
 * int[] index = new int[]{3,0,4,3,1,0,2,4,3,4,4};
 */
class myCmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class 出租 {
    public static String toString(int[] a){
        StringBuilder s = new StringBuilder();
        s.append("new int[]{");
        for (int i = 0; ; i++) {
            s.append(a[i]);
            if(i == a.length - 1){
                return s.append("};").toString();
            }
            s.append(",");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //输入电话号码
        String telephone = bf.readLine();
        //存储电话号码中含有的数字
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < telephone.length(); i++) {
            int num = telephone.charAt(i) - '0';
            if(!list.contains(num)){
                list.add(num);
            }
        }
        //排序
        list.sort(new myCmp());
        //排好序之后将数据存入arr数组
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        //根据电话号码中每个数字所在的索引建立index数组
        int[] index = new int[telephone.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = list.indexOf(telephone.charAt(i) - '0');
        }
        //输出
        System.out.println("int[] arr = " + toString(arr));
        System.out.println("int[] index = " + toString(index));
    }
}
