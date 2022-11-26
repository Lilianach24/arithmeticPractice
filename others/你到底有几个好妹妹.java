package test2;

/**
 * 小李的QQ列表里有很多联系人，他修改了所有人的备注姓名。其中有些联系人名字的前部或后部被加了诸如"好妹妹"的字样。请你打印出小李的所有
 * 的女性"好妹妹"。打印时请按照联系人原始名字升序排列，如果两人名字相同则年龄小的排在前面；如果两人年龄相同，则较早成为好友的排在前面。
 * 题目保证好妹妹标志不会同时出现在前缀和后缀，同一天里也不会添加名字相同并且年龄相同的"好妹妹"。
 *
 * 输入格式:
 * 第一行给出标识好妹妹标志的字符串，该字符串内不包含空格，最大长度为6并且不区分大小写。第二行给出QQ列表的所有联系人个数n (1≤ n ≤10^5)，
 * 随后n行列出所有联系人信息，每行信息格式如下：
 * 备注姓名 性别 年龄 结交好友日期
 * 其中备注姓名不超过30个字符；性别用字符表示，F表示女性，M代表男性；结交好友日期采用诸如"2001.01.01"的格式表示。
 *
 * 输出格式:
 * 第一行输出好妹妹的数目k，随后k行打印出去掉好妹妹标志的名字、年龄以及结交好友日期。
 */

import java.util.*;

/**
 * 联系人信息类
 */
class People{
    //备注姓名
    String name;
    //年龄
    int age;
    //结交好友日期
    String date;
    //好友的种类
    int id;
    public People(String name,int age,String date,int id){
        this.name=name;
        this.age=age;
        this.date=date;
        this.id=id;
    }

    @Override
    public String toString() {
        return "" + name + " " + age + " " + date;
    }
}
class peoCmp implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        //先按种类排序
        if(o1.id==o2.id){
            //按照联系人原始名字升序排列
            if(o1.name.equals(o2.name)){
                //如果两人名字相同则年龄小的排在前面
                if(o1.age==o2.age){
                    //如果两人年龄相同，则较早成为好友的排在前面
                    return o1.date.compareTo(o2.date);
                }else {
                    return o1.age-o2.age;
                }
            }else {
                return o1.name.compareTo(o2.name);
            }
        }
        return o1.id-o2.id;
    }
}
public class 你到底有几个好妹妹 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义存放联系人信息的线性表
        List<People> people=new ArrayList<People>();
        //第一行给出标识好妹妹标志的字符串，该字符串内不包含空格，最大长度为6并且不区分大小写
        String str=sc.next();
        //第二行给出QQ列表的所有联系人个数n
        int n=sc.nextInt();
        //记录好妹妹的个数
        int k=0;
        for (int i = 0; i < n; i++) {
            //标记联系人的种类
            int id=0;
            //输入姓名
            String name=sc.next();
            //输入性别
            String sex=sc.next();
            //如果是女性
            if("F".equals(sex)){
                //首先需要判断是否为好妹妹
                String sname=name.toLowerCase();
                String s=str.toLowerCase();
                if(sname.startsWith(s)||sname.endsWith(s)){
                    //如果是好妹妹,则需要去除好妹妹的标识符
                    if(sname.startsWith(s)){
                        name=name.substring(str.length());
                    }else if(sname.endsWith(s)){
                        name=name.substring(0,name.length()-str.length());
                    }
                    //标识好妹妹id为1
                    id=1;
                    //计算好妹妹的个数
                    k++;
                }else {
                    id=2;
                }
            }else {
                id=3;
            }
            //将所有联系人的信息存储到线性表中
            people.add(new People(name,sc.nextInt(),sc.next(),id));
        }
        //对好妹妹进行排序
        people.sort(new peoCmp());
        //输出好妹妹的数目
        System.out.println(k);
        //输出好妹妹的信息
        for (int i = 0; i < k; i++) {
            System.out.println(people.get(i).toString());
        }
    }
}
