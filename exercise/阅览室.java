package competition;

/**
 * 天梯图书阅览室请你编写一个简单的图书借阅统计程序。当读者借书时，管理员输入书号并按下S键，程序开始计时；当读者还书时，管理员输入书号并按下E键，程序结束计时。书号为不超过1000的正整数。当管理员将0作为书号输入时，表示一天工作结束，你的程序应输出当天的读者借书次数和平均阅读时间。
 *
 * 注意：由于线路偶尔会有故障，可能出现不完整的纪录，即只有S没有E，或者只有E没有S的纪录，系统应能自动忽略这种无效纪录。另外，题目保证书号是书的唯一标识，同一本书在任何时间区间内只可能被一位读者借阅。
 *
 * 输入格式：
 * 输入在第一行给出一个正整数N（≤10），随后给出N天的纪录。每天的纪录由若干次借阅操作组成，每次操作占一行，格式为：
 *
 * 书号（[1, 1000]内的整数） 键值（S或E） 发生时间（hh:mm，其中hh是[0,23]内的整数，mm是[0, 59]内整数）
 *
 * 每一天的纪录保证按时间递增的顺序给出。
 *
 * 输出格式：
 * 对每天的纪录，在一行中输出当天的读者借书次数和平均阅读时间（以分钟为单位的精确到个位的整数时间）。
 *
 * 输入样例：
 * 3
 * 1 S 08:10
 * 2 S 08:35
 * 1 E 10:00
 * 2 E 13:16
 * 0 S 17:00
 * 0 S 17:00
 * 3 E 08:10
 * 1 S 08:20
 * 2 S 09:00
 * 1 E 09:20
 * 0 E 17:00
 * 输出样例：
 * 2 196
 * 0 0
 * 1 60
 */


import java.io.*;
import java.util.HashMap;

/**
 * 借阅书类
 */
class book{
    //书号
    String bookId;
    //借阅类型, 借书还是还书
    String tpye;
    //借阅时间
    String time;
    public book(String bookId, String tpye, String time){
        bookId = this.bookId;
        tpye = this.tpye;
        time = this.time;
    }
}
public class 阅览室 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //定义一个HashMap,用于记录读者借阅还没有还的书籍
        HashMap<Integer, String> map = new HashMap<>();
        //记录读者借阅次数
        int count = 0;
        //计算总每天的阅读时间
        int sum = 0;
        while(n > 0){
            String[] line = bf.readLine().split(" ");
            int bookId = Integer.parseInt(line[0]);
            //当输入书号为0表示结束一天的工作
            if(bookId == 0){
                //计算这一天当中读者阅读次数和平均阅读时间
                if(sum == 0){
                    System.out.println(count + " " + 0);
                }else{
                    System.out.println(count + " " + (int)Math.round(1.0 * sum / count));
                }
                //清空map,开始计算新的一天的记录
                map.clear();
                count = 0;
                sum = 0;
                n--;
                continue;
            }
            //如果有多个借书记录数据,则以最后一个借书的数据为准
            //当读者借阅书籍
            if("S".equals(line[1])){
                map.put(bookId,line[2]);
            }
            //如果有多个还书的记录数据,则以第一个还书的数据为准
            //当该书籍被借阅,读者还书籍
            else if(map.containsKey(bookId) && "E".equals(line[1])){
                //计算该本书被阅读时间
                String[] t1 = map.get(bookId).split(":");
                String[] t2 = line[2].split(":");
                int hour = Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]);
                int second = Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
                sum += hour * 60 + second;
                //书被阅读一次
                count++;
                //书被还掉了,将该书籍清除
                map.remove(bookId);
            }
        }
    }
}
