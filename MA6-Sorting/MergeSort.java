/*
 *  Assignment: Implementing Quick, Merge, and Radix sort
 *
 *  [this file]: MergeSort Implementation
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

import java.util.ArrayList;


public class MergeSort<T extends Comparable<T>> extends Sorter<T> {
    MergeSort() {
        name = "MergeSort";
    }
    
    /***
  	public ArrayList<T> sort(SortStats stats, ArrayList<T> list) {		
  		if(list.size() == 0) {
  			return list;
  		}
  		int mid = list.size()/2;
	    ArrayList<T> left = new ArrayList<>();
	    ArrayList<T> right = new ArrayList<>();
	    if(list.size() == 1){
	        return list;
	    }else{
	    	stats.comparisons++;
	        for(int i = 0; i < mid; i++){
	            left.add(list.get(i));
	        }
	        for(int i = mid; i < list.size(); i++){
	            right.add(list.get(i));
	        }
	        left = sort(stats,left);
	        right = sort(stats,right);
	        merge(list, left, right, stats);
	    }
	    return list;  				 
	}
  	
  	private void merge(ArrayList<T> list, ArrayList<T> left, ArrayList<T> right, SortStats stats){
  		int leftIndex = 0, rightIndex = 0, listIndex = 0;
	    while(leftIndex < left.size() && rightIndex < right.size()){
	        if(left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0){
	            list.set(listIndex, left.get(leftIndex));
	            leftIndex++;
	        }else{
	            list.set(listIndex, right.get(rightIndex));
	            rightIndex++;
	        }
	        stats.swaps++;
	        listIndex++;
	    }
	    ArrayList<T> theRest = new ArrayList<>();
	    int restIndex = 0;
	    if(leftIndex >= left.size()){
	        theRest = right;
	        restIndex = rightIndex;
	    }else{
	        theRest = left;
	        restIndex = leftIndex;
	    }
	    
	    for(int i = restIndex; i < theRest.size(); i++, listIndex++){
	        list.set(listIndex, theRest.get(i));
	    }
  	}
  	***/
    
    public ArrayList<T> sort(SortStats stats, ArrayList<T> list) {		
  		if(list.size() == 0) {
  			return list;
  		}
  		int mid = list.size()/2;
	    ArrayList<T> left = new ArrayList<>();
	    ArrayList<T> right = new ArrayList<>();
	    if(list.size() == 1){
	        return list;
	    }else{
	    	stats.comparisons++;
	        for(int i = 0; i < mid; i++){
	            left.add(list.get(i));
	        }
	        for(int i = mid; i < list.size(); i++){
	            right.add(list.get(i));
	        }
	        left = sort(stats,left);
	        right = sort(stats,right);
	        list = merge(left, right, stats);
	    }
	    return list;  				 
	}
    
    public ArrayList<T> merge(ArrayList<T> left, ArrayList<T> right,SortStats stats){
	    ArrayList<T> list = new ArrayList<>();
  		int leftIndex = 0, rightIndex = 0;// listIndex  = 0;
	    while(leftIndex < left.size() && rightIndex < right.size()){
	    	stats.swaps++;
	        if(left.get(leftIndex).compareTo(right.get(rightIndex)) < 0){
	            //list.add(left.get(leftIndex));
	            list.add(left.get(leftIndex));
	            leftIndex++;
	        }else{
	            list.add(right.get(rightIndex));
	            rightIndex++;
	        }
	        //listIndex++;
	    }
	    while(leftIndex < left.size()){
	        list.add(left.get(leftIndex));
	        leftIndex++;
	        //listIndex++;
	    }
	    while(rightIndex < right.size()){
	        list.add(right.get(rightIndex));
	        rightIndex++;
	        //listIndex++;
	    }
	    
	    return list;
    }
  	
}