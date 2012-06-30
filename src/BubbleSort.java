
public class BubbleSort {

	
	public static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	
	public static void bubbleSort(int[] array){
	
		int n = array.length;
		
		
	
		for(int i = 0; i < n-1;i++){        //only need n-1次loop
			boolean isSorted = true;
			
			for(int j = 1; j < n-i; j++){   //or 0 <= j < n-i-1
				if(array[j] < array[j-1])
					swap(array,j,j-1);
					
					isSorted = false;
			}
//			for(int ele: array)
//				System.out.print(ele+" ");
//			System.out.println();
			
			if(isSorted)
				break;
		}
	}
	
	
	public static void main(String[] args){
		int[] a = {9,8,7,6,5,4,3,2,1};
		
//		for(int i : a){
//			System.out.print(i+" ");
//		}
//		System.out.println();
		bubbleSort(a);
		for(int i : a){
			System.out.print(i+" ");
		}
	}
	
}
