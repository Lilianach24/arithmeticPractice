package Unit1;

import java.util.*;

/**
 * 读入一个只包含 +, -, *, / 的非负整数计算表达式，计算该表达式的值。
 * Input
 * 测试输入包含若干测试用例，每个测试用例占一行，每行不超过200个字符，整数和运算符之间用一个空格分隔。没有非法表达式。
 * 当一行中只有0时输入结束，相应的结果不要输出。
 * Output
 * 对每个测试用例输出1行，即该表达式的值，精确到小数点后2位。
 */
public class F {
    /**
     * 定义运算符栈
     */
    static Stack<String> opor=new Stack<String>();
    /**
     * 定义运算数栈
     */
    static Stack<Double> opand=new Stack<Double>();

    /**
     * 定义一个计算方法
     * @param op
     */
    public static void getValue(String op){
        double a,b,c;
        //从运算数栈中取出两个数并根据相应的运算符计算
        a=opand.pop();
        b=opand.pop();
        switch (op){
            case "+":
                c=b+a;
                break;
            case "-":
                c=b-a;
                break;
            case "*":
                c=b*a;
                break;
            default:
                c=b/a;
                break;
        }
        //计算所得结果存入运算数栈
        opand.push(c);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            //当输入0时结束
            if("0".equals(str)){
                break;
            }else {
                //清空栈
                opand.clear();
                opor.clear();
                //将表达式存入算数表达式字符串数组
                String[] exp=str.split(" ");
                //定义运算符临时变量
                String op;
                int i=0;
                while (i<exp.length){
                    //判定为"*"或"/"运算符
                    if("*".equals(exp[i])||"/".equals(exp[i])){
                        while (!opor.empty()){
                            op=opor.peek();
                            //如果栈顶元素为"*"或"/",则退栈并计算结果存入运算数栈中
                            if("*".equals(op) || "/".equals(op)){
                                getValue(op);
                                opor.pop();
                            }else {
                                break;
                            }
                        }
                        //再将"*"或"/"进栈
                        opor.push(exp[i]);
                    }
                    //判定为"+"或"-"运算符
                    else if("+".equals(exp[i])||"-".equals(exp[i])){
                        while (!opor.empty()){
                            //乘除运算计算完毕之后计算加减,直接进行计算并将结果存入运算数栈
                            op=opor.pop();
                            getValue(op);
                        }
                        //再将"+"或"-"进栈
                        opor.push(exp[i]);
                    }
                    //判定为数字字符,则直接将字符串形式的数字转换为数字类型的数字
                    else {
                        opand.push(Double.parseDouble(exp[i]));
                    }
                    i++;
                }
                //exp扫描完毕,栈不空时循环
                while (!opor.empty()){
                    op=opor.pop();
                    getValue(op);
                }
                System.out.printf("%.2f",opand.peek());
                System.out.println();
            }
        }
    }
}
