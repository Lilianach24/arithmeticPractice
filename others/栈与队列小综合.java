package work;

import java.util.*;

/**
 * 将line中的字符依次入栈，然后输出栈中元素个数与栈顶元素。
 * 输入一个字符x(待删除字符)。然后将栈中元素依次出栈并输出，出栈时将不等于x的字符依次入队列，以空格分隔。
 * 输出队列元素个数，队头与队尾，以空格分隔。
 * 最后输出队列中所有元素。
 */
public class 栈与队列小综合 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.next();
        String x=sc.next();
        Queue<Character> qu=new LinkedList<>();
    }
}
