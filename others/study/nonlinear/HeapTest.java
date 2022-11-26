package nonlinear.heap;

public class HeapTest {
    public static void main(String[] args) {
        //创建堆对象
        Heap<String> heap = new Heap<>(10);
        //往堆中存入字符数据
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        //通过循环从堆中删除数据
        String result=null;
        while ((result = heap.delMax())!=null){
            System.out.print(result+" ");
        }
    }
}
