package test;

/**
 * 本题目要实现平面点的二维几何变换，读入点的坐标，变换的类型和参数，然后输出变换后的几何坐标。
 *
 * 输入格式:
 * 点的平面坐标成对出现， 两个数值之间以逗号隔开，数据类型为整型。变换类型以整型数字表示，1，2，3分别对应平移、缩放和旋转。平移参数为
 * 坐标对形式，中间以逗号隔开，数据类型为double类型。缩放两个参数以逗号隔开，类型double。旋转以角度表示旋转角度，正值为逆时针，负值代
 * 表顺时针，整型。
 *
 * 输出格式:
 * 输出为旋转后的点的坐标，坐标对之间以逗号隔开，整型。
 */

import java.util.Scanner;

public class 利用数组实现平面点的几何变换 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入两个坐标点
        String str=sc.nextLine();
        String[] num=str.split(",");
        double x= Double.parseDouble(num[0]);
        double y= Double.parseDouble(num[1]);
        //输入变换的类型
        int p=sc.nextInt();
        //p为1表示平移
        if(p==1){
            //输入平移的大小
            String str2=sc.nextLine();
            String[] num2=str2.split(",");
            double xi= Double.parseDouble(num2[0]);
            double yi= Double.parseDouble(num2[1]);
            System.out.printf("%d,%d\n",(int)(x+xi),(int)(y+yi));
        }
        //p为2表示缩放
        else if(p==2){
            //输入缩放的大小
            String str2=sc.nextLine();
            String[] num2=str2.split(",");
            double xi= Double.parseDouble(num2[0]);
            double yi= Double.parseDouble(num2[1]);
            System.out.printf("%d,%d\n",(int)(x*xi),(int)(y*yi));
        }
        //p为3表示旋转
        else if(p==3){
            //输入旋转的角度
            double angle=Double.parseDouble(sc.nextLine());
            double an=angle/180*Math.PI;
            System.out.printf("%d,%d\n",(int)(x*Math.cos(an)-y*Math.sin(an)),(int)(x*Math.sin(an)+y*Math.cos(an)));
        }else {
            System.out.println("transform type error!");
        }
    }
}
