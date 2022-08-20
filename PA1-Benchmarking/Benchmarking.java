import java.util.*;
import java.io.*;

public class Benchmarking {

	public static void main(String[] args) throws FileNotFoundException {
	    String inputFile = "";
	    
	    if(args.length != 0){ 
	        System.out.println("Lol");
	        inputFile = args[0];
	    }else{
	        //create scanner object
	        
	        //Scanner scan = new Scanner(System.in);
	        
	        //get input file name
	        inputFile = fileName();
	    }
	    //create a list from SortedLinkedList
	    SortedLinkedList list = new SortedLinkedList();
	    //read data from the inputFile
	    int length = readFile(inputFile, list);
		
		//list.printList();
		getData(list, length);
	}
	
	/***
	 * fileName
	 * this function asked user to input file fileName
	 * @param scan - scanner Object
	 * @return inputFile - return the input file name from user
	 * 
	***/
	public static String fileName(){
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter input file: ");
	    String inputFile = scan.nextLine();
	    return inputFile;
	}
	
	/***
	 * readFile
	 * this function get the inputFile name and 
	 * loop through all the data in the file 
	 * then send it to the linked list
	 * @param scan - scanner Object
	 * @param inputFile - name of the input file
	***/
	public static int readFile(String inputFile, SortedLinkedList list) throws FileNotFoundException{
	    Scanner input = new Scanner(new File(inputFile));
	    int count = 0;
		while(input.hasNextInt()){
		    int num = input.nextInt();
		    list.insertionSort(num);
		    count++;
		}
		return count;
	}
	
	public static void getData(SortedLinkedList list, int length){
	    long start = System.nanoTime();
	    System.out.println("Min value: " +  list.getMin());
	    long end = System.nanoTime();
	    System.out.println("Min time: " + (end - start));
	    
	    start = System.nanoTime();
	    System.out.println("Max value: " +  list.getMax());
	    end = System.nanoTime();
	    System.out.println("Max time: " + (end - start));
	    
	    start = System.nanoTime();
	    System.out.println("med: " + list.getMed(length));
	    end = System.nanoTime();
	    System.out.println("med time: " + (end - start));
	}
}
