package Unit1;

import java.util.*;

/**
 * 定义一个二维数组：
 *
 * int maze[5][5] = {
 * 	0, 1, 0, 0, 0,
 * 	0, 1, 0, 1, 0,
 * 	0, 0, 0, 0, 0,
 * 	0, 1, 1, 1, 0,
 * 	0, 0, 0, 1, 0,
 * };
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。
 * Input
 * 一个5 × 5的二维数组，表示一个迷宫。数据保证有唯一解。
 * Output
 * 左上角到右下角的最短路径，格式如样例所示。
 * (0, 0)
 * (1, 0)
 * (2, 0)
 * (2, 1)
 * (2, 2)
 * (2, 3)
 * (2, 4)
 * (3, 4)
 * (4, 4)
 */

/**
 * 定义一个方块类
 */
class Box{
    //方块的行号
    int i;
    //方块的列号
    int j;
    //后继方块
    Box pre;
    public Box(int i,int j){
        this.i=i;
        this.j=j;
        pre=null;
    }
}

public class J {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入迷宫数组
        int[][] mg = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mg[i][j]=sc.nextInt();
            }
        }
        //定义一个队列
        Queue<Box> qu=new LinkedList<Box>();
        //定义一个栈
        Stack<Box> st=new Stack<Box>();

        //求（0，0）到（4，4）的一条迷宫路径
        int i,j,i1=0,j1=0;
        Box b,b1;
        //建立入口节点b
        b=new Box(0,0);
        //结点b进队
        qu.offer(b);
        //进队方块的mg值置为-1
        mg[0][0]=-1;
        //队不空时循环
        while (!qu.isEmpty()){
            //出队一个方块
            b=qu.poll();
            //找到了出口,输出路径
            if(b.i==4&&b.j==4){
                //从b出发回推导出迷宫路径并输出
                while (b!=null){
                    //倒序访问最短路径并入栈
                    st.add(new Box(b.i,b.j));
                    b=b.pre;
                }
            }
            //循环扫描每一个方位,把每个可走的方块进队
            if (b != null) {
                for (int di = 0; di < 4; di++) {
                    i=b.i;j=b.j;
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
                    if(i1>=0&&j1>=0&&i1<5&&j1<5){
                        if(mg[i1][j1]==0){
                            //建立后继方块结点b1
                            b1=new Box(i1,j1);
                            //设置其前驱方块为b
                            b1.pre=b;
                            //b1进队
                            qu.offer(b1);
                            //将进队的方块设置为-1
                            mg[i1][j1]=-1;
                        }
                    }
                }
            }
        }
        //最后出栈
        while (!st.empty()){
            Box b2=st.pop();
            System.out.printf("(%d, %d)\n",b2.i,b2.j);
        }
    }
}
