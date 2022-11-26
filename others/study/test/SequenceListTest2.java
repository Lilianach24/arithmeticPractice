package test;

import linear.SequenceList;

/**
 * @author cl
 * 顺序表的扩容,容量可变
 */
public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> sl=new SequenceList<>();
        sl.add("张三" );
        sl.add("李四");
        sl.add("王五");
        sl.add("赵六");
    }
}
