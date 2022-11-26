package linear;

/**
 * @author cl
 * 循环队列
 */
public class CSqQueue<T> {
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
    public CSqQueue(){
        data= (T[]) new Object[MaxSize];
        front=0;
        rear=0;
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty(){
        return front==rear;
    }

    /**
     * 进队: 在队不满时,先将队尾指针rear循环曾1,然后将元素t放到该位置处,否则抛出异常
     */
    public void push(T t){
        if((rear+1)%MaxSize==front){
            throw new IllegalArgumentException("队满");
        }
        rear=(rear+1)%MaxSize;
        data[rear]=t;
    }

    /**
     * 出队 : 在队不满时,将队头指针front循环曾1,并返回该位置的元素值
     */
    public T pop(){
        if(empty()){
            throw new IllegalArgumentException("队空");
        }
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

    /**
     * 计算队中元素的个数
     */
    public int size(){
        return ((rear-front+MaxSize)%MaxSize);
    }

    /**
     * 进队第k个元素e
     */
    public static boolean pushk(CSqQueue<Integer> qu,int k,Integer e){
        Integer x;
        int n=qu.size();
        if(k<1||k>n+1){
            return false;
        }
        //循环处理队中的所有元素
        if(k<=n){
            for (int i = 1; i <= n; i++) {
                if(i==k){
                    //将e元素进队到第k个位置
                    qu.push(e);
                }
                //出队元素x
                x=qu.pop();
                //进队元素x
                qu.push(x);
            }
        }
        //k=n+1时直接进队
        else {
            qu.push(e);
        }
        return true;
    }

    /**
     * 出队第k个元素
     */
    public static Integer popk(CSqQueue<Integer> qu,int k){
        Integer x,e=0;
        int n=qu.size();
        if(k<1||k>n){
            throw new IllegalArgumentException("参数错误");
        }
        //循环处理队中所有元素
        for (int i = 1; i <= n; i++) {
            //出队元素x
            x=qu.pop();
            if(i!=k){
                //将非第k个元素进队
                qu.push(x);
            }
            //取第k个出队的元素
            else {
                e=x;
            }
        }
        return e;
    }
}
