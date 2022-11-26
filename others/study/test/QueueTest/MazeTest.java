package test.QueueTest;

public class MazeTest {
    public static void main(String[] args) {
        int[][] a={
                {1,1,1,1,1,1},{1,0,1,0,0,1},
                {1,0,0,1,1,1},{1,0,1,0,0,1},
                {1,0,0,0,0,1},{1,1,1,1,1,1}};
        Maze mz=new Maze(6, 6);
        mz.setMg(a);
        if(!mz.mgpath(1,1,4,4)){
            System.out.println("不存在迷宫路径!");
        }
    }
}
