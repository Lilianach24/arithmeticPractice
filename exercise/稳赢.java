package competition;

import java.util.Scanner;

public class 稳赢 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //next()以及nextInt()不读取"\n",并将cursor放在本行中,所以可以在一行以空格分割多个输入
        String type = sc.nextLine();
        int count = 1;
        while(!"End".equals(type) && sc.hasNextLine()){
            if(count % (n + 1) != 0){
                if("ChuiZi".equals(type)){
                    System.out.println("Bu");
                }else if("JianDao".equals(type)){
                    System.out.println("ChuiZi");
                }else{
                    System.out.println("JianDao");
                }
            }else{
                System.out.println(type);
            }
            count++;
            type = sc.nextLine();
        }
    }
}
