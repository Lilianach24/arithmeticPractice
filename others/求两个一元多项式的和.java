package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 求两个一元多项式的和。
 *
 * 输入格式:
 * 输入分2行，每行分别先给出多项式非零项的个数，再以指数递降方式输入一个多项式非零项系数和指数（绝对值均为不超过1000的整数）。数字间以空格分隔。
 *
 * 输出格式:
 * 输出分1行，分别以指数递降方式输出和多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。零多项式应输出0 0。
 */

/**
 * 多项式顺序表元素类型
 */
class polyElem{
    //系数
    int coef;
    //指数
    int exp;
    polyElem(int c,int e){
        coef=c;
        exp=e;
    }
}
public class 求两个一元多项式的和 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入第一行多项式
        int n=sc.nextInt();
        ArrayList<polyElem> poly1=new ArrayList<polyElem>();
        //系数和指数
        int co,ex;
        for (int i = 0; i < n; i++) {
            co=sc.nextInt();
            ex=sc.nextInt();
            poly1.add(new polyElem(co,ex));
        }
        //输入第二个多项式
        int m=sc.nextInt();
        ArrayList<polyElem> poly2=new ArrayList<polyElem>();
        for (int i = 0; i < m; i++) {
            co=sc.nextInt();
            ex=sc.nextInt();
            poly2.add(new polyElem(co,ex));
        }
        //定义存储求和的结果的顺序表
        ArrayList<polyElem> result=new ArrayList<polyElem>();
        int i=0,j=0;
        while (i<n&&j<m) {
            //如果第一个多项式或者第二个多项式的前面的项的系数不相等的话,就直接存储到结果表中,然后跳过这一项
            if(poly1.get(i).exp>poly2.get(j).exp){
                result.add(new polyElem(poly1.get(i).coef,poly1.get(i).exp));
                i++;
            }else if(poly1.get(i).exp<poly2.get(j).exp){
                result.add(new polyElem(poly2.get(j).coef,poly2.get(j).exp));
                j++;
            }
            //否则就计算和,然后将结果存储到结果表中
            else {
                int c=poly1.get(i).coef+poly2.get(j).coef;
                if(c!=0){
                    result.add(new polyElem(c,poly1.get(i).exp));
                }
                i++;
                j++;
            }
        }
        //最后将剩余的项存储到结果表中
        while (i<n){
            result.add(new polyElem(poly1.get(i).coef,poly1.get(i).exp));
            i++;
        }
        while (j<m){
            result.add(new polyElem(poly2.get(i).coef,poly2.get(i).exp));
            j++;
        }
        //最后输出结果
        if(result.size()==0){
            System.out.println("0 0");
        }else {
            for (int k = 0; k < result.size(); k++) {
                System.out.print(result.get(k).coef+" ");
                System.out.print(result.get(k).exp);
                if(k!=result.size()-1){
                    System.out.print(" ");
                }
            }
        }
    }
}
