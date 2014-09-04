package util;

import java.util.Arrays;



public class Sort {

	public String[] utilSort(String[] toSort){
		
	     Arrays.sort(toSort,String.CASE_INSENSITIVE_ORDER);

		
		return toSort;
	}
}
