package test2;

import java.util.Scanner;
class Graph{
    //定义一个二维数组
    static int arr[][];
    //定义一个访问控制数组
    static boolean visit[];
    //构造方法
    public Graph(int arr[][],int n){
        Graph.arr =arr;
        visit=new boolean[n];
    }
    //i为起点,j为终点
    public boolean dfs(int i,int j){
        if(i==j){
            return true;
        }
        //首先标志i为已访问
        visit[i]=true;
        //遍历所有的点
        for (int k = 0; k < arr[0].length; k++) {
            //i  k 之间有路径且k点未被访问
            if(arr[i][k]==1&&!visit[k]){
                //从k开始去深搜,如果能访问j点,说明从i点能访问到j点
                if(dfs(k,j)){
                    return true;
                }
            }
        }
        //从i到j之间没有路径
        return false;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[][];
        int N=sc.nextInt();
        int E=sc.nextInt();
        arr=new int[N][N];
        for (int i = 0; i < E; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }
        int i=sc.nextInt();
        int j=sc.nextInt();
        Graph graph=new Graph(arr,N);
        boolean res=graph.dfs(i,j);
        if(res){
            System.out.printf("There is a path between %d and %d.\n",i,j);
        }else {
            System.out.printf("There is no path between %d and %d.\n",i,j);
        }
    }
}
