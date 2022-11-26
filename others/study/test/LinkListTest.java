package test;

import linear.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        //创建表对象
        LinkList<String> sl = new LinkList<>();
        //测试插入
        sl.add("姚明");
        sl.add("科比");
        sl.add("麦迪");
        sl.insert(1, "詹姆斯");

        for(String s : sl){
            System.out.println(s);
        }
        System.out.println("---------------------------");


        //测试获取
        String getResult = sl.getElem(1);
        System.out.println("获取索引1处的结果为:"+getResult);
        //测试删除
        sl.remove(0);
        for(Object s : sl){
            System.out.println(s);
        }
        //测试清空
        sl.clear();
        System.out.println("清空后的线性表中的元素的个数为:"+sl.size());
    }
}
