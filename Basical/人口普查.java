package basicLevel;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。
 *
 * 这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过 200 岁的老人，而今天是 2014 年 9 月 6 日，所以超过 200 岁的生日和未出生的生日都是不合理的，应该被过滤掉。
 *
 * 输入格式：
 * 输入在第一行给出正整数 N，取值在(0,10
 * 5
 *  ]；随后 N 行，每行给出 1 个人的姓名（由不超过 5 个英文字母组成的字符串）、以及按 yyyy/mm/dd（即年/月/日）格式给出的生日。题目保证最年长和最年轻的人没有并列。
 *
 * 输出格式：
 * 在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。
 *
 * 输入样例：
 * 5
 * John 2001/05/12
 * Tom 1814/09/06
 * Ann 2121/01/30
 * James 1814/09/05
 * Steve 1967/11/20
 * 输出样例：
 * 3 Tom John
 */
public class 人口普查 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //今天的时间
        Date now = sdf.parse("2014/09/06");
        //计算有效生日的人的姓名和年龄
        int count = 0;
        int max = 0, min = 200 * 365;
        String maxNa = "", minNa = "";
        while(n > 0){
            String[] line = bf.readLine().split(" ");
            Date birth = sdf.parse(line[1]);
            //有效生日
            if(birth.before(now)){
                int days = (int) ((now.getTime() - birth.getTime()) / (24 * 60 * 60 * 1000));
                if(days <= 73049){
                    count++;
                    if(days > max){
                        max = days;
                        maxNa = line[0];
                    }
                    if(days < min){
                        min = days;
                        minNa = line[0];
                    }
                }
            }
            n--;
        }
        //输出
        System.out.println(count + " " + maxNa + " " + minNa);
    }
}
