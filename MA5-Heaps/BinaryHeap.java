/*
 *  Assignment: Implementing Percolates
 *
 *  [this file]: Main Heap class
 *   Heaps Microassignment
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
    private ArrayList<AnyType> data = new ArrayList<>();
    private Integer currentSize = 0;
    private static final int DEFAULT_CAPACITY = 10;

    // Default constructor reserves 10 items worth of space
    public BinaryHeap () {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap (int reserve_size) {
        ensureHeapSize(reserve_size);
        currentSize = 0;
    }

    // Array initializer-based constructor
    //  Added every item in items to heap
    public BinaryHeap( AnyType [ ] items ) {
        this();             // Call default constructor
        for (AnyType item : items) {
            insert(item);
        }
    }

    // Quick hack of a print out of the heap's data
    public void dump() {
        for (AnyType val : data) {
            System.out.print(val + ", ");
        }
    }

    // Returns a SHALLOW COPY of the data arraylist
    public ArrayList<AnyType> getData() {
        ArrayList<AnyType> newData = new ArrayList<>();
        for (AnyType item : data) {
            if( item != null) {
                newData.add(item);
            }
        }
        return newData;
    }

    // Expands the heap's internal sized ArrayList
    public void ensureHeapSize(int newSize) {
        data.ensureCapacity(newSize);    // Prevent excessive copying while we're adding
        while (data.size() < newSize) {
            data.add(null);
        }
    }

    public AnyType findMin() {
        if( isEmpty( ) ) {
            throw new IndexOutOfBoundsException( );
        }
        return data.get(0);
    }

    public boolean isEmpty() {
        return (currentSize <= 0);
    }

    public void makeEmpty() {
        while( !isEmpty() ) {
            deleteMin();
        }
    }

    public int size() {
        return currentSize;
    }

    public AnyType deleteMin() {
        if( isEmpty( ) ) {
            throw new IndexOutOfBoundsException( );
        }

        AnyType minItem = findMin( );
        data.set(0, data.get(--currentSize));
        data.set(currentSize, null);
        percolateDown( 0 );

        return minItem;
    }

    // ********************************************************************* //
    //  Microassignment Section: Implement percolations
    // ********************************************************************* //
    public void insert(AnyType x) {
        // MA TODO: Write some kind of heap/percolate insert function
    	if(x != null) {
    		if(currentSize == DEFAULT_CAPACITY) {
    			ensureHeapSize(currentSize*2+1);
    		}
    		data.set(currentSize,x);
        	percolateUp(data.indexOf(x));
        	currentSize++;
    	}
    }
    
    public void percolateUp(int index) {
    	int position = (index-1)/2;
    	AnyType value = data.get(index);
    	if(data.get(position) != null && data.get(index)!= null && data.get(index).compareTo(data.get(position)) < 0) {
    			data.set(index, data.get(position));
        		data.set(position, value);
        		percolateUp(position);
    	}
    	
    }
    
    private void percolateDown( int index ) {
    	AnyType value = data.get(index);
    	int right = index*2+2;
    	int left  = index*2 + 1;
    	int smaller = -1;
    	if(left <= currentSize && data.get(left) != null && value.compareTo(data.get(left)) > 0) {
			smaller = left;
		}else {
			smaller = index;
		}
    	if(right <= currentSize && data.get(right) != null && data.get(right).compareTo(data.get(smaller)) < 0) {
    		smaller = right;
    	}
    	
    	if(smaller != index) {
    		data.set(index, data.get(smaller));
    		data.set(smaller, value);
    		percolateDown(smaller);
    	}
    }

}

