package rozenberg.weather;

public class SelectionSort {
	
	public static  void selectionSort(String [] values, int qty){
		int startScan;  //start position of scan
		int index;      //keeps subscript value
		int minIndex;   //element with smallest value in current scan
		String  minValue;     //smallest value found
		
		//outer loop goes through the array once for each element in the array
		//compares each element to every other element in the list to see
		//which one is currently the smallest
		
		for (startScan =0; startScan < qty-1; startScan++){
			//assume first element is the smallest
			minIndex = startScan;
			minValue = values[startScan];
			
			//now scan rest of the array to see if we find a smaller value
			for (index = startScan +1;index < qty; index++){
				if (values[index].compareTo(minValue)<0){
					//current value is smaller
					minValue = values[index];
					minIndex = index;
				}
			}
			//we completed comparing the element to every other element 
			//we have found the smallest of the values in the remaining list
			//now place it in the correct position
			values[minIndex] = values[startScan];
			values[startScan] = minValue;
		}
	}

}