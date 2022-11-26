package test2;

import java.util.*;

class Node{
    int x;
    int y;
    //当前点到起点的步数
    int step;
    public Node(int x,int y,int step){
        this.x=x;
        this.y=y;
        this.step=step;
    }
}
public class Main3 {
    public static int map[][];
    public static boolean vis[][];
    public static int dx[]={1,-1,0,0};
    public static int dy[]={0,0,1,-1};
    public static int primary_num=4;
    public static int start_x=1,start_y=1;
    public static int target_x,target_y,m,n;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] split=str.split(" ");
        n=Integer.parseInt(split[0]);
        m=Integer.parseInt(split[1]);
        //把map数组和vis数组new出来[n+2][m+2]
        map=new int[n+2][m+2];
        //读出target_x  target_y
        str=sc.nextLine();
        split=str.split(" ");
        //target_x=
        //target_y=

        //读出map数组
        for (int i = 0; i <= n; i++) {
            str=sc.nextLine();
            split=str.split(" ");
            for (int j = 1; j <= m; j++) {
                map[i][j]=Integer.parseInt(split[j-1]);
            }
        }
        Queue<Node> qu=new LinkedList<Node>();
        Node start_node=new Node(start_x,start_y,0);
        qu.offer(start_node);
        vis[start_node.x][start_node.y]=true;
        while (!qu.isEmpty()){
            Node new_node=qu.poll();
            for (int i = 0; i < primary_num; i++) {
                int nx=new_node.x+dx[i];
                int ny=new_node.y+dy[i];
                if(nx==target_x&&ny==target_y){
                    System.out.println(new_node.step+1);
                    return;
                }
                if(in(nx,ny)&&!vis[nx][ny]&&map[nx][ny]==0){
                    Node nn_node=new Node(nx,ny,new_node.step+1);
                    vis[nx][ny]=true;
                    qu.offer(nn_node);
                }
            }
        }
    }
    private static boolean in(int nx,int ny){
        return (nx>=1&&nx<=n&&ny>=1&&ny<=m);
    }
}
