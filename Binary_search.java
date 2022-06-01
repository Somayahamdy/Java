import java.util.Arrays;
import java.util.Random;
public class Binary_search {
static int maxnum(int arr[],int low, int high){
	if(low==high)
		return arr[low];
	if((high == low+1)&& arr[low] >= arr[high])
		return arr[low];
	if((high == low+1) && arr[low] <= arr[high])
		return arr[high];
	int mid = (low+high)/2;
	if(arr[mid] > arr[mid +1] && arr[mid] > arr[mid -1] )
		return arr[mid];
	if(arr[mid] > arr[mid +1] && arr[mid] < arr[mid -1] )
		return maxnum(arr,low,mid -1);
	else
		return maxnum(arr,mid+1,high);
		
	
}

   public static void main(String[] args) {
	   
	   Random ran = new Random();
       int[] intArray = new int[1000];
	   int large,small;
       for(int i=0; i<1000; i++) {
		   intArray[i] = ran.nextInt(100);
		   }
      System.out.println(Arrays.toString(intArray));
	  System.out.println("The maximum element is "+ maxnum(intArray, 0, 999));
	  
	  System.out.println("Time of running " + System.currentTimeMillis());
	  
   }
}