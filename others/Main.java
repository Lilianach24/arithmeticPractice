package work;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        //分别记录最大长度，起始位置，长度
        int maxlen=0,location=0,length=0;
        //输入空字符串,输出null
        if("".equals(str)){
            System.out.println("NULL");
        }
        //否则循环遍历字符串
        else {
            for (int i = 0; i < str.length(); i++) {
                char c=str.charAt(i);
                //如果是数字，则计算数字的长度
                if(c>='0'&&c<='9'){
                    length++;
                }
                //如果不是数字,则比较此段数字序列是否比上一段数字序列长
                if(c<'0'||c>'9'){
                    //如果最长数字序列要比此次记录的长度要短,则将这个长度赋值给最长长度,并记录起始位置
                    if(maxlen<length){
                        maxlen=length;
                        location=i-length;
                    }
                    //将长度重新赋值为0,计算下一段数字序列
                    length=0;
                }
            }
            //这里还需要比较最后记录的长度是否比最大长度要大,然后对最长长度和起始位置做出改动
            if(length>maxlen){
                maxlen=length;
                location=str.length()-maxlen;
            }
            //最后输出
            System.out.println(location+" "+maxlen);
        }
    }
}
