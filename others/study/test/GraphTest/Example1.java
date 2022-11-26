package test.GraphTest;

import nonlinear.graph.AdjGraph;

import java.util.Arrays;

/**
 * 假设图G采用邻接表存储,设计一个算法判断顶点u到顶点v之间是否会有路径
 */

public class Example1 {
    //表示最多顶点个数
    static final int MAXV=100;
    //全局变量数组
    static int[] visited=new int[MAXV];

    //判断u到v是否有简单路径
    /*public static boolean HasPath(AdjGraph G,int u,int v){
        //初始化
        Arrays.fill(visited,0);
        return HasPath1(G,u,v);
    }
    private static <ArcNode> boolean HasPath1(AdjGraph G, int u, int v){
        ArcNode p;
        int w;
        visited[u]=1;
        //p指向u的第一个邻接点
        p=G.adjlist[u].firstarc;
    }*/
}
