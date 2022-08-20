//SortedLinkedList class
//this class construct a linked list,
//take insert input from file and sort the value
//at the same time
class SortedLinkedList {
    //create head node
    Node head;
    Node lastNode;
    
    //node class 
    class Node{
        int val;
        Node next;
        //constructor to create new node
        //take in the new node value
        Node(int val){
            this.val = val;
        }
    }
    
    /***
    *insertionSort function 
    *this function take in new value send from main,
    *store new value in linked list and sort that value 
    *at the same time
    * @param num - value from the input file
    ***/
    public void insertionSort(int num){
        //assigned newNode to the new value that sent to this function
        Node newNode = new Node(num);
        //if head is null,we know this is the first value
        // in the linked list
        //assigned newNode to head
        if(head == null){
            head = newNode;
        }else{
            //let current be the value of the newNode
            Node curr = newNode;
            //if current node is lest than value of the head node
            //switch the head to the current value
            if(curr.val < head.val){
                curr.next = head;
                head = curr;
            }else{
                //if current node is greater than head, loop through 
                //every single node after the head node until we find the
                //the correct place to input this current value
                Node temp = head;
                while(temp.next != null && temp.next.val < curr.val){
                    temp = temp.next;
                }
                curr.next = temp.next;
                temp.next = curr;
            }
        }
    }
    /***
    * printList 
    * this function iterate through the linked list
    * and print out the value to the console
    **/
    public void printList(){
        Node next = head;
        while(next != null){
            System.out.println(next.val);
            next = next.next;
        }
    }
    
    /***
    *getMin
    * this function return the min value from the 
    * list, which is the head of the list
    * @return head
    **/
    public int getMin() {
        if (head != null) {
            return head.val;
        }
        return -1;
    }
    
    /***
    *getMax
    * this function return the max value from the 
    * list, which is the head of the list
    * @return lastNode
    **/
    public int getMax() {
        if (head == null) {
            return -1;
        }
        lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        return lastNode.val;
    }
    
    /***
     * getMed
     * this function return the median value of the sorted linked list
     * get the length from the file and check if the total number in
     * the file is odd or even 
     * use two slow and fast pointer algorithm to find the median
     * the fast pointer travle 2 nodes at the time, and the slow pointer
     * travel one node at the time. By the time the fast pointer reach to
     * the end of the list, the slow pointer will be at the middle of the list
     * @param length - the length of the file list
     * @return slowPointer - the median value
    ***/
    public int getMed(int length) {
        //declear 2 slow and fast nodes
        Node slowPointer = head;
        Node fastPointer = head;
        //check if head is null
        if(head != null){
            //check if the total data is odd or even
            if(length % 2 == 0){
                while(fastPointer != null){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next.next;
                }
            }else{
                while(fastPointer.next != null){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next.next;
                }
            }
        }
        return slowPointer.val;
    }
}
