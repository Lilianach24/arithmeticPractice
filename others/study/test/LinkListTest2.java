package test;

import linear.LinkList;

public class LinkListTest2 {
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

        sl.reverse();
        for(String s : sl){
            System.out.println(s);
        }
    }
}
