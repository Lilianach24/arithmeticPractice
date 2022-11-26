package 试题集.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。
 * 　　比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
 * 　　所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
 * 　　十二亿三千四百五十六万七千零九
 * 　　用汉语拼音表示为
 * 　　shi er yi san qian si bai wu shi liu wan qi qian ling jiu
 * 　　这样他只需要照着念就可以了。
 * 　　你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。
 * 　　注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
 * 输入格式
 * 　　有一个数字串，数值大小不超过2,000,000,000。
 * 输出格式
 * 　　是一个由小写英文字母，逗号和空格组成的字符串，表示该数的英文读法。
 */
public class 数的读法 {
    public static StringBuilder change(String str){
        //对于每个数字的读法转换
        String[] num={"ling ","yi ","er ","san ","si ","wu ","liu ","qi ","ba ","jiu "};
        // 对于每一个位置上的数字对应的单位
        String[] dan={"","shi ","bai ","qian ","wan ","shi ","bai ","qian ","yi ","shi "};
        //结果字符串
        StringBuilder res= new StringBuilder();
        boolean flag=true;
        for (int i = 0; i < str.length(); i++) {
            int x=str.charAt(i)-'0';
            //十位数,六位数,二位数,且第一个字符为1都读作"shi"
            if((str.length()+2)%4==0&&i==0&&x==1){
                res.append(dan[str.length()-i-1]);
            }
            //不是最后一个字符且为0,有多个连续的0只需要读一个"ling"
            else if(i!=str.length()-1&&x==0){
                //还没有添加"ling"
                if(flag){
                    res.append(num[x]);
                    //已经添加"ling"
                    flag=false;
                }
            }
             //最后一个字符为0,则需要去掉"ling"
             else if(i==str.length()-1&&x==0){
                    //如果已经添加了"ling"
                    if(!flag){
                        res.replace(res.length()-5,res.length(),"");
                    }
             }
            //其他为普通字符
            else {
                res.append(num[x]).append(dan[str.length()-i-1]);
                //并且出现了数字,则后面可以接"ling"
                flag=true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(change(str));
    }
}
