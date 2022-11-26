package Unit1;

import java.util.*;

/**
 * 病人类
 */
class Patient{
    //病人编号
    int id;
    //病人要求医生的编号
    int docId;
    //病人优先级
    int priority;
    public Patient(int pid,int did,int pri){
        id=pid;
        docId=did;
        priority=pri;
    }
}
class PatCmp implements Comparator<Patient>{

    @Override
    public int compare(Patient o1, Patient o2) {
        //优先级相同时,按id越小越优先
        if(o2.priority==o1.priority){
            return o1.id-o2.id;
        }
        //否则按优先级越大越优先
        else {
            return o2.priority-o1.priority;
        }
    }
}
public class L {
    public static final int MAXN=2010;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //三个医生
        PriorityQueue<Patient> pq1 = new PriorityQueue<Patient>(MAXN,new PatCmp());
        PriorityQueue<Patient> pq2 = new PriorityQueue<Patient>(MAXN,new PatCmp());
        PriorityQueue<Patient> pq3 = new PriorityQueue<Patient>(MAXN,new PatCmp());
        while (sc.hasNext()){
            //多组用例,每组开始前都需要清除上一组的痕迹
            pq1.clear();
            pq2.clear();
            pq3.clear();
            //发生事件的数目
            int n=sc.nextInt();
            //病人的编号
            int i=1;
            while (n>0){
                String str=sc.next();
                if("IN".equals(str)){
                    //要求的医生
                    int a=sc.nextInt();
                    //优先级
                    int b=sc.nextInt();
                    if(a==1){
                        pq1.offer(new Patient(i,a,b));
                    }else if(a==2){
                        pq2.offer(new Patient(i,a,b));
                    }else {
                        pq3.offer(new Patient(i,a,b));
                    }
                    i++;
                }else {
                    int a=sc.nextInt();
                    Patient pid;
                    if(a==1){
                        if(!pq1.isEmpty()){
                            pid=pq1.poll();
                            System.out.println(pid.id);
                        }else {
                            System.out.println("EMPTY");
                        }
                    }else if(a==2){
                        if(!pq2.isEmpty()){
                            pid=pq2.poll();
                            System.out.println(pid.id);
                        }else {
                            System.out.println("EMPTY");
                        }
                    }else {
                        if(!pq3.isEmpty()){
                            pid=pq3.poll();
                            System.out.println(pid.id);
                        }else {
                            System.out.println("EMPTY");
                        }
                    }
                }
                n--;
            }
        }
    }
}
