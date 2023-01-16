import java.util.*;
public class player_tcs {
   static int pwlr(P r [],String s){
        int run=1000000;boolean flag=false;
        for(int i=0;i<r.length;i++){
            if(r[i].getptype().equals(s)){
                flag=true;
                run=Math.min(r[i].getruns(),run);
            }
            
        }
        if(flag){return run;}else return 0;
    }
    static P[] pbmt(P r[],String s){
        P arr[]=new P[0];
        for(int i=0;i<r.length;i++){
            if(r[i].getmtype().equals(s)){
                arr=Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1]=r[i];
            }
            
        }
        for(int i=0;i<r.length-1;i++){
            for(int j=0;j<r.length-i-1;j++){
                if(r[j].getpid()<r[j+1].getpid()){
                    P temp=r[j];
                    r[j]=r[j+1];
                    r[j+1]=temp;
                }
            }
        }
        if(r.length>0){
        return arr;}else return null;
    }
    
    public static void main(String[] args) {
        P[] r=new P[4];
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        
         for(int i=0;i<4;i++){
            int c=sc.nextInt();String d=sc.next();
            int e=sc.nextInt();String f=sc.next();
            String g=sc.next();
            r[i]=new P(c,d,e,f,g);
            
         }
         String a=sc.next();
         String b=sc.next();
         //System.out.println(a+" "+b);
         sc.close();
         int aans=pwlr(r,a);
         if(aans==0){System.out.println("No such player");}
         else {System.out.println(aans);}
         P[] desc=pbmt(r,b);
         if(desc.length==0){System.out.println("No Player with given matchType");}
         else {
            for(int i=0;i<desc.length;i++){
                System.out.println(desc[desc.length-i-1].getpid());
            }
         }
        
    }

    public static class P{
        int pid;String pname;int runs;String ptype;
        String mtype;
        P(int pid,String pname,int runs,String ptype,
        String mtype){
            this.pid=pid;
            this.runs=runs;
            this.ptype=ptype;
            this.mtype=mtype;

        }
        public int getruns(){
                return runs;
        }
        public String getmtype(){
            return mtype;
        }
        public String getptype(){
            return ptype;
        }
        public int getpid(){
            return pid;
        }
    }
}
