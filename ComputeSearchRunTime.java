import java.util.Random;   

public class ComputeSearchRunTime
{
	public static void main (String args[])
	{
		Random random = new Random();   
		int numberList [] = new int [1000];
		int minMax_result[] = new int [2];
 
		for (int i=0; i<1000; i++)
		numberList[i] = random.nextInt(1000);
		
		long startTime = System.nanoTime();
		
		  //minMax_result = NormalSearch(numberList);
		  minMax_result = GetMinMax(numberList,0,999);
	
		long endTime = System.nanoTime();
		long runTimeSec = endTime-startTime;
			
		System.out.println("minimum number = " + minMax_result[0] +" maximum number = " + minMax_result[1]);	
		System.out.println("Run time is " + runTimeSec);

	}
	
	public static int [] NormalSearch(int [] arr)
	{
		int min = 10000 , max= -1;
		
		for (int i=0; i<1000; i++)
		{
			if (arr[i] > max)
				max = arr[i];
			
			if (arr[i] < min)
				min = arr[i];
		}
		return new int []{min,max}; 
	} 
	
	
	public static int [] GetMinMax(int [] arr, int start, int end)
	{
		int min=0 , max = 0;
		// base case 
		if (start == end)
		{
			min = arr[0];
			max = arr[0];
		}
		else if(start+1 == end)
		{
			if (arr[start] > arr[end])
			{
				max = arr[start];
				min = arr[end];
			}
			else
			{
				min = arr[start];
				max = arr[end];
			}
		}
		else 
		{
			int mid = (start + end)/2;
			int left_minMax[] = new int [2];
			left_minMax = GetMinMax(arr, start, mid);
			int right_minMax[] = new int [2];
			right_minMax = GetMinMax(arr, mid+1, end);
		    
			// first returned index is the minimum
			if (left_minMax[0] < right_minMax[0])
				min = left_minMax[0];
			else
				min = right_minMax[0];
			
			// second returned index is the maximum
			if (left_minMax[1] > right_minMax[1])
				max = left_minMax[1];
			else
				max = right_minMax[1];			
		}
		return new int []{min,max}; 
	} 
}