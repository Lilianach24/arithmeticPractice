package test2;

/**
 * 宋代史学家司马光在《资治通鉴》中有一段著名的“德才论”：“是故才德全尽谓之圣人，才德兼亡谓之愚人，德胜才谓之君子，才胜德谓之小人。凡取
 * 人之术，苟不得圣人，君子而与之，与其得小人，不若得愚人。”
 *
 * 现给出一批考生的德才分数，请根据司马光的理论给出录取排名。
 *
 * 输入格式：
 * 输入第一行给出 3 个正整数，分别为：N（≤10^5），即考生总数；L（≥60），为录取最低分数线，即德分和才分均不低于 L 的考生才有资格被考
 * 虑录取；H（<100），为优先录取线——德分和才分均不低于此线的被定义为“才德全尽”，此类考生按德才总分从高到低排序；才分不到但德分到线的
 * 一类考生属于“德胜才”，也按总分排序，但排在第一类考生之后；德才分均低于 H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”者，
 * 按总分排序，但排在第二类考生之后；其他达到最低线 L 的考生也按总分排序，但排在第三类考生之后。
 * 随后 N 行，每行给出一位考生的信息，包括：准考证号、德分、才分，其中准考证号为 8 位整数，德才分为区间 [0, 100] 内的整数。数字间以空格分隔。
 *
 * 输出格式：
 * 输出第一行首先给出达到最低分数线的考生人数 M，随后 M 行，每行按照输入格式输出一位考生的信息，考生按输入中说明的规则从高到低排序。
 * 当某类考生中有多人总分相同时，按其德分降序排列；若德分也并列，则按准考证号的升序输出。
 */

import java.util.*;

/**
 * 考生类
 */
class Student{
    //考生准考证号
    String id;
    //考生的德分
    int ethics;
    //考生的才分
    int ability;
    //考生的种类
    int cate;
    public Student(String id,int ethics,int ability){
        this.id=id;
        this.ethics=ethics;
        this.ability=ability;
    }

    @Override
    public String toString() {
        return ""+id + " " + ethics +" " + ability ;
    }
}

class stdCmp implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {

        //计算总分
        int sum1=o1.ethics+o1.ability;
        int sum2=o2.ethics+o2.ability;
        //首先按学生的种类排序
        if(o1.cate==o2.cate){
            //种类相同的按总分排序
            if(sum1==sum2){
                //总分相同则按德分排序
                if(o1.ethics==o2.ethics){
                    //若德分也并列，则按准考证号的升序输出
                    return o1.id.compareTo(o2.id);
                }else {
                    return o2.ethics-o1.ethics;
                }
            }else {
                return sum2-sum1;
            }
        }else {
            return o1.cate-o2.cate;
        }

    }
}
public class 德才论 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义存放考生信息的线性表
        List<Student> students=new ArrayList<Student>();
        //输入考生总数
        int n =sc.nextInt();
        //录取最低分数线
        int l =sc.nextInt();
        //优先录取线
        int h =sc.nextInt();
        //记录有资格录取的考生的人数
        int count=n;
        //输入考生信息
        for (int i = 0; i < n; i++) {
            //分别输入考生的学号,考生的德分和才分
            students.add(new Student(sc.next(),sc.nextInt(),sc.nextInt()));
            //第五类考生:看此考生是否有资格录取
            if(students.get(i).ethics<l||students.get(i).ability<l){
                students.get(i).cate=5;
                count--;
            }
            //第一类考生:德分和才分均不低于H的被定义为“才德全尽”，此类考生按德才总分从高到低排序
            else if(students.get(i).ethics>=h&&students.get(i).ability>=h){
                students.get(i).cate=1;
            }
            //第二类考生:才分不到但德分到线的一类考生属于“德胜才”
            else if(students.get(i).ethics>=h&&students.get(i).ability<h){
                students.get(i).cate=2;
            }
            //第三类考生:德才分均低于 H，但是德分不低于才分的考生属于“才德兼亡”但尚有“德胜才”
            else if(students.get(i).ethics<h&&students.get(i).ability<h&&students.get(i).ethics>=students.get(i).ability){
                students.get(i).cate=3;
            }
            //第四类考生:其他达到最低线 L 的考生也按总分排序，但排在第三类考生之后
            else {
                students.get(i).cate=4;
            }
        }
        //对考生进行排序
        students.sort(new stdCmp());
        //输出达到最低分数线的考生人数 M
        System.out.println(count);
        //输出考生信息
        for (int i = 0; i < count; i++) {
            System.out.println(students.get(i).toString());
        }
    }
}
