
import java.util.Random;
public class Binarysearch {
	        int max =0;
			int binarry(int arr[],int l,int r){
				int max =0;
			if(r>=l&&l<arr.length-1){
				int mid =l+ (r-l)/2;
			
			if(arr[mid]>=max){
				return binarry(arr,l,mid-1);
			}
			else{
				return binarry (arr , mid+1,r); 
			}
			}
			
		 return -1;
		 
		}
	
	   public static void main (String[] args){
	   BinarySearch ob = new BinarySearch();
	   int a[] = new int[1000];
	   
          Random rnd = new Random();
		  
	    for(int i=0; i<a.length ; i++){
		a[i]=rnd.nextInt(999-0)+0;
		System.out.println(a[i]);
		}
		//BinarySearch ob = new BinarySearch();
		int n = a.length;
		int result = ob.binarry(a ,0,n-1);
		if(result == -1)
			System.out.println("Elemnt not present");
		else{
			System.out.println("Elemnt not at index"+result);
		}
		


   
	   }
}