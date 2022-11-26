package test;

/**
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建，然后统计图书表中的图书个数，同时逐行输出
 * 每本图书的信息。
 *
 * 输入格式:
 * 输入n+1行，其中前n行是n本图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，价格之后没有空格。最后第
 * n+1行是输入结束标志：0 0 0（空格分隔的三个0）。其中书号和书名为字符串类型，价格为浮点数类型。
 *
 * 输出格式:
 * 总计n+1行，第1行是所创建的图书表中的图书个数，后n行是n本图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格
 * 分隔。其中价格输出保留两位小数。
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 图书顺序表
 */
class Book{
    String number;
    String name;
    float price;
    public Book(String num,String na,float pri){
        number=num;
        name=na;
        price=pri;
    }
}
public class 基于顺序存储结构的图书信息表的创建和输出 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义存储图书信息的顺序表
        ArrayList<Book> books=new ArrayList<Book>();
        while (sc.hasNext()){
            String number=sc.next();
            String name=sc.next();
            float price=sc.nextFloat();
            if("0".equals(number) && "0".equals(name) &&price==0){
                break;
            }
            books.add(new Book(number,name,price));
        }
        //输出图书的个数
        System.out.println(books.size());
        //输出图书信息
        for (Book book : books) {
            System.out.printf("%s %s %.2f\n",book.number,book.name,book.price);
        }
    }
}
