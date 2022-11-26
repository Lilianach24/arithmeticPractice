package test;

import java.util.*;

/**
 * 一个简单的行编辑程序的功能是：接受用户从终端输入的程序或数据，并存入用户的数据区。 由于用户在终端上进行输入时，不能保证不出差错，因
 * 此，若在编辑程序中，“每接受一个字符即存入用户数据区”的做法显然不是最恰当的。较好的做法是，设立一个输入缓冲区，用以接受用户输入的一
 * 行字符，然后逐行存入用户数据区。允许用户输入出差错，并在发现有误时可以及时更正。例如，当用户发现刚刚键入的一个字符是错的时，可补进
 * 一个退格符"#"，以表示前一个字符无效； 如果发现当前键入的行内差错较多或难以补救，则可以键入一个退行符"@"，以表示当前行中的字符均无
 * 效。 如果已经在行首继续输入'#'符号无效。
 *
 * 输入格式:
 * 输入一个多行的字符序列。但行字符总数（包含退格符和退行符）不大于250。
 *
 * 输出格式:
 * 按照上述说明得到的输出。
 */
public class 行编辑器 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入字符串
        String str=sc.nextLine();
        char[] chars=str.toCharArray();
        Stack<Character> st=new Stack<Character>();
        for (char aChar : chars) {
            /*if (!st.empty() && aChar == '#') {
                st.pop();
            } else if (aChar == '@') {
                st.clear();
            } else {
                st.push(aChar);
            }*/
            if(aChar!='#'){
                st.push(aChar);
            }else if(!st.empty()){
                st.pop();
            }
            if(aChar=='@'){
                st.clear();
            }
        }

        StringBuffer res= new StringBuffer();
        while (!st.empty()) {
            res.append(st.pop());
        }
        System.out.println(res.reverse());
    }
}
