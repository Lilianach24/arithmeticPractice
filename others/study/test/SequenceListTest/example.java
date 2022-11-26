package test.SequenceListTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 设计一个算法，将两个有序递增的整数顺序表的全部元素合并到一个递增有序生疏顺序表C中，并采用相关数据测试
 */
public class Eaxmple {
    public static ArrayList<Integer> Merge(ArrayList<Integer> A,ArrayList<Integer> B){
        ArrayList<Integer> C=new ArrayList<Integer>();
        //i用于遍历A，j用于遍历B
        int i=0,j=0;
        //两个表均没有遍历完毕
        while (i<A.size()&&j<B.size()){
            //将较小的数放入C中
            if(A.get(i)<B.get(j)){
                C.add(A.get(i));
                i++;
            }else {
                C.add(B.get(j));
                j++;
            }
        }
        //A表没有遍历完毕
        while (i<A.size()){
            C.add(A.get(i));
            i++;
        }
        //B表没有遍历完毕
        while (j<B.size()){
            C.add(B.get(j));
            j++;
        }
        return C;
    }

    public static void main(String[] args) {
        Integer[] a={1,3,5,7};
        //由数组a构造A
        ArrayList<Integer> A=new ArrayList<Integer>(Arrays.asList(a));
        System.out.println("A:"+A);
        Integer[] b={1,2,5,7,9,10,20};
        //由数组b构造B
        ArrayList<Integer> B=new ArrayList<Integer>(Arrays.asList(b));
        System.out.println("B:"+B);
        System.out.println("二路归并");
        ArrayList<Integer> C=Merge(A,B);
        System.out.println("C:"+C);
    }
}
