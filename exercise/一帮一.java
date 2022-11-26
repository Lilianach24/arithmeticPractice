package competition;

import java.io.*;

/**
 * “一帮一学习小组”是中小学中常见的学习组织方式，老师把学习成绩靠前的学生跟学习成绩靠后的学生排在一组。本题就请你编写程序帮助老师自动完成这个分配工作，即在得到全班学生的排名后，在当前尚未分组的学生中，将名次最靠前的学生与名次最靠后的异性学生分为一组。
 *
 * 输入格式：
 * 输入第一行给出正偶数N（≤50），即全班学生的人数。此后N行，按照名次从高到低的顺序给出每个学生的性别（0代表女生，1代表男生）和姓名（不超过8个英文字母的非空字符串），其间以1个空格分隔。这里保证本班男女比例是1:1，并且没有并列名次。
 *
 * 输出格式：
 * 每行输出一组两个学生的姓名，其间以1个空格分隔。名次高的学生在前，名次低的学生在后。小组的输出顺序按照前面学生的名次从高到低排列。
 *
 * 输入样例：
 * 8
 * 0 Amy
 * 1 Tom
 * 1 Bill
 * 0 Cindy
 * 0 Maya
 * 1 John
 * 1 Jack
 * 0 Linda
 * 输出样例：
 * Amy Jack
 * Tom Linda
 * Bill Maya
 * Cindy John
 */
public class 一帮一 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //存储学生姓名性别的数组,前两列存储排在前面一半的学生的姓名和性别,后两列存储小组的另一个成员
        String[][] stu = new String[n / 2][3];
        for (int i = 0; i < n / 2; i++) {
            String[] line = bf.readLine().split(" ");
            stu[i][0] = line[0];
            stu[i][1] = line[1];
        }
        //排在后半部分的人,根据性别分别放在两个数组中
        String[] man = new String[n / 2];
        String[] woman = new String[n / 2];
        int w = 0, m = 0;
        for (int i = 0; i < n / 2; i++) {
            String[] line = bf.readLine().split(" ");
            if("0".equals(line[0])){
                woman[w++] = line[1];
            }
            if("1".equals(line[0])){
                man[m++] = line[1];
            }
        }
        int w2 = 0, m2 = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            //女生要找男生成一组
            if("0".equals(stu[i][0])){
                stu[i][2] = man[m2++];
            }
            //男生要找女生成一组
            if("1".equals(stu[i][0])){
                stu[i][2] = woman[w2++];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            System.out.println(stu[i][1] + " " + stu[i][2]);
        }
    }
}
