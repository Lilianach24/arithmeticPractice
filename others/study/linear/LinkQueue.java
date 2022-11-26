package linear;

/**
 * 队列的链式存储结构
 */

/**
 * 链队结点泛型类
 */
class LinkNode<T>{
    T data;
    LinkNode<T> next;
    public LinkNode(){
        next=null;
    }
    public LinkNode(T t){
        data=t;
        next=null;
    }
}
public class LinkQueue<T> {
    /**
     * 首结点指针
     */
    LinkNode<T> front;
    /**
     * 尾结点指针
     */
    LinkNode<T> rear;
    /**
     * 构造方法
     */
    public LinkQueue(){
        front=null;
        rear=null;
    }

    /**
     * 判断队列是否为空:
     * 若链队的结点rear域值为null,则表示队列为空,返回true,否则返回false
     */
    public boolean empty(){
        return front==null;
    }

    /**
     * 进队:
     * 创建存放e的结点s,若原队列为空,则将front和rear指向s结点,否则将s结点连接到单链表的末尾,并让rear指向它
     */
    public void push(T t){
        //创建新节点s
        LinkNode<T> s=new LinkNode<T>(t);
        //原链队为空
        if(empty()){
            front=rear=s;
        }
        //原链队不为空
        else {
            //将s结点链接到rear的后面
            rear.next=s;
            rear=s;
        }
    }

    /**
     * 出队:
     * 若原队为空,抛出异常;若队中只有一个节点(此时front和rear都指向该结点),取首结点的data值赋给t,并删除,即置fornt=rear=null;
     * 否则说明有多个节点,取首结点的data值赋给t,并删除.最后返回t
     */
    public T pop(){
        T t;
        //原链队为空
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
        //原链队只有一个结点
        if(front==rear){
            //取首结点的值
            t=front.data;
            //置为空
            front=rear=null;
        }
        //原链队有多个节点
        else {
            t=front.data;
            front=front.next;
        }
        return t;
    }

    /**
     * 取队头元素
     */
    public T peek(){
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
        return front.data;
    }
}
