package com.company.basical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单链表 L，我们将每 K 个结点看成一个区块（链表最后若不足 K 个结点，也看成一个区块），请编写程序将 L 中所有区块的链接反转。例如：给定 L 为 1→2→3→4→5→6→7→8，K 为 3，则输出应该为 7→8→4→5→6→1→2→3。
 *
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例第 1 行给出第 1 个结点的地址、结点总个数正整数 N (≤10
 * 5
 *  )、以及正整数 K (≤N)，即区块的大小。结点的地址是 5 位非负整数，NULL 地址用 −1 表示。
 *
 * 接下来有 N 行，每行格式为：
 *
 * Address Data Next
 * 其中 Address 是结点地址，Data 是该结点保存的整数数据，Next 是下一结点的地址。
 *
 * 输出格式：
 * 对每个测试用例，顺序输出反转后的链表，其上每个结点占一行，格式与输入相同。
 *
 * 输入样例：
 * 00100 8 3
 * 71120 7 88666
 * 00000 4 99999
 * 00100 1 12309
 * 68237 6 71120
 * 33218 3 00000
 * 99999 5 68237
 * 88666 8 -1
 * 12309 2 33218
 * 输出样例：
 * 71120 7 88666
 * 88666 8 00000
 * 00000 4 99999
 * 99999 5 68237
 * 68237 6 00100
 * 00100 1 12309
 * 12309 2 33218
 * 33218 3 -1
 */

class Link{
    String node;
    int val;
    String next;
    public Link(String node, int val, String next){
        this.node = node;
        this.val = val;
        this.next = next;
    }
    public String toString(){
        return node + " " + val + " " + next;
    }
}
public class 区块反转 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String node = line[0];
        int n = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        //将所有数据存储在链表中
        List<Link> datas = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] data = bf.readLine().split(" ");
            datas.add(new Link(data[0], Integer.parseInt(data[1]), data[2]));
        }
        //存储区块
        List<List<Link>> block = new LinkedList<>();
        //存储区块中的链表
        List<Link> list = new LinkedList<>();
        //记录链的个数
        int count = 0;
        for(int i = 0; i < n; i++){
            //-1 地址结束
            if(node.equals("-1")){
                break;
            }
            //匹配到相应的下一个节点的地址就加入链表中，链表中的个数为k个时作为区块加入区块链表中
            if(datas.get(i).node.equals(node)){
                list.add(datas.get(i));
                node = datas.get(i).next;
                datas.remove(datas.get(i));
                i = -1;
                count++;
                if(count == k){
                    block.add(list);
                    list = new LinkedList<>();
                    count = 0;
                }
            }
        }
        //将剩余的不足k个节点的链表也加到区块中
        if(!list.isEmpty()){
            block.add(list);
        }
        //倒序输出区块
        for (int i = block.size() - 1; i >= 0; i--) {
            //获取上一个区块中第一个链的node节点，作为此区块中链表的最后一个链的next节点
            String next;
            if(i == 0){
                next = "-1";
            }else{
                next = block.get(i - 1).get(0).node;
            }
            block.get(i).get(block.get(i).size() - 1).next = next;
            for (int j = 0; j < block.get(i).size(); j++) {
                System.out.println(block.get(i).get(j).toString());
            }
        }
    }
}
