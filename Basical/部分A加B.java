package basicLevel;

import java.io.*;

public class 部分A加B {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] datas = bf.readLine().split(" ");
        String da = datas[0].replaceAll(datas[1], "");
        String db = datas[2].replaceAll(datas[3], "");
        String pa = "", pb = "";
        for(int i = 0; i < datas[0].length() - da.length(); i++){
            pa = pa.concat(datas[1]);
        }
        for(int i = 0; i < datas[2].length() - db.length(); i++){
            pb = pb.concat(datas[3]);
        }
        int npa, npb;
        if("".equals(pa)){
            npa = 0;
        }else{
            npa = Integer.parseInt(pa);
        }
        if("".equals(pb)){
            npb = 0;
        }else{
            npb = Integer.parseInt(pb);
        }
        System.out.println(npa + npb);
    }
}
