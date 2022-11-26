package linear;

import java.util.Iterator;

/**
 * @author cl
 * 顺序表的实现和遍历
 */
public class SequenceList<T> implements Iterable{
    /**
     * 顺序表的初始容量
     */
    final int initcapacity=10;
    /**
     * 存储元素的数组
     */
    private T[] eles;
    /**
     * 记录当前表中的元素的个数
     */
    private int size;
    /**
     * 存放顺序表的容量
     */
    private int capacity;


    /**
     * 构造方法
     */
    public SequenceList(){
        //初始化数组
        this.eles= (T[]) new Object[initcapacity];
        //初始化长度
        capacity=initcapacity;
        this.size=0;
    }

    /**
     * 根据参数newcapacity,重置eles的容量
     */
    public void updateCapacity(int newcapacity){
        //创建新数组
        T[] temp= (T[]) new Object[newcapacity];
        //把原数组的数据拷贝到新数组即可
        for (int i = 0; i < size; i++) {
            temp[i]=eles[i];
        }
        capacity=newcapacity;
        eles=temp;
    }

    /**
     * 整体创建顺序表,将数组a的全部元素整体创建顺序表
     */
    public void createList(T[] a){
        size=0;
        for (T t : a) {
            if (size == capacity) {
                updateCapacity(2 * size);
            }
            eles[size] = t;
            size++;
        }
    }

    /**
     * 向线性表末尾添加元素t
     */
    public void add(T t){
        //出现上溢时对数组进行扩容
        if(size==capacity){
            updateCapacity(2*size);
        }
        eles[size]=t;
        size++;
    }

    /**
     * 将一个线性表设置为空表
     */
    public void clear(){
        this.size=0;
    }

    /**
     * 判断当前线性表是否为空表
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 获取线性表的长度
     */
    public int size(){
        return size;
    }

    /**
     * 设置线性表的长度,主要用于缩小线性表的长度
     */
    public void setSize(int nlen){
        //当参数nlen正确时设置长度为nlne,否则抛出异常
        if(nlen<0||nlen>size){
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        }
        size=nlen;
    }

    /**
     * 获取指定位置的元素
     */
    public T getElem(int i){
        if(i<0||i>size){
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        }
        return eles[i];
    }

    /**
     * 设置线性表中序号为i的元素值
     */
    public void setElem(int i,T t){
        if(i<0||i>size){
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        }
        eles[i]=t;
    }

    /**
     * 查找t元素第一次出现的位置
     */
    public int indexOf(T t){
        for(int i=0;i<size;i++){
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 将线性表中序号为i和序号为j的元素交换
     */
    public void swap(int i,int j){
        T temp=eles[i];
        eles[i]=eles[j];
        eles[j]=temp;
    }

    /**
     * 在i元素处插入元素t
     */
    public void insert(int i,T t){
        //参数异常抛出错误
        if(i<0||i>size){
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        }
        //满容时增容
        if(size==capacity){
            updateCapacity(2*size);
        }
        //先把i索引处的元素及其后面的元素依次向后移一位
        for(int index=size;index>i;index--){
            eles[index]=eles[index-1];
        }
        //再把t元素放到i索引处即可
        eles[i]=t;
        //元素个数+1
        size++;
    }

    /**
     * 删除指定位置i处的元素,并返回该元素
     */
    public T remove(int i){
        if(i<0||i>size){
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        }
        //记录索引i处的值
        T current=eles[i];
        //索引i后面元素依次向前移动一位jike
        for(int index=i;index<size-1;index++){
            eles[index]=eles[index+1];
        }
        //元素个数-1
        size--;
        //对数组进行缩容
        if(capacity>initcapacity&&size<eles.length/4){
            updateCapacity(capacity/2);
        }
        return current;
    }

    /**
     * 将线性表转换为字符串
     */
    @Override
    public String toString(){
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<size;i++){
            ans.append(eles[i].toString()).append(" ");
        }
        return ans.toString();
    }

    /**
     * 实现顺序表的遍历,对外部提供遍历的方式,在java中,遍历集合的方式一般都是用foreach循环,如果想让我们的SequenceList也能支持foreach循环,则需要做如下操作:
     *  1. 让SequenceList实现Iterable接口,重写iterator接口
     *  2. 在SequenceList内部提供一个内部类SIterator,实现iterator接口,重写hasNext方法和next方法
     * @return
     */
    @Override
    public Iterator iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        //定义一个私有指针
        private int cusor;
        public SIterator(){
            //遍历时,从序号为0开始遍历
            this.cusor=0;
        }
        @Override
        public boolean hasNext() {
            //判断是否有下一个元素
            return cusor<size;
        }

        @Override
        public Object next() {
            //让指针下移一位
            return (Object) eles[cusor++];
        }
    }
}
