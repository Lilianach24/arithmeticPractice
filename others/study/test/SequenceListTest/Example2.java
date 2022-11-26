package test.SequenceListTest;

import java.util.*;

/**
 * 有若干个学生记录,每个记录包含姓名和年龄,用ArrayList的对象存放,分别采用上述3种排序方法实现按年龄递增排序,按姓名递增排序和
 * 按年龄递减排序,并用相关数据进行测试
 */
class Stud implements Comparable<Stud>{

    //姓名
    private String name;
    //年龄
    private Integer age;
    //构造方法
    public Stud(String na,int ag){
        name=na;
        age=ag;
    }
    @Override
    public String toString(){
        String ans;
        ans="["+name+","+age+"]";
        return ans;
    }
    //取name的属性
    public String getname(){
        return name;
    }
    //用于按age递增排序
    @Override
    public int compareTo(Stud o) {
        return this.age.compareTo(o.age);
    }
}
public class Example2 {
    public static void main(String[] args) {
        List<Stud> list=new ArrayList<Stud>();
        list.add(new Stud("John",18));
        list.add(new Stud("Mary",19));
        list.add(new Stud("Smith",20));
        list.add(new Stud("Tom",18));
        System.out.println("初始排序:\n"+list);
        //排序方法1
        Collections.sort(list);
        System.out.println("按年龄排序:\n"+list);
        //排序方法2
        Collections.sort(list,new Comparator<Stud>(){

            //用于按名字递增排序
            @Override
            public int compare(Stud o1, Stud o2) {
                return o1.getname().compareTo(o2.getname());
            }
        });
        System.out.println("按名字递增排序:\n"+list);
        //排序方法3
        list.sort(Comparator.comparing(Stud::getname).reversed());
        System.out.println("按名字递减排序:\n"+list);
    }
}
