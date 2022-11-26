package competition;

import java.io.*;

/**
 * 一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
 *
 * 首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；然后将计算的和对11取模得到值Z；最后按照以下关系对应Z值与校验码M的值：
 *
 * Z：0 1 2 3 4 5 6 7 8 9 10
 * M：1 0 X 9 8 7 6 5 4 3 2
 * 现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。
 *
 * 输入格式：
 * 输入第一行给出正整数N（≤100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。
 *
 * 输出格式：
 * 按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常，则输出All passed。
 *
 * 输入样例1：
 * 4
 * 320124198808240056
 * 12010X198901011234
 * 110108196711301866
 * 37070419881216001X
 * 输出样例1：
 * 12010X198901011234
 * 110108196711301866
 * 37070419881216001X
 * 输入样例2：
 * 2
 * 320124198808240056
 * 110108196711301862
 * 输出样例2：
 * All passed
 */
public class 查验身份证 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //权重
        int[] weight = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        //校验码M
        char[] m = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        //计算合格的身份证的个数
        int count = 0;
        int s = n;
        while(s > 0) {
            //输入身份证
            String ID = bf.readLine();
            char[] id = ID.toCharArray();
            //验证身份证最后一位校验码是否计算正确
            int sum = 0;
            //验证身份证前17位是否全为数字
            boolean flag = true;
            for (int i = 0; i < id.length - 1; i++) {
                //身份证不合格
                if(id[i] > '9' || id[i] < '0'){
                    flag = false;
                    System.out.println(ID);
                    break;
                }
                //计算前17位的加权和
                sum += weight[i] * (id[i] - '0');
            }
            //如果前面17位符合标准且校验位正确
            if (id[id.length - 1] == m[sum % 11] && flag){
                count++;
            }
            //如果前面17位符合标准而最后的校验位不正确
            else if(flag){
                System.out.println(ID);
            }
            s--;
        }
        if (n == count){
            System.out.println("All passed");
        }
    }
}
