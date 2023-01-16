import java.util.*;	
class laptop_tcs{
      static int clb(L[] r,String s){
        int count=0;
      for(int i=0;i<r.length;i++){
      if(r[i].getbrand().equalsIgnoreCase(s) && r[i].getrating()>3){count++;}
      }
        return count;
      }
    static L[] slo(L[] r,String s){
  L[] arr=new L[0];
  for(int i=0;i<r.length;i++){
  	if(r[i].getos().equalsIgnoreCase(s)){
    arr=Arrays.copyOf(arr,arr.length+1);
      arr[arr.length-1]=r[i];
    }
  }
  //sort 
  for(int i=0;i<arr.length-1;i++){
  for(int j=0;j<arr.length-i-1;j++){
  	if(arr[j].getid()>arr[j+1].getid()){
    L temp=arr[j];
      arr[j]=arr[j+1];
      arr[j+1]=temp;
    }
  }
  }
  return arr;
}
    public static void main(String args[]){
    L[] r=new L[4];
      Scanner sc=new Scanner(System.in).useDelimiter("\n");
      for(int i=0;i<4;i++){
      r[i]=new L(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble(),sc.nextInt());
      }
      String a=sc.next();
      String b=sc.next();
      sc.close();
      int aans=clb(r,a);
      if(aans==0){System.out.println("The given brand is not available");}
      else {System.out.println(aans);}
      L[] desc=slo(r,b);
      if(desc.length==0){System.out.println("The given os is not available");}
      else {
      	for(int i=desc.length-1;i>=0;i--){
        System.out.println(desc[i].getid());
          System.out.println(desc[i].getrating());
        }
      }
    }

	static class L{
    int lid;
      String brand;
      String ost;
      double price;
      int rating;
      L(int lid,
         String brand,String ost,double price,int rating)
      {
        this.lid=lid;
        this.brand=brand;
        this.ost=ost;
        this.price=price;
        this.rating=rating;
      }
      public String getbrand(){
      return brand;}
      public int getrating()
      {
        return rating;
      } 
      public int getid(){return lid;}
      public String getos(){return ost;}
    }
    }