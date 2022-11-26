package competition;

import java.io.*;
import java.util.*;

/**
 * 当芸芸众生忙着在朋友圈中发照片的时候，总有一些人因为太帅而没有朋友。本题就要求你找出那些帅到没有朋友的人。
 *
 * 输入格式：
 * 输入第一行给出一个正整数N（≤100），是已知朋友圈的个数；随后N行，每行首先给出一个正整数K（≤1000），为朋友圈中的人数，然后列出一个朋
 * 友圈内的所有人——为方便起见，每人对应一个ID号，为5位数字（从00000到99999），ID间以空格分隔；之后给出一个正整数M（≤10000），为待查
 * 询的人数；随后一行中列出M个待查询的ID，以空格分隔。
 *
 * 注意：没有朋友的人可以是根本没安装“朋友圈”，也可以是只有自己一个人在朋友圈的人。虽然有个别自恋狂会自己把自己反复加进朋友圈，但题目保证所有K超过1的朋友圈里都至少有2个不同的人。
 *
 * 输出格式：
 * 按输入的顺序输出那些帅到没朋友的人。ID间用1个空格分隔，行的首尾不得有多余空格。如果没有人太帅，则输出No one is handsome。
 *
 * 注意：同一个人可以被查询多次，但只输出一次。
 *
 * 输入样例1：
 * 3
 * 3 11111 22222 55555
 * 2 33333 44444
 * 4 55555 66666 99999 77777
 * 8
 * 55555 44444 10000 88888 22222 11111 23333 88888
 * 输出样例1：
 * 10000 88888 23333
 * 输入样例2：
 * 3
 * 3 11111 22222 55555
 * 2 33333 44444
 * 4 55555 66666 99999 77777
 * 4
 * 55555 44444 22222 11111
 * 输出样例2：
 * No one is handsome
 */
public class 帅到没朋友 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //定义HashSet集合,将朋友圈中的人放入
        HashSet<String> friend = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] ids = bf.readLine().split(" ");
            //没有朋友的人可以是根本没安装“朋友圈”，也可以是只有自己一个人在朋友圈的人
            int k = Integer.parseInt(ids[0]);
            //如果k=1,即朋友圈中只有一个人,那么他也是没有朋友的,所以当k>1,将这些人的id加入HashSet中
            if(k != 1){
                friend.addAll(Arrays.asList(ids).subList(1, ids.length));
            }
        }
        //输入代查询的人
        int m = Integer.parseInt(bf.readLine());
        String[] number = bf.readLine().split(" ");
        //将没有朋友的人放入Arraylist,并去重
        ArrayList<String> handsome = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //没有朋友并且钱没没有查询过这个人
            if(!friend.contains(number[i]) && !handsome.contains(number[i])){
                handsome.add(number[i]);
            }
        }
        //没有人帅到没朋友
        if(handsome.size() == 0){
            System.out.println("No one is handsome");
        }else{
            //输出帅到没朋友的人
            for (int i = 0; i < handsome.size(); i++) {
                System.out.print(handsome.get(i));
                if(i != handsome.size() - 1){
                    System.out.print(" ");
                }
            }
        }
    }
}
