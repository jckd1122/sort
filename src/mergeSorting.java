import javax.jws.soap.SOAPBinding.Use;


//空间复杂度o(n)

public class mergeSorting{
	private int[] a;
	
	
	public void mergeSort(int low, int high){
	
		if(low >= high)
			return;
		
		int mid = (low+high)/2;
		
		mergeSort(low, mid);
		mergeSort(mid+1,high);
		//merge2(low, mid, mid+1, high,0);     //fix the bug
		merge1(low,mid,high);
	}
	
	public void merge1(int low, int mid,int high){
//		for (int i = low; i <= high; i++) {
//			helper[i] = a[i];
//		}
		int[] helper = new int[high-low+1];
		//either use the same size array as a, then k = low;
		//Other wise Use proper size
		
		
		int i = low;
		int j = mid+1;
		int k = 0;
		
		//copy the compared results to tmp and then copy tmp back to the original array
		while(i <= mid && j<= high ){
			if(a[i] <= a[j]){
				helper[k] = a[i];
				i++;
			}
			else{
				helper[k] = a[j];
				j++;
			}
			k++;
			
		}
		
		
		//set the rest of elements without comparison
		while(i <= mid){
			helper[k] = a[i];
			i++;
			k++;
		}
		
		while(j <= high){
			helper[k] = a[j];
			j++;
			k++;
		}
		
		for(i = 0; i < high-low+1; i++){
			a[i+low] = helper[i];
		}
		
		
	}
	
	
	
		
		
		
	
	
	
	
	
	
	public static void main(String[] args){
		mergeSorting wenqiang = new mergeSorting();
		int[] a = {10,9,8,7,6,5,4,3,2};
		wenqiang.a = a;
		//wenqiang.helper = new int[9];
//		for (int i = 0; i <= 8; i++) {
//			wenqiang.helper[i] = a[i];
//		}
		wenqiang.mergeSort(0, 8);
	    for (int i : wenqiang.a) {
	    	System.out.println(i);
			
		}
		
	}
	
	
}