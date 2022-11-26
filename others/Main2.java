package test2;

import java.util.*;

public class Main2 {
    public static boolean vis[];
    public static int arr[][];
    public static int N,E;
    public static int start,end;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        E=sc.nextInt();
        arr=new int[N][N];
        vis=new boolean[N];
        for (int i = 0; i < E; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a][b]=1;
            arr[b][a]=1;
        }
        start=sc.nextInt();
        end=sc.nextInt();

        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        vis[start]=true;
        while (!q.isEmpty()){
            int target=q.poll();
            if(start==end){
                System.out.printf("There is a path between %d and %d.\n",start,end);
                return;
            }
            for (int k = 0; k < N; k++) {
                if(arr[target][k]==1&&vis[k]){
                    q.offer(k);
                    vis[k]=true;
                }
            }
        }
        System.out.printf("There is no path between %d and %d.\n",start,end);
    }
}
