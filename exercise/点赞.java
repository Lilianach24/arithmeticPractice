package competition;

import java.io.*;

/**
 * 微博上有个“点赞”功能，你可以为你喜欢的博文点个赞表示支持。每篇博文都有一些刻画其特性的标签，而你点赞的博文的类型，也间接刻画了你的特性。本题就要求你写个程序，通过统计一个人点赞的纪录，分析这个人的特性。
 *
 * 输入格式：
 * 输入在第一行给出一个正整数N（≤1000），是该用户点赞的博文数量。随后N行，每行给出一篇被其点赞的博文的特性描述，格式为“K F1⋯FK”，其中1≤K≤10，Fi (i=1,⋯,K）是特性标签的编号，我们将所有特性标签从1到1000编号。数字间以空格分隔。
 *
 * 输出格式：
 * 统计所有被点赞的博文中最常出现的那个特性标签，在一行中输出它的编号和出现次数，数字间隔1个空格。如果有并列，则输出编号最大的那个。
 *
 * 输入样例：
 * 4
 * 3 889 233 2
 * 5 100 3 233 2 73
 * 4 3 73 889 2
 * 2 233 123
 * 输出样例：
 * 233 3
 */

public class 点赞 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //将文章的特性标签的编号作为数组的下标,然后存储下标出现的个数
        int[] count = new int[1001];
        while (n > 0){
            String[] line = bf.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            //存储下标出现的个数
            for (int i = 1; i <= k; i++) {
                count[Integer.parseInt(line[i])]++;
            }
            n--;
        }
        //使用双指针查找最大值,找出左边的最大值和右边的最大值,然后比较两个数,输出较大的数,若两数相等,则输出右边的数
        //左右两个指针
        int start = 0, end = count.length - 1;
        //找出最大值
        int max = count[start];
        //记录最大值的位置
        int tags = 0;
        while(start < end){
            //如果有并列的, 则输出编号大的
            if(count[start] >= max){
                max = count[start];
                tags = start;
            }
            if(count[end] > max){
                max = count[end];
                tags = end;
            }
            if(count[start] == count[end] && count[start] != 0){
                max = count[end];
                tags = end;
            }
            start++;
            end--;
        }

        System.out.println(tags + " " + max);
    }
}
