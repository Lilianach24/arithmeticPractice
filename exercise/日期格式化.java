package competition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 日期格式化 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        String time = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = sdf.parse(time);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String res = sdf2.format(date);
        System.out.println(res);
    }
}
