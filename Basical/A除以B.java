package basicLevel;

import java.io.*;
import java.math.BigInteger;

public class A除以B {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = bf.readLine().split(" ");

        BigInteger[] res = new BigInteger(nums[0]).divideAndRemainder(new BigInteger(nums[1]));
        System.out.println(res[0]+" "+res[1]);
    }
}
