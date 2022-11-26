package test.QueueTest;

/**
 * 创建4个优先队列,每个队列插入若干元素并出队所有元素
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 学生类
 */
class Stud{
    //学号
    private int id;
    //姓名
    private String name;
    public Stud(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
public class Example {
    //定义idComparator
    public static Comparator<Stud> idComparator=new Comparator<Stud>() {
        //用于创建id小根堆
        @Override
        public int compare(Stud o1, Stud o2) {
            return (int)(o1.getId()-o2.getId());
        }
    };
    //定义nameComparator
    public static Comparator<Stud> nameComparator=new Comparator<Stud>() {
        //用于创建name大根堆
        @Override
        public int compare(Stud o1, Stud o2) {
            return (int)(o2.getName().compareTo(o1.getName()));
        }
    };

    public static void main(String[] args) {
        System.out.println("(1)创建intminqu队");
        PriorityQueue<Integer> intminqu=new PriorityQueue<>(7);
        System.out.println("    向intminqu队中依次插入3,1,2,5,4");
        intminqu.offer(3);
        intminqu.offer(1);
        intminqu.offer(2);
        intminqu.offer(5);
        intminqu.offer(4);
        System.out.print("    intmingqu出队顺序:");
        while (!intminqu.isEmpty()){
            System.out.print(intminqu.poll()+" ");
        }
        System.out.println();
        //*********************************************************************************************
        System.out.println("(2)创建intmaxqu队");
        PriorityQueue<Integer> intmaxqu=new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("    向intmaxqu队中依次插入3,1,2,5,4");
        intmaxqu.offer(3);
        intmaxqu.offer(1);
        intmaxqu.offer(2);
        intmaxqu.offer(5);
        intmaxqu.offer(4);
        System.out.print("    intmaxqu出队顺序:");
        while (!intmaxqu.isEmpty()){
            System.out.print(intmaxqu.poll()+" ");
        }
        System.out.println();
        //****************************************************************************************************
        System.out.println("(3)创建stidminqu队");
        PriorityQueue<Stud> stidminqu=new PriorityQueue<Stud>(10,idComparator);
        System.out.println("    向stidminqu依次插入四个对象");
        stidminqu.offer(new Stud(3,"Marry"));
        stidminqu.offer(new Stud(1,"David"));
        stidminqu.offer(new Stud(4,"Johm"));
        stidminqu.offer(new Stud(2,"Smith"));
        System.out.print("    stidminqu出队顺序:");
        Stud e;
        while (!stidminqu.isEmpty()){
            e=stidminqu.poll();
            System.out.print("["+e.getId()+","+e.getName()+"] ");
        }
        System.out.println();
        //*********************************************************************************************
        System.out.println("(4)创建stnamaxqu队");
        PriorityQueue<Stud> stnamaxqu=new PriorityQueue<Stud>(10,nameComparator);
        System.out.println("    向stnamaxqu队中依次插入4个对象");
        stnamaxqu.offer(new Stud(3,"Mary"));
        stnamaxqu.offer(new Stud(1,"David"));
        stnamaxqu.offer(new Stud(4,"Johm"));
        stnamaxqu.offer(new Stud(2,"Smith"));
        System.out.print("   stnamaxqu出队顺序:");
        while (!stnamaxqu.isEmpty()){
            e=stnamaxqu.poll();
            System.out.print("["+e.getId()+","+e.getName()+"] ");
        }
    }
}
