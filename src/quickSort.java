import javax.xml.stream.events.StartDocument;

public class quickSort{
	private int[] array;
	
	
	
	int partition1(int low, int high){
		int i = low;
		int j = high;
		int pivot = array[(low+high)/2];
		
		
		while(i <= j){
			while(array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			
			
			if(i <= j){
				swap(i,j);
				i++;
				j--;
			}
		}
		
		return i;
		
	}
	
	//use the first element as pivot
	int partition2(int l, int r){
		int pivot = array[l];
		int i = l+1;
		
		for(int j = l+1; j <= r;j++){
			if(array[j] < pivot){
				swap(i, j);
				i++;
			}
			
		}
		swap(l, i-1);
		return i-1;
	}
	
	int partition3(int l, int r){
		int pivot = array[r];
		int i = l; // start from l！！
		
		
		for(int j = l; j <= r-1;j++){
			if(array[j] < pivot){
				swap(i, j);
				i++;
				
			}
		}
		swap(r, i);
		return i;
	}
	
	//kth smallest element using partition
	int findKthSmallest(int l, int r, int k){
		int index = partition2(l, r);
		int length = index-l+1;
		if(k == length)
			return array[index];
		else if(k > length)
			return findKthSmallest(index+1, r, k-length);
		else
			return findKthSmallest(l,index-1,k);
			
		
	}
	
	int findKthLargest(int l, int r, int k){
		int index = partition2(l, r);
		int length = r-index+1;
		if(k == length)
			return array[index];
		else if(k > length)
			return findKthLargest(l, index-1, k-length);
		else
			return findKthLargest(index+1, r, k);          //index+1 or just index
			
		
	}
	
	
	
	
	
	public void swap(int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp; 
	}
	
	void sort(int i, int j){
		if(i >= j)     //when i = pivotIndex, i > j
			return;
		else{
			int pivotIndex = partition3(i, j);
			sort(i, pivotIndex-1);
			sort(pivotIndex+1, j);
		}
	}

	
	
	public static void main(String[] args){
		quickSort wenqiang = new quickSort();
		int[] a = {1,2,3,4,5,6,7,8,9};
		wenqiang.array = a;
		wenqiang.sort(0, 8);
		for (int i : wenqiang.array) {
		    System.out.println(i);
		}
		
	}
	
}