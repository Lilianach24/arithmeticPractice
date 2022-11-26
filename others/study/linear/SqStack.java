package linear;

/**
 * @author cl
 * 顺序栈
 */
public class SqStack<T> {
    /**
     * 顺序栈的初始容量
     */
    final int initcapacity = 10;
    /**
     * 存放顺序栈的容量
     */
    private int capacity;
    /**
     * 存放顺序栈中的元素
     */
    private T[] data;
    /**
     * 存放栈顶指针
     */
    private int top;

    /**
     * 构造方法,实现data和top的初始化
     */
    public SqStack(){
        data = (T[]) new Object[initcapacity];
        capacity = initcapacity;
        top = -1;
    }

    /**
     * 改变顺序栈的容量
     */
    private void updateCapacity(int newcapacity){
        T[] newdata= (T[]) new Object[newcapacity];
        //复制原来的元素
        for (int i = 0; i < top; i++) {
            newdata[i]=data[i];
        }
        //设置新容量
        capacity=newcapacity;
        //仍由data标识数组
        data=newdata;
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 进栈
     * 元素进栈只能从栈顶进入,在进栈中,栈满时倍增容量
     */
    public void push(T t){
        //栈满时倍增容量
        if(top==capacity-1){
            updateCapacity(2*(top+1));
        }
        //栈顶指针加1
        top++;
        data[top]=t;
    }

    /**
     * 出栈
     * 出栈只能从栈顶出,在出栈中,栈空抛出异常,栈容量大于初始容量且实际元素个数仅为当前容量的四分之一时容量减半
     */
    public T pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("栈空");
        }
        T t=data[top];
        top--;
        if(capacity>initcapacity&&top+1==capacity/4){
            updateCapacity(capacity/2);
        }
        return t;
    }

    /**
     * 取栈顶元素
     */
    public T peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("栈空");
        }
        return data[top];
    }
}
