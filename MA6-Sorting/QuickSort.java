/*
 *  Assignment: Implementing Quick, Merge, and Radix sort
 *
 *  [this file]: QuickSort Implementation
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

import java.util.ArrayList; 
 

public class QuickSort<T extends Comparable<T>> extends Sorter<T> {
	
	
    QuickSort() {
        name = "QuickSort";
    }


  	public ArrayList<T> sort(SortStats stats, ArrayList<T> data) {
  		if(data.size() == 0) {
  			return data;
  		}
  		quickSort(data,0,data.size()-1, stats);
		return data;	 
	}
  	
  	private void quickSort(ArrayList<T> list, int start, int end, SortStats stats) {
  		if(start >= end) {
  			return;
  		}
  		T pivot = list.get(start);
  		int i = start -1;
  		int j = end +1;
  		while(i<j) {
  			stats.comparisons++;
  			i++;
            while(list.get(i).compareTo(pivot) < 0){
                i++;
            }
            j--;
            while(list.get(j).compareTo(pivot) > 0){
                j--;
            }
            if(i < j){
            	stats.swaps++;
                T jvalue = list.get(j);
                list.set(j, list.get(i));
                list.set(i, jvalue);
            }
        }
        quickSort(list, start, j, stats);
        quickSort(list, j+1, end, stats);
  		
  	}
 
}