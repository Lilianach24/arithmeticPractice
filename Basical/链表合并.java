package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个单链表 L1=a1→a2→⋯→an−1→an和 L2 =b1 →b2 →⋯→bm−1 →bm。如果 n≥2m，你的任务是将比较短的那个链表逆序，
 * 然后将之并入比较长的那个链表，得到一个形如 a1 →a2 →bm →a3 →a4 →bm−1 ⋯ 的结果。例如给定两个链表分别为 6→7 和 1→2→3→4→5，你应该输出 1→2→7→3→4→6→5。
 *
 * 输入格式：
 * 输入首先在第一行中给出两个链表 L 1  和 L2的头结点的地址，以及正整数
 * N (≤10^5)，即给定的结点总数。一个结点的地址是一个 5 位数的非负整数，空地址 NULL 用 -1 表示。
 *
 * 随后 N 行，每行按以下格式给出一个结点的信息：
 *
 * Address Data Next
 * 其中 Address 是结点的地址，Data 是不超过 10
 * 5
 *   的正整数，Next 是下一个结点的地址。题目保证没有空链表，并且较长的链表至少是较短链表的两倍长。
 *
 * 输出格式：
 * 按顺序输出结果链表，每个结点占一行，格式与输入相同。
 *
 * 输入样例：
 * 00100 01000 7
 * 02233 2 34891
 * 00100 6 00001
 * 34891 3 10086
 * 01000 1 02233
 * 00033 5 -1
 * 10086 4 00033
 * 00001 7 -1
 * 输出样例：
 * 01000 1 02233
 * 02233 2 00001
 * 00001 7 34891
 * 34891 3 10086
 * 10086 4 00100
 * 00100 6 00033
 * 00033 5 -1
 */
public class 链表合并 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String node1 = line[0];
        String node2 = line[1];
        int n = Integer.parseInt(line[2]);
        //将所有数据存入链表中
        List<Link> datas = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] data = bf.readLine().split(" ");
            datas.add(new Link(data[0], Integer.parseInt(data[1]), data[2]));
        }
        List<Link> list1 = new LinkedList<>();
        List<Link> list2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(node1.equals("-1") && node2.equals("-1")){
                break;
            }
            //匹配到相应的节点则加入链表中
            if(datas.get(i).node.equals(node1)){
                list1.add(datas.get(i));
                node1 = datas.get(i).next;
                datas.remove(datas.get(i));
                i = -1;
            } else if(datas.get(i).node.equals(node2)){
                list2.add(datas.get(i));
                node2 = datas.get(i).next;
                datas.remove(datas.get(i));
                i = -1;
            }
        }
        //如果list2的长度比list1的长度长，则交换两个链表中的元素
        if(list2.size() >= 2 * list1.size()){
            List<Link> tmp = new LinkedList<>(list1);
            list1 = new LinkedList<>(list2);
            list2 = new LinkedList<>(tmp);
        }
        int j = list2.size() - 1;
        System.out.println(list1.get(0).toString());
        for (int i = 1; i < list1.size(); i++) {
            if(i % 2 == 0){
                System.out.println(list1.get(i).toString());
            }else{
                list1.get(i).next = list2.get(j).node;
                System.out.println(list1.get(i).toString());
                if(i + 1 >= list1.size()){
                    list2.get(j).next = "-1";
                }else {
                    list2.get(j).next = list1.get(i+1).node;
                }
                System.out.println(list2.get(j).toString());
                j--;
            }
        }
    }
}
