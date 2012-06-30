import java.util.Random;


public class kthElement {

	

	public static void swap(int[] array,int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp; 
	}
	
	//Partition function
	public static int partition(int[] array,int low, int high){
		int i = low;
		int j = high;
		int pivot = array[low+(high-low)/2];
		
		
		while(i <= j){
			while(array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			
			
			if(i <= j){
				swap(array,i,j);
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	public static int partition2(int[] array,int low, int high){
		int i = low;
		int j = high+1;
		
		while(true){
		
			while(array[++i] < array[low])
				if(i == high) break;

			while(array[low] < array[--j])
				if(j == low) break;
		    
			if(i >= j) break;
			swap(array, i, j);
		}
		
		swap(array, low, j);
			
			
		return j;
	}
	
	
	
	
	
	public static int RandomizedPartition(int[] array,int p, int r){
		int i = (int)(Math.random()*r)+p;
		swap(array,r,i);
		return partition(array, p, r);
	}
	
	//kth smallest element
	public static int RandomizedSelect(int[] array, int p, int r, int k){
		if(p == r)
			return array[p];
		int q =  RandomizedPartition(array, p, r);
		int n = q-p+1;
		if(n == k)
			return array[k];
		else if(n < k )
			return RandomizedSelect(array, q+1, r, k-n);	
		else 
			return RandomizedSelect(array, p, q-1, k);
	}
	
	
	public static void main(String[] args){
		int[] array = {1,9,2,5,4,11,7,8};
		int a = partition2(array, 0, 7);
		System.out.println(a);
		for(int item: array){
			System.out.println(item);
		}
		
		//System.out.println(RandomizedSelect(array, 0,2,3));
		
		
		
	}
	
}
