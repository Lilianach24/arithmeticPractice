package basicLevel;

import java.io.*;
import java.util.Arrays;

/**
 * 月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类月饼的库存量、总售价、以及市场的最大需求量，请你计算可以获得的最大收益是多少。
 *
 * 注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有 3 种月饼，其库存量分别为 18、15、10 万吨，总售价分别为 75、72、45 亿元。如果市场的最大需求量只有 20 万吨，那么我们最大收益策略应该是卖出全部 15 万吨第 2 种月饼、以及 5 万吨第 3 种月饼，获得 72 + 45/2 = 94.5（亿元）。
 *
 * 输入格式：
 * 每个输入包含一个测试用例。每个测试用例先给出一个不超过 1000 的正整数 N 表示月饼的种类数、以及不超过 500（以万吨为单位）的正整数 D 表示市场最大需求量。随后一行给出 N 个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出 N 个正数表示每种月饼的总售价（以亿元为单位）。数字间以空格分隔。
 *
 * 输出格式：
 * 对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后 2 位。
 *
 * 输入样例：
 * 3 20
 * 18 15 10
 * 75 72 45
 * 输出样例：
 * 94.50
 */
public class 月饼 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bf.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int d = Integer.parseInt(data[1]);
        //每种月饼的总库存
        String[] stock = bf.readLine().split(" ");
        //每种月饼的总售价
        String[] total = bf.readLine().split(" ");
        //要用double存储数据,题目没有保证总库存是正整数,只是保证了为正数,要不然测试点2不能通过
        //计算出每一种月饼的单价
        double[] unit = new double[n];
        for (int i = 0; i < n; i++) {
            double s = Double.parseDouble(total[i]);
            double t = Double.parseDouble(stock[i]);
            unit[i] = s / t;
        }
        //计算最大收益
        double sum = 0;
        int i = 0, j = n - 1;
        while(d > 0){
            //找出目前单价最大的
            while (i < j){
                if(unit[i] < unit[j]){
                    i++;
                }else{
                    j--;
                }
            }
            double st = Double.parseDouble(stock[i]);
            //总需求量大于总库存
            if(d >= st){
                sum += unit[i] * st;
                d -= st;
            }else {
                sum += unit[i] * d;
                d = 0;
            }
            //计算过该单价后将该单价标记为0
            unit[i] = 0;
            //如果还有库存,则开始寻找次大的单价
            i = 0; j = n - 1;
        }
        System.out.printf("%.2f", sum);

    }
}
