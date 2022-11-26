package Unit1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 标准的web浏览器包含在最近访问的页面中向前和向后移动的功能。实现这些特性的一种方法是使用两个堆栈来跟踪通过向前和向后移动可以到达的页
 * 面。在这个问题中，要求您实现这个。
 * 需要支持以下命令:
 *
 * BACK:将当前页面推到前向堆栈的顶部。从向后堆栈的顶部弹出页面，使其成为新的当前页面。如果反向堆栈为空，该命令将被忽略。
 * FORWARD:将当前页面推到向后堆栈的顶部。从forward堆栈的顶部弹出该页，使其成为新的当前页。如果forward栈为空，则忽略该命令。
 * VISIT:将当前页面推到向后堆栈的顶部，并使URL指定新的当前页面。前向堆栈被清空。
 * QUIT:退出浏览器。
 * 假设浏览器最初加载URL为http://www.acm.org/的网页
 *
 * Input
 * 输入是一系列命令。命令关键字BACK、FORWARD、VISIT和QUIT均为大写。url没有空格，最多70个字符。您可以假设任何时候每个堆栈中都不需要超
 * 过100个元素。输入的结束由QUIT命令指示。
 * Output
 * For each command other than QUIT, print the URL of the current page after the command is executed if the command is
 * not ignored. Otherwise, print "Ignored". The output for each command should be printed on its own line. No output is
 * produced for the QUIT command.
 */
public class K {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //定义一个后向栈
        Stack<String> stBk= new Stack<String>();
        //定义一个前向栈
        Stack<String> stFw=new Stack<String>();
        //初始页面
        String curp="http://www.acm.org/";
        while (sc.hasNext()){
            String str=sc.nextLine();
            //QUIT命令退出
            if(str.startsWith("QUIT")){
                break;
            }
            //VISIT命令
            if(str.startsWith("VISIT")){
                if(stBk.size()<=100){
                    //将当前页面进入后向栈作为栈顶
                    stBk.push(curp);
                    //清空前向栈
                    stFw.clear();
                }
                //跳过开头的VISIT和空格
                curp=str.substring(6);
                System.out.println(curp);
            }
            //FORWARD命令
            if(str.startsWith("FORWARD")){
                //判断向前栈是否为空
                if(!stFw.empty()){
                    //将当前页面进入后向栈并作为栈顶
                    stBk.push(curp);
                    //从前向栈中出栈栈顶的页面,使其成为新的当前页面
                    curp=stFw.peek();
                    stFw.pop();
                    System.out.println(curp);
                }else {
                    System.out.println("Ignored");
                }

            }
            //BACK命令
            if(str.startsWith("BACK")){
                //判断向后栈是否为空
                if(!stBk.empty()){
                    //将当前页面进入向前栈作为栈顶
                    stFw.push(curp);
                    //从向后栈中出栈栈顶的页面,使其成为新的当前的页面
                    curp=stBk.peek();
                    stBk.pop();
                    System.out.println(curp);
                }else {
                    System.out.println("Ignored");
                }
            }
        }
    }
}
