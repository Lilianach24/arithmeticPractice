package test.SqStackTest;

public class computerTest {
    public static void main(String[] args) {
        double v;
        computer obj=new computer();
        String str="(56-20)/(4+2)";
        obj.Setexp(str);
        System.out.println("中缀表达式:"+str);
        obj.Trans();
        System.out.println("后缀表达式:"+obj.getPostexp());
        System.out.println("求值结果:"+obj.getValue());
    }
}
