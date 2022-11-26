package test;

import java.util.*;

/**
 * gg有一个超市，超市里有2个员工，分别是送货的小a、摆货的小b，超市有大厅和仓库。大厅里有个货架，货架只有一个口，可以放商品或者取商品；
 * 仓库里有条传送带，会把放入前门的货品运送到后门。小a的工作是每天早上把商品一个一个的送到仓库前门；小b的工作是每天早上把商品从仓库后
 * 门一个一个的取出放到大厅的货架上，一般来说，都会把新取的货品放到货架最底层，可是小b很懒，每次都把商品放到最前面；超市每天都有顾客来
 * 购物。gg偶尔会在一天的营业结束后来超市抽查货品，如果发现货架上的第一个商品是三天前进货的，gg会发怒，并把货架清空。
 *
 * 输入格式:
 * 在第一行给出n（n<=100），代表总天数，接下来n行为每天发生的事情。
 * 每行第一个数字代表第几天，题目保证天数依次有序
 * 每行第二个数字代表小a今天得进货数量，范围0~1000
 * 每行第三个数字代表小b今天往货架上放货得数量，范围0~1000
 * 每行第四个数字代表顾客今天买走了多少商品，范围0~1000
 * 每行第五个数字代表gg今天来了没有，1代表来了，0代表没来
 * 数字间以空格分隔
 *
 * 数据不保证小b得取货量<=仓库剩余量，货架剩余量<=估计购买量
 *
 * 输出格式:
 * 如果某天gg抽查时发怒了，则输出天数后加一串字符串"Wang!Wang!!Wang!!!"。
 *
 * 例：gg在第三天抽查时发怒了，则输出“3 Wang! Wang!! Wang!!!”.
 */
public class gg的超市 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入n天
        int n=sc.nextInt();
        //定义一个队列,表示仓库的货物
        Queue<Integer> warehouse=new LinkedList<>();
        //定义一个栈,表示货架上的货物
        Stack<Integer> shelf=new Stack<Integer>();
        while (n>0){
            //输入第几天发生的事情
            int day=sc.nextInt();
            //输入小a进货数量
            int na=sc.nextInt();
            for (int i = 0; i < na; i++) {
                warehouse.add(day);
            }
            //输入小b向货架上放货的数量
            int nb=sc.nextInt();
            //由于题目不保证小b取货量<=仓库剩余量,所以要进行判断
            int num1= Math.min(nb, warehouse.size());
            for (int i = 0; i < num1; i++) {
                shelf.push(warehouse.poll());
            }
            //输入顾客买走商品的数量
            int nc=sc.nextInt();
            //题目不保证货架剩余量<=估计购买量
            int num2=Math.min(nc,shelf.size());
            for (int i = 0; i < num2; i++) {
                shelf.pop();
            }
            //gg今天是否来抽查商品
            int check=sc.nextInt();
            if(check==1&&!shelf.empty()){
                if(shelf.peek()<=day-3){
                    //gg发怒,并清空货架
                    System.out.println(day+" Wang!Wang!!Wang!!!");
                    shelf.clear();
                }
            }
            n--;
        }
    }
}
