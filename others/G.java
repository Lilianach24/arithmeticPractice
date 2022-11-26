package Unit1;

import java.util.Scanner;
import java.util.Stack;

public class G {
    public static boolean flag=false;
    public static boolean isSerial(int [] b,int n){
        int i,j;
        Stack<Integer> st=new Stack<Integer>();
        i=1;j=0;
        while(i<=n){
            st.push(i);
            i++;
            while(!st.isEmpty()&&st.peek()==b[j]){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        int[] b=new int[1005];
        while (sc.hasNext()){
            n=sc.nextInt();
            if(n==0){
                break;
            }
            if(flag){
                System.out.println();
            }
            while (sc.hasNext()){
                b[0]=sc.nextInt();
                if(b[0]==0){
                    break;
                }
                for (int i = 1; i < n; i++) {
                    b[i]=sc.nextInt();
                }
                if(isSerial(b, n)){
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
            flag = true;
        }
    }
}
