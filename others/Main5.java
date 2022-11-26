package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String flag = buf.readLine();
        int n = Integer.valueOf(buf.readLine());
        Friend friend[] = new Friend[n];
        String flag1=flag.toUpperCase();
        int index=0;
        for (int i=0;i<n;i++){
            String arr[] = buf.readLine().split(" ");
            String flag2 = arr[0].toUpperCase();
            if (flag2.contains(flag1)&&arr[1].equals("F")){
                String date[] = arr[3].split("\\.");
                if (flag2.substring(0,flag.length()).equals(flag1)){
                    friend[index++]=new Friend(arr[0].substring(flag.length(),arr[0].length()),Integer.parseInt(arr[2]),date[0],date[1],date[2]);
                }else {
                    friend[index++]=new Friend(arr[0].substring(0,arr[0].length()-flag.length()),Integer.parseInt(arr[2]),date[0],date[1],date[2]);
                }
            }
        }
        System.out.println(index);
        Arrays.sort(friend, 0, index, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                if (o1.name.equals(o2.name)){
                    if (o1.age==o2.age){
                        if (o1.year.equals(o2.year)){
                            if (o1.month.equals(o2.month)){
                                int day1=Integer.parseInt(o1.day);
                                int day2=Integer.parseInt(o2.day);
                                return day1-day2;
                            }else {
                                int month1 = Integer.parseInt(o1.month);
                                int month2=Integer.parseInt(o2.month);
                                return month1-month2;
                            }
                        }else {
                            int year1=Integer.parseInt(o1.year);
                            int year2=Integer.parseInt(o2.year);
                            return year1-year2;
                        }
                    }else {
                        return o1.age-o2.age;
                    }
                }
                return o1.name.compareTo(o2.name);
            }
        });
        for (int i=0;i<index;i++){
            System.out.println(friend[i].toString());
        }
    }

}
class Friend{
    String name;
    int age;
    String year;
    String month;
    String day;

    public Friend(String name, int age, String year, String month, String day) {
        this.name = name;
        this.age = age;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+year+"."+month+"."+day;
    }
}
