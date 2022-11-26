package linear;

import org.omg.CORBA.Object;

/**
 * @author cl
 * 非循环队列:存在假溢出情况
 */
public class SqQueue<T> {
    /**
     * 假设容量为100
     */
    final int MaxSize=100;
    /**
     * 存放队列中的元素
     */
    private T[] data;
    /**
     * 队头,队尾指针
     */
    private int front,rear;
    public SqQueue(){
        data= (T[]) new Object[MaxSize];
        front=-1;
        rear=-1;
    }

    /**
     * 判断列表是否为空
     */
    public boolean empty(){
        return front==rear;
    }

    /**
     * 进队运算
     */
    public void push(T t){
        if(rear==MaxSize-1){
            throw new IllegalArgumentException("队满");
        }
        rear++;
        data[rear]=t;
    }

    /**
     * 出队
     */
    public T pop(){
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
        front++;
        return data[front];
    }

    /**
     * 取队头元素
     */
    public T peek(){
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
        return data[front++];
    }
}
