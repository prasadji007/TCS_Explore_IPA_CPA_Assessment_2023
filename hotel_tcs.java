import java.util.*;

public class hotel_tcs{
    static int nbm(H[] r,String s){
        int days=0;
        for(int i=0;i<r.length;i++){
            if(r[i].getdob().substring(3,3+s.length()).equals(s)){
                days+=r[i].getnorb();
            }
        }
        return days;
    }
    static H[] sbw(H[] r,String s){
        int min=-1;
        H[] arr=new H[0];
        for(int i=0;i<r.length;i++){
            if(r[i].getwf().equals(s)){
                arr=Arrays.copyOf(arr,arr.length+1);
              arr[arr.length-1]=r[i];
            }
        }
      for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j].gettb()<arr[j+1].gettb()){
                    H temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
      }
        
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        H[] r=new H[4];
        for(int i=0;i<4;i++){
            r[i]=new H(sc.nextInt(),sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.nextDouble());
        }
        String a=sc.next();
        String b=sc.next();
        sc.close();
        int ans=nbm(r,a);
        if(ans==0){System.out.println("No rooms booked in the given month");}
        else {System.out.println(ans);}
        H[] arr=sbw(r,b);
        if(arr.length>1){
        // for(int i=0;i<arr.length;i++){

        // }
        System.out.println(arr[1].getid());
        }else {System.out.println("No such option available");}

    }

    public static class H {
        int hid;
        String hname;
        String dob;
        int norb;
        String wf;
        double tb;

        H(int hid,
                String hname,
                String dob,
                int norb,
                String wf,
                double tb) {
            this.hid = hid;
            this.hname = hname;
            this.dob = dob;
            this.norb = norb;
            this.wf = wf;
            this.tb = tb;
        }
        public int getid(){return hid;};
        public String getdob(){return dob;}
        public int getnorb(){return norb;}
        public String getwf(){return wf;}
        public double gettb(){return tb;}
    }

}
