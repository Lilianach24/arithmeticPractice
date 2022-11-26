package test2;

import java.io.*;

/**
 * “单身狗”是中文对于单身人士的一种爱称。本题请你从上万人的大型派对中找出落单的客人，以便给予特殊关爱。
 *
 * 输入格式：
 * 输入第一行给出一个正整数 N（≤50000），是已知夫妻/伴侣的对数；随后 N 行，每行给出一对夫妻/伴侣——为方便起见，每人对应一个 ID 号，
 * 为 5 位数字（从 00000 到 99999），ID 间以空格分隔；之后给出一个正整数 M（≤10000），为参加派对的总人数；随后一行给出这 M 位客人的
 * ID，以空格分隔。题目保证无人重婚或脚踩两条船。
 *
 * 输出格式：
 * 首先第一行输出落单客人的总人数；随后第二行按 ID 递增顺序列出落单的客人。ID 间用 1 个空格分隔，行的首尾不得有多余空格。
 */
public class 单身狗 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        //输入夫妻的对数
        int n= Integer.parseInt(bf.readLine());
        //存储夫妻的id号
        int[] couple=new int[100000];
    }
}
