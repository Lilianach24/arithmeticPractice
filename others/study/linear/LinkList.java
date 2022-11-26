package linear;


import java.util.Iterator;

/**
 * @author cl
 * 链表
 */
public class LinkList<T> implements Iterable<T>{
    /**
     * 记录头节点
     */
    private Node head;

    /**
     * 单链表结点泛型类
     */
    private class Node{
        //存储数据
        T item;
        //下一个节点
        Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }

        public Node(T t) {
            item=t;
            next=null;
        }
    }

    /**
     * 单链表泛型类
     */
    public LinkList(){
        //初始化头节点
        this.head = new Node(null,null);
        //头节点的next成员置为null,满足head.next==null;条件的单链表为一个空的单链表
        head.next=null;
    }

    /**
     * 整体建立单链表,通过一个含有n个元素的a数组来建立单链表
     *
     * 头插法:由数组a整体创建单链表
     * 创建出来的链表中结点的次序和原数组中元素的顺序相反
     */
    public void createListF(T[] a){
        Node s;
        //循环建立数据节点s
        for (T t : a) {
            //新建存放a[i]元素的结点s
            s = new Node(t);
            //将s结点插入开始结点之前,头节点之后
            s.next = head.next;
            head.next = s;
        }

    }
    /**
     * 尾插法:由数组a整体建立单链表
     * 创建出来的链表中结点的次序和原数组中元素的顺序相同
     */
    public void createListR(T[] a){
        Node s,t;
        //t始终指向尾结点,开始时指向头节点
        t=head;
        //循环建立数组节点
        for (T value : a) {
            //新建存放a[i]元素的结点s
            s = new Node(value);
            //将s结点插入t结点之后
            t.next = s;
            t = s;
        }
        //将尾结点的next成员置为null
        t.next=null;
    }

    /**
     * 清空链表
     */
    public void clear(){
        head.next=null;
    }

    /**
     * 获取链表的长度
     */
    public int size(){
        Node p=head;
        int cnt=0;
        //找到尾结点为止
        while (p.next!=null){
            cnt++;
            p=p.next;
        }
        return cnt;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * 将元素t添加到线性表的末尾
     */
    public void add(T t){
        //新建结点
        Node s=new Node(t);
        Node p=head;
        //查找尾结点p
        while(p.next!=null){
            p=p.next;
        }
        //在尾结点之后插入结点s
        p.next=s;
    }

    /**
     * 在单链表中查找序号为i的结点
     */
    private Node geti(int i){
        Node p=head;
        int j=-1;
        while (j<i){
            j++;
            p=p.next;
        }
        return p;
    }

    /**
     * 设置链表的长度
     */
    public void setSize(int nlen){
        int len=size();
        //当参数错误时,抛出异常
        if(nlen<0||nlen>len){
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        //当nlen等于单链表长度,直接返回
        if(nlen==len){
            return;
        }
        //否则找到序号为nlen-1的结点p
        Node p=geti(nlen-1);
        //将节点p置为尾结点
        p.next=null;
    }

    /**
     * 获取指定位置i处的元素
     */
    public T getElem(int i){
        int len=size();
        if(i<0||i>len){
            throw new IllegalArgumentException("查找:位置i不在有效范围之内");
        }
        //找到序号为i的结点p
        Node p=geti(i);
        return p.item;
    }

    /**
     * 设置线性表中序号为i的元素为t
     */
    public void setElem(int i,T t){
        if(i<0||i>size()-1){
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        Node p=geti(i);
        p.item=t;
    }

    /**
     * 寻找线性表中第一个值为t的元素逻辑序号
     */
    public int indexOf(T t){
        int j=0;
        Node p=head.next;
        while (p!=null&&!p.item.equals(t)){
            //查找元素t
            j++;
            p=p.next;
        }
        if(p==null){
            //未找到时返回-1
            return -1;
        }else {
            //找到返回序号
            return j;
        }
    }

    /**
     * 将线性表中序号为i和序号为j的元素交换
     */
    public void swap(int i,int j){
        Node p=geti(i);
        Node q=geti(j);
        T t=p.item;
        p.item=q.item;
        q.item=t;
    }

    /**
     * 在线性表中插入t作为第i个元素
     */
    public void insert(int i,T t){
        if(i<=0||i>size()){
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        //新建结点s
        Node s=new Node(t);
        //找到序号为i-1的结点
        Node p=geti(i-1);
        //在p节点后面插入s结点
        s.next=p.next;
        p.next=s;
    }

    /**
     * 在线性表中删除第i个元素
     */
    public void remove(int i) {
        if(i<0||i>size()){
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
        //找到序号为i-1的结点p
        Node p=geti(i-1);
        //删除p结点的后继节点
        p.next=p.next.next;
    }

    /**
     * 将线性表转换为字符串
     */
    @Override
    public String toString(){
        StringBuilder ans= new StringBuilder();
        Node p=head.next;
        while (p!=null){
            ans.append(p.item).append(" ");
            p=p.next;
        }
        return ans.toString();
    }

    /**
     * 实现链表的遍历
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }


    /**
     * 用来反转整个链表
     */
    public void reverse(){
        //判断当前节点是否为空链表,如果是空链表,则结束运行,如果不是,则调用重载的reverse方法完成反转
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }
    /**
     * 反转指定的结点s,并把反转后的节点返回
     */
    public Node reverse(Node s){
        if(s.next==null){
            head.next=s;
            return s;
        }
        //递归的反转当前节点s的下一个结点,返回值就是链表反转后,当前节点的上一个节点
        Node p=reverse(s.next);
        //让返回的结点的下一个节点变为当前节点s
        p.next=s;
        //把当前节点的下一个结点变为null
        s.next=null;
        return s;
    }
}
