package test.SqStackTest;

/**
 * @author cl
 * 给定一个M*N的迷宫图,求一条从指定入口到出口的路径
 */

import java.util.Stack;

/**
 * 定义一个方块类
 */
class Box{
    //方块的行号
    int i;
    //方块的列号
    int j;
    //下一个可走相邻方位的方位号,规定上方方位为方位0,并按顺时针方向递增编号
    int di;
    public Box(int i1,int j1,int di1){
        i=i1;
        j=j1;
        di=di1;
    }
}

/**
 * 迷宫问题类
 */
public class Maze {
    final int MaxSize=20;
    //迷宫数组
    int[][] mg;
    //迷宫行和列号
    int m,n;
    //构造方法
    public Maze(int m1,int n1){
        m=m1;
        n=n1;
        mg=new int[MaxSize][MaxSize];
    }
    //设置迷宫数组
    public void Setmg(int[][] a){
        for (int i = 0; i < m; i++) {
            if (n >= 0) {
                System.arraycopy(a[i], 0, mg[i], 0, n);
            }
        }
    }
    //求一条从(xi,yi)到(xe,ye)的迷宫路径
    boolean mgpath(int xi,int yi,int xe,int ye){
        int i,j,di,i1=0,j1=0;
        boolean find;
        Box box,e;
        //建立一个空栈
        Stack<Box> st=new Stack<Box>();
        //入口方块进栈,初始方位设置为-1
        st.push(new Box(xi,yi,-1));
        //为避免来回找相邻方块,将进栈的方块置为-1,变为不可走的相邻方块
        mg[xi][yi]=-1;
        //栈不空时循环
        while (!st.empty()){
            //取栈顶方块,称为当前方块
            box=st.peek();
            i=box.i;j=box.j;di=box.di;
            //找到了出口,输出栈中所有方块构成一条路径
            if(i==xe&&j==ye){
                int cnt=1;
                while (!st.empty()){
                    e=st.pop();
                    System.out.print("["+e.i+","+e.j+"]");
                    if(cnt%5==0){
                        //每行输出5个方块
                        System.out.println();
                    }
                    cnt++;
                }
                //找到一条路径后返回true
                System.out.println();
                return true;
            }
            //否则继续找路径,找下一个相邻可走方块
            find=false;
            //对于可走的方块都要进栈,并试探他的下一个可走的方位,将这个可走的方位保存到栈中
            while(di<3&&!find){
                di++;
                switch (di){
                    case 0:i1=i-1;j1=j;break;
                    case 1:i1=i;j1=j+1;break;
                    case 2:i1=i+1;j1=j;break;
                    default:i1=i;j1=j-1;break;
                }
                //找到下一个可走相邻方块(i1,j1)
                if(mg[i1][j1]==0){
                    find=true;
                }
            }
            //找到下一个可走方块,将其方位保存到栈顶元素中,并将这个可走的相邻方块进栈
            if(find){
                e=st.pop();
                //将方位保存到栈顶元素中
                e.di=di;
                //修改栈顶元素 的di成员
                st.push(e);
                //下一个可走方块进栈
                st.push(new Box(i1,j1,-1));
                //为避免来回找相邻方块,将进展的方块置为-1
                mg[i1][j1]=-1;
            }
            //没有路径可走,原路回溯,即恢复当前方块后退栈
            else {
                mg[i][j]=0;
                st.pop();
            }
        }
        return false;
    }
}
