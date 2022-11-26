package basicLevel;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个常数 K 以及一个单链表 L，请编写程序将 L 中每 K 个结点反转。例如：给定 L 为 1→2→3→4→5→6，K 为 3，则输出应该为 3→2→1→6→5→4；如果 K 为 4，则输出应该为 4→3→2→1→5→6，即最后不到 K 个元素不反转。
 *
 * 输入格式：
 * 每个输入包含 1 个测试用例。每个测试用例第 1 行给出第 1 个结点的地址、结点总个数正整数 N (≤10
 * 5
 *  )、以及正整数 K (≤N)，即要求反转的子链结点的个数。结点的地址是 5 位非负整数，NULL 地址用 −1 表示。
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
 * 00100 6 4
 * 00000 4 99999
 * 00100 1 12309
 * 68237 6 -1
 * 33218 3 00000
 * 99999 5 68237
 * 12309 2 33218
 * 输出样例：
 * 00000 4 33218
 * 33218 3 12309
 * 12309 2 00100
 * 00100 1 99999
 * 99999 5 68237
 * 68237 6 -1
 */
class Node{
    String node;
    int val;
    String next;
    public Node(){}
    public Node(String node, int val, String next){
        this.node = node;
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString(){
        return node + " " + val + " " + next;
    }
}
public class 反转链表 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        String address = line[0];
        int n = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);
        List<Node> list = new LinkedList<>();
        //先将数据放到按照顺序放到其位置上
        List<Node> datas = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] st = bf.readLine().split(" ");
            datas.add(new Node(st[0], Integer.parseInt(st[1]), st[2]));
        }
        for (int i = 0; i < datas.size(); i++) {
            if(datas.get(i).node.equals(address)){
                list.add(datas.get(i));
                address = datas.get(i).next;
                datas.remove(datas.get(i));
                i = -1;
            }
        }
        //将节点中的值按照题目要求反转
        for (int i = 0; i < n / k; i++) {
            for (int j = k - 1; j >= 0; j--) {
                datas.add(list.remove(j));
            }
        }
        if(list.size() > 0){
            datas.addAll(list);
        }
        //输出
        String pre = "-1";
        for (int i = datas.size() - 1; i >= 0; i--) {
            datas.get(i).next = pre;
            pre = datas.get(i).node;
        }
        for (Node data : datas) {
            System.out.println(data.toString());
        }
    }
}
