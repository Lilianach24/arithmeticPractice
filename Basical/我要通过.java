package basicLevel;

import java.util.Scanner;

public class 我要通过 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        while(n > 0){
            String str = sc.nextLine();
            //字符串只包含PTA，包含其他字母则错误
            if(str.contains("P")&& str.contains("A")&&str.contains("T")){
                //字符串中只包含一个P和一个T，且P T中间的A的个数乘以P前面A的个数等于P后面A的个数才符合题目要求,还有PT中间至少有一个A
                //记录首次P和T的位置
                int p = str.indexOf("P");
                int t = str.indexOf("T");
                //计算前中后A的个数
                int pre = 0, mid = 0, end = 0;
                boolean flag = false;
                for (int i = 0; i < str.length(); i++) {
                    if(i == p || i == t){
                        continue;
                    }
                    //如果出现其他字符,则该字符串不符合题目
                    if(str.charAt(i) != 'A'){
                        System.out.println("NO");
                        flag = true;
                        break;
                    }else{
                        if(i < p){
                            pre++;
                        }else if(i < t){
                            mid++;
                        }else{
                            end++;
                        }
                    }
                }
                //不包含其他字符
                if(!flag){
                    if((pre * mid == end) && mid != 0){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }else {
                System.out.println("NO");
            }
            n--;
        }
    }
}
