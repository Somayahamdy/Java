import java.util.Random;
public class Minmaxarr{
	   public static void main (String[] args){
	   int a[] = new int[1000];
	   
          Random rnd = new Random();
		  
	    for(int i=0; i<a.length ; i++){
		a[i]=rnd.nextInt(999-0)+0;
		System.out.println(a[i]);
		}
        int max =a[0];
		int min =a[0];
		long starttime = System.currentTimeMillis();
		for(int i=1; i<a.length ; i++){
		if(a[i] > max)
		    max= a[i];
	
		}
		System.out.println("Max element:"+max);
		//System.out.println("Min element:"+min);
		for(int i=1; i<a.length ; i++){
		if(a[i] < min ){
		    min = a[i];
		}
		}
		System.out.println("Min element:"+min);
		long endtime = System.currentTimeMillis();
		System.out.println("time taken "+(endtime - starttime));
		
	   }
}
		
		