package nonlinear.graph;
/**
 * 邻接矩阵:
 *      适合存储边数较多的稠密图
 */


public class MatGraph {
    //最多顶点的个数
    private final int MAXV=100;
    //表示∞
    private final int INF=0x3f3f3f3f;
    //邻接矩阵数组,假设元素为int类型
    int[][] edges;
    //顶点数和边数
    int n,e;
    //存放顶点信息
    String[] vexs;
    //构造方法
    public MatGraph() {
        edges=new int[MAXV][MAXV];
        vexs=new String[MAXV];
    }

    //图的基本运算算法
    /**
     * 创建图的邻接矩阵
     * 假设给定图的邻接矩阵数组a,顶点数n和边数e来建立图的邻接矩阵存储结构
     */
    public void createMatGraph(int[][] a,int n,int e){
        this.n=n;
        this.e=e;
        for (int i = 0; i < n; i++) {
            edges[i]=new int[n];
            System.arraycopy(a[i], 0, edges[i], 0, n);
        }
    }
    /**
     * 输出图
     */
    public void dispMatGraph(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(edges[i][j]==INF){
                    System.out.printf("%4s", "∞");
                }else {
                    System.out.printf("%5d",edges[i][j]);
                }
            }
        }
    }
}
