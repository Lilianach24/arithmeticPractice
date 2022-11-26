package linear;

import java.util.Iterator;

/**
 * @author cl
 * 双链表
 */
public class TwoWayLinkList<T> implements Iterable<T>{
    /**
     * 头结点
     */
    private DNode dhead;
    /**
     * 尾结点
     */
    private DNode last;
    /**
     * 元素的个数
     */
    private int size;

    /**
     * 结点的泛型类
     */
    private class DNode{
        //结点元素值
        T data;
        //前驱结点指针
        DNode prior;
        //后继节点指针
        DNode next;
        //构造方法
        public DNode(T data,DNode prior,DNode next){
            this.data=data;
            this.prior=prior;
            this.next=next;
        }
        //重载构造方法
        public DNode(T t){
            data=t;
            prior=null;
            next=null;
        }
    }

    /**
     * 双链表泛型类
     * 线性表的基本运算算法
     */
    public TwoWayLinkList(){
        //初始化头节点和尾结点
        this.dhead=new DNode(null,null,null);
        this.last=null;
        //初始化元素个数
        this.size=0;
    }

    /**
     * 整体建立双链表
     * 用一个数组的所有元素创建一个双链表
     * 头插法:每次都是将新节点s插入表头
     */
    public void createListF(T[] a){
        DNode s;
        //循环建立数据节点s
        for (T t : a) {
            //新建存放a[i]元素的结点s,将其插入表头
            s = new DNode(t);
            //修改s结点的next成员
            s.next = dhead.next;
            //修改头结点的非空后继节点的prior成员
            if (dhead.next != null) {
                dhead.next.prior = s;
            }
            //修改头结点的next成员
            dhead.next = s;
            //修改s结点的prior成员
            s.prior = dhead;
        }
    }
    /**
     * 尾插法
     */
    public void createListR(T[] a){
        DNode s,t;
        //t始终指向尾结点,开始时指向头节点
        t=dhead;
        //循环建立数据节点s
        for (T value : a) {
            //新建存放a[i]元素的结点s
            s = new DNode(value);
            //将s结点插入t结点之后
            t.next = s;
            s.prior = t;
            t = s;
        }
        //将尾结点的next成员设置为null
        t.next=null;
    }

    /**
     * 清空链表
     */
    public void clear(){
        this.dhead.next=null;
        this.dhead.prior=null;
        this.dhead.data=null;
        this.last=null;
        this.size=0;
    }

    /**
     * 获取链表长度
     */
    public int size(){
        return size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 获取第一个元素
     */
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return dhead.next.data;
    }

    /**
     * 获取最后一元素
     */
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.data;
    }

    /**
     * 查找序号为i的结点
     */
    private DNode geti(int i){
        DNode p=dhead;
        int j=-1;
        while (j<i){
            j++;
            p=p.next;
        }
        return p;
    }

    /**
     * 添加元素
     */
    public void add(T t){
        //如果链表为空
        if(isEmpty()){
            //创建新节点
            //让新节点成为尾结点
            last= new DNode(t);
            //让头节点指向尾结点
            dhead.next=last;
        }
        //链表不为空
        //记录当前尾结点
        DNode p=last;
        //创建新节点
        DNode s=new DNode(t,p,null);
        //让当前尾结点指向新节点
        p.next=s;
        //让新节点成为尾结点
        last=s;

        //元素个数加一
        size++;
    }

    /**
     * 向指定位置插入元素
     */
    public void insert(int i,T t){
        //参数错误抛出异常
        if(i<0||i>size()){
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        //新建结点s
        DNode s=new DNode(t);
        //找到序号为i-1的结点p,在其后插入s结点
        DNode p=geti(i-1);
        //修改s结点的next成员
        s.next=p.next;
        //修改p结点的非空后继节点的prior成员
        if(p.next!=null){
            p.next.prior=s;
        }
        //修改p结点的next成员
        p.next=s;
        //修改s结点的prior成员
        s.prior=p;
        //元素个数+1
        size++;
    }

    /**
     * 删除序号为i的结点
     */
    public void remove(int i){
        if(i<0||i>size()-1){
            throw new IllegalArgumentException("删除:位置i不再有效范围内");
        }
        //找到序号为i的结点p,删除该节点
        DNode p=geti(i-1);
        //修改p结点的非空后继结点的prior成员
        /*if(p.next!=null){
            p.next.prior=p.prior;
        }*/
        p.next=p.next.next;
        //修改p结点的非空前驱节点的next成员
        /*if(p.prior==null){
            p.prior.next=p.next;
        }*/
        p.next.next.prior=p;
        //元素-1
        size--;
    }

    /**
     * 获取指定位置i处的元素
     */
    public T getElem(int i){
        if(i<0||i>size()-1){
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        //找到序号为i的结点p
        DNode p=geti(i);
        return p.data;
    }

    /**
     * 设置线性表的长度
     */
    public void setSize(int nlen){
        int len=size();
        if(nlen<0||nlen>len){
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        if(nlen==len){
            return;
        }
        //找到序号为nlen-1的结点
        DNode p=geti(nlen-1);
        //将结点p设置为尾结点
        p.next=last;
    }

    /**
     * 设置线性表中序号为i的元素
     */
    public void setElem(int i,T t){
        if(i<0||i>size()-1){
            throw new IllegalArgumentException("设置:元素i不再有效范围");
        }
        DNode p=geti(i);
        p.data=t;
    }

    /**
     * 找到线性表中第一个值为t的元素序号
     */
    public int indexOf(T t){
        int j=0;
        DNode p=dhead.next;
        //查找
        while(p!=null&&!p.data.equals(t)){
            j++;
            p=p.next;
        }
        //未找到返回-1
        if(p==null){
            return -1;
        }
        return j;
    }


    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{

        private DNode n;
        public TIterator(){
            this.n=dhead;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.data;
        }
    }
}
