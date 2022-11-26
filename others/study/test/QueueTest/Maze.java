package test.QueueTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列中的方块类
 */
class Box{
    //方块的行号
    int i;
    //方块的列号
    int j;
    //前驱方块
    Box pre;
    //构造方法
    public Box(int i,int j){
        this.i=i;
        this.j=j;
    }
}
public class Maze {
    final int MaxSize=20;
    //迷宫数组
    int[][] mg;
    //迷宫的行/列数
    int m,n;
    //队列
    Queue<Box> qu;
    /**
     * 构造方法
     */
    public Maze(int m,int n){
        this.m=m;
        this.n=n;
        mg=new int[MaxSize][MaxSize];
        //创建一个空队
        qu=new LinkedList<Box>();
    }
    /**
     * 设置迷宫数组
     */
    public void setMg(int[][] a){
        for (int i = 0; i < m; i++) {
            if (n >= 0) {
                System.arraycopy(a[i], 0, mg[i], 0, n);
            }
        }
    }
    /**
     * 从p出发找一条迷宫路径
     */
    public void disppath(Box p){
        int cnt=1;
        //找到入口为止
        while (p!=null){
            System.out.print("["+p.i+","+p.j+"] ");
            if(cnt%5==0){
                System.out.println();
            }
            cnt++;
            p=p.pre;
        }
        System.out.println();
    }
    /**
     * 求(xi,yi)到(xe,ye)的一条迷宫路径
     */
    boolean mgpath(int xi,int yi,int xe,int ye){
        int i,j,i1=0,j1=0;
        Box b,b1;
        //建立入口结点b
        b=new Box(xi,yi);
        //结点b进队
        qu.offer(b);
        //进队方块的mg值置为-1
        mg[xi][yi]=-1;
        //队不空时循环
        while (!qu.isEmpty()){
            //出队一个方块
            b=qu.poll();
            //找到出口,输出路径
            if(b.i==xe&&b.j==ye){
                //从b出发回推导出迷宫路径并输出
                disppath(b);
                //找到一条路径时返回true
                return true;
            }
            i=b.i;j=b.j;
            //循环扫描每个方块,把每个可走的方块进队
            for (int di = 0; di < 4; di++) {
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
                    default:
                        break;
                }
                //找相邻可走方块
                if(mg[i1][j1]==0){
                    //建立后继方块结点b1
                    b1=new Box(i1,j1);
                    //设置其前驱方块为b
                    b1.pre=b;
                    //b1进队
                    qu.offer(b1);
                    //将进队的方块置为-1
                    mg[i1][j1]=-1;
                }
            }
        }
        return false;
    }
}
