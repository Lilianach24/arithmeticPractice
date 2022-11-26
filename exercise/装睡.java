package competition;

import java.io.*;

public class 装睡 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        while(n > 0){
            String[] line = bf.readLine().split(" ");
            int h = Integer.parseInt(line[1]);
            int m = Integer.parseInt(line[2]);
            if(h < 15 || h > 20 || m < 50 || m > 70){
                System.out.println(line[0]);
            }
            n--;
        }
    }
}
