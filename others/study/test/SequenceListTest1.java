package test;

import linear.SequenceList;

public class SequenceListTest1 {
    public static void main(String[] args) {
        //创建表对象
        SequenceList<String> sl = new SequenceList<>();
        //测试插入
        sl.add("姚明");
        sl.add("科比");
        sl.add("麦迪");
        sl.insert(1, "詹姆斯");

        for(Object s : sl){
            System.out.println(s);
        }
        System.out.println("---------------------------");


        //测试获取
        String getResult = sl.getElem(1);
        System.out.println("获取索引1处的结果为:"+getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素为:"+removeResult);
        //测试清空
        sl.clear();
        System.out.println("清空后的线性表中的元素的个数为:"+sl.size());
    }
}
