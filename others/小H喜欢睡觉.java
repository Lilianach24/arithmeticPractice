package test2;

/**
 * 小H十分喜欢睡觉，这天他起来一看，居然9.30了，而他答应了10点要到小W家去，小H想走知道小H到小W家的最短时间是多少，你能帮帮他吗。
 *
 * 地图是n * m的网格，每个单元是一个开放空间或建筑物（无法通过），小H的加在（1,1）,小W 在（x，y）处，他只能上下左右移动，每一步需要1
 * 分钟。 输入数据可确保小W家可到达。
 *
 * 输入格式:
 * 第一行具有两个正整数n，m，以空格（1 <= n，m <= 100）隔开，n为行，m为列 接下来是两个正整数x，y，用空格隔开
 * （1 <= x <= n，1 <= y <= m）指示教学大楼的坐标 接下来是n行和m列的地图，0表示开放空间，1表示障碍物。
 *
 * 输出格式:
 * 对于每个测试用例，输出一行包含整数的行，该行给出了小H到达小W家所需的最短时间（以分钟为单位）。
 */

import java.util.*;

/**
 * 地图类
 */
class Map{
    int i;
    int j;
    //计算步数
    int step;
    //前继方块
    Map pre;
    public Map(int i,int j,int step){
        this.i=i;
        this.j=j;
        this.step=step;
        this.pre=null;
    }
}
public class 小H喜欢睡觉 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入地图规格
        int n=sc.nextInt(),m=sc.nextInt();
        //输入小H的家的坐标
        int x=sc.nextInt(),y=sc.nextInt();
        //输入地图
        int[][] map=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        //定义一个队列
        Queue<Map> qu=new LinkedList<Map>();
        //定义入口结点
        int i,j,i1=0,j1=0;
        Map load,load1;
        load=new Map(0,0,0);
        //结点进队
        qu.offer(load);
        //进队的结点置为-1
        map[0][0]=-1;
        //队不空时循环
        while (!qu.isEmpty()){
            //出队一个结点
            load=qu.poll();
            //找到了小H的家
            if(load.i==x&&load.j==y){
                System.out.println(load.step);
                break;
            }
            //循环扫描每一个方位，把可以走的方位进队
            for (int di = 0; di < 4; di++) {
                i=load.i;j=load.j;
                switch (di){
                    case 0:
                        i1=i-1;j1=j;
                        break;
                    case 1:
                        i1=i;j1=j+1;
                        break;
                    case 2:
                        i1=i+1;j1=j;
                        break;
                    case 3:
                        i1=i;j1=j-1;
                        break;
                    default:break;
                }
                //找相邻可走方块
                if(i1>=0&&j1>=0&&i1<n&&j1<m){
                    if(map[i1][j1]==0){
                        //建立后继方块结点load1
                        load1=new Map(i1,j1,load.step+1);
                        //设置其前驱方块为b
                        load1.pre=load;
                        //b1进队
                        qu.offer(load1);
                        //将进队的方块设置为-1
                        map[i1][j1]=-1;
                    }
                }
            }
        }
    }
}
