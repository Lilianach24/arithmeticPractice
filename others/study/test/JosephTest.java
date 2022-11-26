package test;

public class JosephTest {
    /**
     * 节点类
     */
    private static class Node<T>{
        //存贮数据
        T data;
        //下一个节点
        Node next;
        public Node(T data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        //1.构建循环链表,包含41个结点
        //用来记录首结点
        Node<Integer> first = null;
        //用来记录前一个结点
        Node<Integer> pre=null;
        for (int i = 1; i <= 41; i++) {
            //如果是第一个结点
            if(i==1){
                first = new Node<>(i, null);
                pre=first;
                continue;
            }
            //如果不是第一个节点
            Node<Integer> newNode = new Node<>(i,null);
            pre.next=newNode;
            pre=newNode;
            //如果是最后一个节点,那么需要让最后一个结点的下一个结点变为first,变为循环链表了
            if(i==41){
                pre.next=first;
            }
        }
        //2.需要count计数器,模拟记数
        int count=0;
        //3.遍历循环链表
        //记录每次遍历拿到的结点,默认从首结点开始
        Node<Integer> n=first;
        //记录当前结点的上一个节点
        Node<Integer> before=null;
        while (n!=n.next){
            //模拟报数
            count++;
            //判断当前报数是不是为3
            if(count==3){
                //如果是3,则把当前节点删除调用,重置count=3,让当前节点n向后移
                before.next=n.next;
                System.out.print(n.data+",");
                count=0;
                n=n.next;
            }else {
                //如果不是3,让before变为当前节点,让当前节点后裔
                before=n;
                n=n.next;
            }
        }
        //打印最后一个元素
        System.out.println(n.data);
    }
}
