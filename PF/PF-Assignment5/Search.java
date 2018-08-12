

public class Search {
	
	/*
	 * Searching a element using linear search.
	 * @params arr-input array.
	 * @params target-value to be searched.
	 * @params start-starting index of the array.
	 * @params end-ending index of the array.
	 * @return return whether the element is present or not.
	 */
	public int linearSearch(int[] arr,int target,int start,int end){
		
		if(start>end)
			return -1;
		
		if(arr[start]==target)
			return 1;
		
		return linearSearch(arr,target,start+1,end);
	}
	
	/* 
	 * Searching a element using binary search.
	 * @params arr-input array.
	 * @params start-starting index of the array.
	 * @params target-element to be searched.
	 * @params end-ending index of the array.
	 * @return returns whether element is present or not in the array.
	 */
	public int binarySearch(int arr[],int target,int start,int end){
		
		if(start>end)
			return -1;
		
		int mid=(start+(end))/2;
		
		if(arr[mid]==target)
			return 1;
		
		if(arr[mid]>target)
			return binarySearch(arr, target, start, mid-1);
		else 
			return binarySearch(arr, target, mid+1, end);
	}
}

