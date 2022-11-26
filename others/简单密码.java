package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Julius Caesar曾经使用过一种很简单的密码。对于明文中的每个字符，将它用它字母表中后5位对应的字符来代替，这样就得到了密文。比如字符A
 * 用F来代替。如下是密文和明文中字符的对应关系。
 *
 * 密文 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 *
 * 明文 V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 *
 * 你的任务是对给定的密文进行解密得到明文。 你需要注意的是，密文中出现的字母都是大写 字母。密文中也包括非字母的字符，对这些字符不用进行解码。
 *
 * 输入格式:
 * 输入一行密文字符串，可包含空格。
 *
 * 输出格式:
 * 输出明文字符串。输入明文字符串为空时，输出“NULL”
 */
public class 简单密码 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        //如果输入字符串为空时
        if("".equals(str)){
            System.out.println("NULL");
        }
        //否则输出明文
        else {
            //定义顺序表
            ArrayList<Character> code=new ArrayList<Character>();
            //将字符串中的数据存储到顺序表中
            for (int i = 0; i < str.length(); i++) {
                code.add(str.charAt(i));
                //解密,即将密文中的所有字母向前移动5位
                if(code.get(i)>'E'&&code.get(i)<='Z'){
                    code.set(i, (char) (code.get(i)-5));
                }else if(code.get(i)>='A'&&code.get(i)<='E'){
                    code.set(i, (char) (code.get(i)+21));
                }
            }
            //输出明文
            for (Character character : code) {
                System.out.print(character);
            }
        }
    }
}
