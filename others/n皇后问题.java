package 试题集.基础练习;

import java.util.Scanner;

public class n皇后问题 {
    //表示有n个皇后
    static int n;
    //x[i]表示第i个皇后放置在第i行第x[i]列
    static int[] x=new int[105];
    //表示n皇后问题可行解的个数
    static int countn;
    /**
     * 约束函数:判断第t个皇后是否能放置在第i个位置
     * 在第t行放置第t个皇后时,第t个皇后与前t-1个已放置好的皇后不能再同一列或同一斜线.如果有一个成立,则第t个皇后不可以放置
     * 在该位置
     * x[t]==x[j]表示第t个皇后和第j个皇后位置在同一列,t-j==abs(x[t]-x[j])表示第t个皇后和第j个皇后在同一斜线
     */
    public static boolean Place(int t){
        boolean ok=true;
        //判断该位置的皇后是否与前面t-1个已经放置的皇后冲突
        for (int j = 1; j < t; j++) {
            //判断列、对角线是否冲突
            if(x[t]==x[j]||(t-j)==Math.abs(x[t]-x[j])){
                ok=false;
                break;
            }
        }
        return ok;
    }
    /**
     * 按约束条件搜索求解
     * t表示当前扩展结点在第t层.如果t>n,表示已经到达叶子节点,记录最优值和最优解,返回,否则,分别判断n个分支,x[t]=i;
     * 判断每个分支是否满足约束条件,如果满足则进入下一层Backtrack(t+1);如果不满足则考察下一个分支(兄弟结点)
     */
    public static void Backtrack(int t){
        //如果当前位置为n,则表示已经找到了问题的一个解
        if(t>n){
            countn++;
            //打印选择的路径
            for (int i = 1; i <= n; i++) {
                System.out.print(x[i]+" ");
            }
            System.out.println("--------------");
        }else {
            //分别判断n个分支
            for (int i = 1; i <= n; i++) {
                x[t]=i;
                if(Place(t)){
                    //如果不冲突则进行下一行搜索
                    Backtrack(t+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入皇后的个数n:");
        n=sc.nextInt();
        countn=0;
        Backtrack(1);
        System.out.println("答案的个数是:"+countn);
    }
}
