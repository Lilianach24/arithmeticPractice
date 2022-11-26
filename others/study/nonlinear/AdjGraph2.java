package nonlinear.graph;

/**
 * 简化的邻接表
 */

import java.util.Arrays;

/**
 * 边结点类
 */
class ENode{
    //邻接点
    int v;
    //边权值
    int w;
    //下一条边
    int next;
    //构造方法
    public ENode(int v,int w){
        this.v=v;
        this.w=w;
    }
}
public class AdjGraph2 {
    //表示最多顶点个数
    final int MAXV=100;
    //表示最多边数
    final int MAXE=300;
    //表示∞
    final int INF=0x3f3f3f3f;
    //邻接表头节点数组
    int[] head;
    //边结点数组
    ENode[] edge;
    //图中的顶点数n和边数e
    int n,e;
    //边数组下表
    int toll;
    //构造方法
    public AdjGraph2(){
        //创建头节点数组
        head=new int[MAXV];
        //head的所有元素初始化为-1
        Arrays.fill(head,-1);
        //创建边结点数组
        edge=new ENode[MAXE];
        //edge数组的下标从0开始
        toll=0;
    }
    //图中增加边<u,v,w>
    public void addEdge(int u,int v,int w){
        edge[toll]=new ENode(v,w);
        edge[toll].next=head[u];
        head[u]=toll++;
    }
    //通过边数组a建立图的简化邻接表
    public void createAdjGraph(int[][] a){
        //初始化定点数和边数
        n=a.length;
        e=0;
        //检查边数组a中的每一个元素
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                //存在一条边
                if(a[i][j]!=0&&a[i][j]!=INF){
                    addEdge(i,j,a[i][j]);
                    //边数加1
                    e++;
                }
            }
        }
    }
    //输出图的邻接表
    public void dispAdjGraph(){
        for (int i = 0; i < n; i++) {
            System.out.printf("  [%d]",i);
            for (int e=head[i];e!=-1;e=edge[e].next){
                System.out.printf("->(%d,%d)",edge[e].v,edge[e].w);
            }
            System.out.println("->∧");
        }
    }
}
