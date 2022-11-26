package linear;

import org.omg.CORBA.Object;

/**
 * @author cl
 * 对循环队列来说,如果知道队头指针和队中元素个数,则可以计算出队尾指针,也就是说可以用队中元素个数代替队尾指针.
 */
public class CSqQueue2<T> {
    /**
     * 假设容量为100
     */
    final int MaxSize=100;
    /**
     * 存放队列中的元素
     */
    private T[] data;
    /**
     * 队头指针
     */
    private int front;
    /**
     * 元素个数
     */
    private int count;
    /**
     * 构造放法
     */
    public CSqQueue2(){
        data= (T[]) new Object[MaxSize];
        front=0;
        count=0;
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty(){
        return count==0;
    }

    /**
     * 元素t进队
     */
    public void push(T t){
        int rear1;
        rear1=(front+count)%MaxSize;
        if(count==MaxSize){
            throw new IllegalArgumentException("队满");
        }
        rear1=(rear1+1)%MaxSize;
        data[rear1]=t;
        count++;
    }

    /**
     * 出队元素
     */
    public T pop(){
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
        count--;
        front=(front+1)%MaxSize;
        return data[front];
    }

    /**
     * 取队头元素
     */
    public T peek(){
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
        return data[(front+1)%MaxSize];
    }
}
