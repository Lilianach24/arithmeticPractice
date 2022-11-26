package nonlinear.graph;

/**
 * 邻接表
 */

/**
 * 边结点类
 */
class ArcNode{
    //该边的终点编号
    int adjvex;
    //指向下一条边的指针
    ArcNode nextarc;
    //该边的相关信息,例如边的权值
    int weight;
}

/**
 * 头结点类
 */
class VNode{
    //顶点信息
    String[] data;
    //指向第一条边的邻接顶点
    public ArcNode firstarc;
}

public class AdjGraph {
    //表示最多顶点个数
    final int MAXV=100;
    //表示∞
    final int INF=0x3f3f3f3f;
    //邻接表头数组
    public VNode[] adjlist;
    //图中的定点数n和边数e
    int n,e;
    //构造方法
    public AdjGraph(){
        adjlist=new VNode[MAXV];
        for (int i = 0; i < MAXV; i++) {
            adjlist[i]=new VNode();
        }
    }
    //图的基本运算算法
    /**
     * 创建图的邻接表
     * 假设给定的邻接矩阵数组a,顶点数n和边数e来建立邻接表的存储结构
     */
    public void createAdjGraph(int[][] a,int n,int e){
        //置定点数和边数
        this.n=n;
        this.e=e;
        //将邻接表中所有头节点的指针置初值
        ArcNode p;
        for (int i = 0; i < n; i++) {
            adjlist[i].firstarc=null;
        }
        //检查边数组a中的每个元素
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                //存在一条边
                if(a[i][j]!=0&&a[i][j]!=INF){
                    //创建一个边结点p
                    p=new ArcNode();
                    p.adjvex=j;
                    p.weight=a[i][j];
                    //采用头插法插入p
                    p.nextarc=adjlist[i].firstarc;
                    adjlist[i].firstarc=p;
                }
            }
        }
    }
    /**
     * 输出图
     */
    public void dispAdjGraph(){
        ArcNode p;
        for (int i = 0; i < n; i++) {
            System.out.printf("  [%d]",i);
            //p指向第一个邻接点
            p=adjlist[i].firstarc;
            while (p!=null){
                System.out.printf("->(%d,%d)",p.adjvex,p.weight);
                //p移向下一个邻接点
                p=p.nextarc;
            }
            System.out.println("->∧");
        }
    }
}
