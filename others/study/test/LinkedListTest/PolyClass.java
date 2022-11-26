package test.LinkedListTest;

/**
 * 求解两个多项式相加
 */

import java.io.*;
import java.util.*;

/**
 * 在多项式顺序表中,每个多项式项作为多项式顺序表的一个元素,多项式顺序表元素类型类定义:
 */
class PolyElem{
    //系数
    double coef;
    //指数
    int exp;
    //构造方法
    PolyElem(double c,int e){
        coef=c;
        exp=e;
    }
    //返回exp
    public int getExp(){
        return exp;
    }
}

/**
 * 多项式顺序表类的定义:
 */
class PolyClass {
    /**
     * 存放多项式顺序表
     */
    ArrayList<PolyElem> poly;
    public PolyClass(){
        //分配顺序表的data空间
        poly=new ArrayList<PolyElem>();
    }

    /**
     * 在顺序表末尾添加元素
     */
    public void add(PolyElem p){
        poly.add(p);
    }

    /**
     * 创建多项式顺序表
     * 由a[0..n-1](系数数组)和b[0..n-1](指数数组)创建多项式顺序表poly,遍历a,b的元素来创建多项式
     */
    public void createPoly(double[] a,int[] b,int n){
        for (int i = 0; i < n; i++) {
            poly.add(new PolyElem(a[i],b[i]));
        }
    }

    /**
     * 按exp成员递减排序
     */
    public void sort(){
        poly.sort(Comparator.comparing(PolyElem::getExp).reversed());
    }

    /**
     * 输出多项式顺序表
     */
    public void dispPoly(){
        //first为true表示为第一项
        boolean first=true;
        int i=0;
        while (i<poly.size()){
            PolyElem p=poly.get(i);
            if(first){
                first=false;
            }else if(p.coef==0){
                //指数为0时不输出x
                System.out.print(p.coef);
            }else if(p.exp==1){
                //指数为1时不输出指数
                System.out.print(p.coef+"x");
            }else {
                System.out.print(p.coef+"x"+p.exp);
            }
            i++;
        }
        System.out.println();
    }

    /**
     * 实现两个有序多项式顺序表L1和L2的相加运算,并返回相加的结果多项式顺序表
     */
    public static PolyClass Add(PolyClass L1,PolyClass L2){
        int i=0,j=0;
        double c;
        PolyClass L3=new PolyClass();
        while (i<L1.poly.size()&&j<L2.poly.size()){
            //L1的指数比较大
            if(L1.poly.get(i).exp>L2.poly.get(i).exp){
                L3.add(new PolyElem(L1.poly.get(i).coef,L1.poly.get(i).exp));
                i++;
            }
            //L2的元素指数比较大
            else if(L1.poly.get(i).exp<L2.poly.get(i).exp){
                L3.add(new PolyElem(L2.poly.get(i).coef,L2.poly.get(i).exp));
                j++;
            }
            //两数元素的指数相等
            else {
                c=L1.poly.get(i).coef+L2.poly.get(i).coef;
                if(c!=0){
                    L3.add(new PolyElem(c,L1.poly.get(i).exp));
                }
                i++;
                j++;
            }
        }
        while (i<L1.poly.size()){
            L3.add(new PolyElem(L1.poly.get(i).coef,L1.poly.get(i).exp));
            i++;
        }
        while (j<L2.poly.size()){
            L3.add(new PolyElem(L2.poly.get(i).coef,L2.poly.get(i).exp));
            j++;
        }
        return L3;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //将标准输入流重定向至abc.in
        System.setIn(new FileInputStream("abc.in"));
        Scanner fin=new Scanner(System.in);
        //将标准输出流重定向至abc.out
        System.setOut(new PrintStream("abc.out"));
        //建立两个多项式顺序表对象L1和L2
        PolyClass L1=new PolyClass();
        PolyClass L2=new PolyClass();
        PolyClass L3;
        double[] a=new double[100];
        int[] b=new int[100];
        int n;
        n=fin.nextInt();
        for (int i = 0; i < n; i++) {
            a[i]=fin.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            b[i]=fin.nextInt();
        }
        //创建第一个多项式顺序表L1
        L1.createPoly(a,b,n);
        System.out.print("第一个多项式:   ");
        L1.dispPoly();
        L1.sort();
        System.out.print("排序后结果:    ");
        L1.dispPoly();
        n=fin.nextInt();
        for (int i = 0; i < n; i++) {
            a[i]=fin.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            b[i]=fin.nextInt();
        }
        //创建第二个多项式顺序表L2
        L2.createPoly(a,b,n);
        System.out.print("第二个多项式:    ");
        L2.dispPoly();
        L2.sort();
        System.out.print("排序后结果:    ");
        L2.dispPoly();
        //两个多项式相加
        L3=Add(L1,L2);
        System.out.println("相加后多项式: ");
        L3.dispPoly();
    }
}
