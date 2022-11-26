package linear;

/**
 * @author cl
 * 链栈
 */
public class LinkStack<E> {
    /**
     * 存放头节点
     */
    LinkNode<E> head;

    /**
     * 链栈结点泛型类
     */
    private class LinkNode<E>{
        E data;
        LinkNode<E> next;
        //构造方法
        public LinkNode(){
            next = null;
        }
        //重载构造方法
        public LinkNode(E e){
            data = e;
            next = null;
        }
    }
    /**
     * 链栈泛型类
     */
    public LinkStack(){
        //创建头节点
        head=new LinkNode<E>();
        //设置为空栈
        head.next=null;
    }

    /**
     * 判断是否为空栈
     */
    public boolean isEmpty(){
        return head.next==null;
    }

    /**
     * 进栈:新建包含数据元素e的结点p,将p结点插入头节点之后
     */
    public void push(E e){
        //新建结点s
        LinkNode<E> s=new LinkNode<E>(e);
        //将结点s插入表头
        s.next=head.next;
        head.next=s;
    }

    /**
     * 出栈:在链栈空时抛出异常,否则将首结点的数据域给e,然后将其删除
     */
    public E pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("栈空");
        }
        //取首结点值
        E e=head.next.data;
        //删除原首结点
        head.next=head.next.next;
        return e;
    }

    /**
     * 取栈顶元素
     */
    public E peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("栈空");
        }
        //取首结点值
        return head.next.data;
    }
}
