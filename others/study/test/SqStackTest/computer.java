package test.SqStackTest;

import java.util.Stack;

/**
 * @author cl
 *
 * 用户输入一个仅包含+、-、*、/、正整数和小括号的合法数学表达式，计算该表达式的结果
 */
public class computer {
    /**
     * 存放中缀表达式
     */
    String exp;
    /**
     * 存放后缀表达式
     */
    String postexp="";
    /**
     * 设置exp
     */
    public void Setexp(String str){
        exp=str;
    }
    /**
     * 取postexp
     */
    public String getPostexp() {
        return postexp;
    }
    /**
     * 将算术表达式exp转换成后缀表达式postexp
     */
    public void Trans(){
        //运算符栈
        Stack<Character> opor=new Stack<Character>();
        char ch,e;
        int i=0;
        while (i<exp.length()){
            //从exp读取字符
            ch=exp.charAt(i);
            //ch为左括号'(': 将'('进栈到opor
            if(ch=='('){
                opor.push(ch);
            }
            //ch为右括号')' : 将opor栈中'('以前的运算符依次出栈并存放到postexp中,再将'('退栈
            else if(ch==')'){
                while (opor.peek()!='(' && !opor.empty()){
                    e=opor.pop();
                    postexp+=e;
                }
                //将'(退栈
                opor.pop();
            }
            //ch为'+'或'-' : 将opor栈中'('以前所有的运算符出栈并存放到postexp中,再将'+'或'-'进栈
            else if(ch=='+'||ch=='-'){
                while (!opor.empty() && opor.peek()!='('){
                    e=opor.pop();
                    postexp += e;
                }
                opor.push(ch);
            }
            //ch为'*'或'/' : 将opor栈中'('以前的'*'或'/'运算符出栈并存放到postexp中,再将'*'或'/'进栈
            else if(ch=='*'||ch=='/'){
                while (!opor.empty()&&opor.peek()!='('&&(opor.peek()=='*'||opor.peek()=='/')){
                    e=opor.pop();
                    postexp+=e;
                }
                opor.push(ch);
            }
            //若ch为数字,则将后续的所有数字依次存放到postexp中,并以字符'#'标志运算数串结束
            else {
                while (ch>='0'&&ch<='9'){
                    postexp+=ch;
                    //将连续的数字放入postexp
                    i++;
                    if(i<exp.length()){
                        ch=exp.charAt(i);
                    }else {
                        break;
                    }
                }
                //退一个字符
                i--;
                //用#标识一个数值串的结束
                postexp+='#';
            }
            i++;
        }
        //字符串扫描完毕,退栈opor的所有运算符并存放到postexp中
        while (!opor.empty()){
            e=opor.pop();
            postexp+=e;
        }
    }
    /**
     * 计算postexp的值
     */
    public double getValue(){
        //运算数栈
        Stack<Double> opand=new Stack<>();
        double a,b,c,d;
        char ch;
        int i=0;
        while (i<postexp.length()){
            //从postexp读取字符ch
            ch=postexp.charAt(i);
            switch (ch){
                //ch为'+' : 从opand栈出栈两个运算数a和b,计算c=a+b,将c进栈
                case '+':
                    a=opand.pop();
                    b=opand.pop();
                    c=b+a;
                    opand.push(c);
                    break;
                //ch为'-' : 从opand栈出栈两个运算数a和b,计算c=a-b,将c进栈
                case '-':
                    a=opand.pop();
                    b=opand.pop();
                    c=b-a;
                    opand.push(c);
                    break;
                //ch为'*' : 从opand栈出栈两个运算数a和b,计算c=a*b,将c进栈
                case '*':
                    a=opand.pop();
                    b=opand.pop();
                    c=b*a;
                    opand.push(c);
                    break;
                //ch为'/' : 从opand栈出栈两个运算数a和b,若a不为0,计算c=a/b,将c进栈
                case '/':
                    a=opand.pop();
                    b=opand.pop();
                    if(a!=0){
                        c=b/a;
                        opand.push(c);
                    }else {
                        throw new ArithmeticException("运算错误:除零");
                    }
                    break;
                //ch为数字字符: 将连续的数字串转换成运算数d,将d进栈
                default:
                    d=0;
                    //判定为数字字符
                    while (ch>='0'&&ch<='9'){
                        d=10*d+(ch-'0');
                        i++;
                        ch=postexp.charAt(i);
                    }
                    opand.push(d);
                    break;
            }
            i++;
        }
        //opand栈中唯一的运算数即为表达式值
        return opand.peek();
    }

}
