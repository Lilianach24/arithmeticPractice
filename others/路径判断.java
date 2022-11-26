package test2;

import java.util.Scanner;

/**
 * 给定一个有N个顶点和E条边的无向图，请判断给定的两个顶点之间是否有路径存在。 假设顶点从0到N−1编号。
 *
 * 输入格式:
 * 输入第1行给出2个整数N(0<N≤10)和E，分别是图的顶点数和边数。
 * 随后E行，每行给出一条边的两个端点。每行中的数字之间用1空格分隔。
 * 最后一行给出两个顶点编号i，j（0≤i,j<N）,i和j之间用空格分隔。
 *
 * 输出格式:
 * 如果i和j之间存在路径，则输出"There is a path between i and j."，
 * 否则输出"There is no path between i and j."。
 */
class graph{
    //邻接矩阵数组
    static int[][] arr;
    //访问标识数组
    static boolean visited[];
    public graph(int[][] arr,int n){
        graph.arr =arr;
        visited=new boolean[n];
    }
    //邻接矩阵中深度优先遍历,i为起点,j为终点
    public boolean dfs(int i,int j){
        if(i==j){
            return true;
        }
        //置为已访问标记
        visited[i]=true;
        for (int k = 0; k < arr[0].length; k++) {
            //i,k之间有路径,且没有被访问
            if(arr[i][k]==1&&!visited[k]){
                //如果能从k访问到j则说明i和j之间存在路径
                if(dfs(k,j)){
                    return true;
                }
            }
        }
        //i到j之间没有路径
        return false;
    }
}
public class 路径判断 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //分别输入图的顶点数和边数
        int n =sc.nextInt();
        int e=sc.nextInt();
        //创建邻接矩阵
        int[][] arr=new int[n][n];
        for (int i = 0; i < e; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }
        //最后一行给出两个顶点编号i，j（0≤i,j<N）
        int i=sc.nextInt(),j=sc.nextInt();
        //判断i和j之间是否存在路径
        graph g=new graph(arr,n);
        if(g.dfs(i,j)){
            System.out.printf("There is a path between %d and %d.",i,j);
        }else {
            System.out.printf("There is no path between %d and %d.",i,j);
        }
    }
}
