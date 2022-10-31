import java.util.*;

public class MyDoubleLinkedList<E extends Comparable<E>>  {
	
   private Node<E> head, tail;
   private int size;

	    /** Create a default list */
   public MyDoubleLinkedList() {
      head = new Node<E>(null);
      tail = new Node<E>(null);
      size = 0;
   }

	    /** Create a list from an array of objects */
   @SuppressWarnings("unchecked")
   public MyDoubleLinkedList(E[] objects) {
         // Left as Exercise
         for(int i = 0; i < objects.length; i++){
            tail.previous = (MyDoubleLinkedList<E>.Node<E>) objects[i];
            size++;
         }  

   }

	    /** Return the head element in the list */
   public E getFirst() {
      if (size == 0) {
         return null;
      } else {
         return head.element;
      }
   }

	    /** Return the last element in the list */
   public E getLast() {
      if (size == 0) {
         return null;
      } else {
         return tail.element;
      }
   }

	    /** Add an element to the beginning of the list */
   public void addFirst(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new node
      newNode.next = head; // link the new node with the head
      head = newNode; // head points to the new node
      size++; // Increase list size
   
      if (tail == null) // the new node is the only node in list
         tail = head;
   
      if (head != tail)
         head.next.previous = head; // For a two-way linked list
   }

	    /** Add an element to the end of the list */
   public void addLast(E e) {
      Node<E> newNode = new Node<E>(e); // Create a new for element e
   
      Node<E> temp = tail; // For a two-way linked list
   
      if (tail == null) {
         head = tail = newNode; // The new node is the only node in list
      } else {
         tail.next = newNode; // Link the new with the last node
         tail = tail.next; // tail now points to the last node
      }
   
      size++; // Increase size
   
      tail.previous = temp; // For a two-way linked list
   }

	    /**
	     * Add a new element at the specified index in this list The index of the
	     * head element is 0
	     */
   public void add(int index, E e) {
     // "Implementation left as an exercise";
      Node<E> node = new Node(e);
      Node<E> curr = head;

      while(curr != null && curr.element != e) {
         curr = curr.next;
      }
      if (curr == null) {
         System.out.println();
      }
   }
	    
	    /** Add a new element at the specified index in this list in ascending order */
   public void addInOrder(E e) {
      // "Implementation left as an exercise";
      Node<E> newNode = new Node<E>(e);
      if(head == null) {
         head = tail = newNode;
         //heads previous will be null
         head.previous = null;
         tail.next = null;
      }else {
         tail.next = newNode;
         newNode.previous = tail;
         tail = newNode;
         tail.next = null;
      }
    		  
   }
	    
	    /** Return true if this list contains no elements */
   public  boolean isEmpty() {
      return size() == 0;
   }

	    /** Check to see if this list contains element e */
   public boolean contains(E e) {
     	  // "Implementation left as an exercise";
        if(isEmpty()){
            System.out.println("list is empty");
            return false;
        }
        Node<E> curr = head;
        while(curr != null && curr.element != e) {
            curr = curr.next;
        }
        if(curr == null) {
         return false;
        }

        return true;

   }

	    /**
	     * Remove the head node and return the object that is contained in the
	     * removed node.
	     */
   public E removeFirst() {
      if (size == 0) {
         return null;
      } else {
         Node<E> temp = head;
         head = head.next;
         size--;
         if (head == null) {
            tail = null;
         }
         return temp.element;
      }
   }

	    /**
	     * Remove the last node and return the object that is contained in the
	     * removed node.
	     */
   public E removeLast() {
      if (size == 0) {
         return null;
      } else if (size == 1) {
         Node<E> temp = head;
         head = tail = null;
         size = 0;
         return temp.element;
      } else {
         Node<E> current = head;
      
         for (int i = 0; i < size - 2; i++) {
            current = current.next;
         }
      
         Node<E> temp = tail;
         tail = current;
         tail.next = null;
         size--;
         return temp.element;
      }
   }

	    /**
	     * Remove the element at the specified position in this list. Return the
	     * element that was removed from the list.
	     */
   public E remove(int index) {
      // "Implementation left as an exercise";
      if(index < 0 || index > size - 1) {
         return null;
      }
      
      Node<E> curr = head.next;
      int count = 0;
      while(curr != tail && count < index)
      {
         curr = curr.next;
         count++;
      }

      E old = curr.element;
      curr.element = curr.next.element;
      curr.next.previous = curr.previous;
      curr.previous.next = curr.next;
      size--;
      return old;
   }
	    
	    /** Remove the first occurrence of the element e 
	     *  from this list. Return true if the element is removed. */
   public boolean remove(E e)
   {
      	  // "Implementation left as an exercise";
      Node<E> curr = head, prev = null;
      while(curr.element != e)
         prev = curr; 
         curr = curr.next;
         return true;
   }
	    
	     /** Return the length of this list using recursion */
   public int getLength() {
       	// "Implementation left as an exercise";
         Node<E> temp = head;
         int count = 0;
         while(temp != null) {
            count++;
            temp = temp.next;
         }
         return count;
   }
	     
      

   @Override
       public String toString() {
      StringBuilder result = new StringBuilder("[");
   
      Node<E> current = head;
      for (int i = 0; i < size; i++) {
         result.append(current.element);
         current = current.next;
         if (current != null) {
            result.append(", "); // Separate two elements with a comma
         } else {
            result.append("]"); // Insert the closing ] in the string
         }
      }
   
      return result.toString();
   }
	    
	    /** Print the list in reverse order */
   public void printReverse() {
       	// "Implementation left as an exercise";
         Node<E> current = tail;
         if(tail == null){
            System.out.println("List is empty");
            return;
        }
        while(current != null) {
         System.out.print(current.element + " ");
         current = current.previous;
        }
        
   }
	    
	    /** Print this list using recursion */
   public void printList() {
     	  // "Implementation left as an exercise";
        Node<E> current = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes: ");
        while(current != null) {
         System.out.print(current.element + " ");
         current = current.next;
        }
   }
	    
      
	    /** Clear the list */
   public void clear() {
      head = tail = null;
   }

	  

	    /** Return the element from this list at the specified index */
   public E get(int index) {
        // "Implementation left as an exercise"
        if( index < 0 || index > size - 1) {
            return null;
        }
        Node<E> curr = head.next;
        int count = 0;
        while(curr != tail && count < index) {
         curr = curr.next;
         count++;
        }
        return curr.element;

   }

	    /**
	     * Return the index of the head matching element in this list. Return -1 if
	     * no match.
	     */
   public int indexOf(Object e) {
        // "Implementation left as an exercise"
         int index = 0;
         Node<E> curr = head.next;
         while(curr != null) {
            if(curr.equals(e)) {
               return index;
            }
            index++;
            curr = curr.next;

         }
         if(index == size && e == null){
            return -1;
         }else {
            return index;
         }
      
   }

	    /**
	     * Return the index of the last matching element in this list Return -1 if
	     * no match.
	     */
   public int lastIndexOf(Object e) {
        // "Implementation left as an exercise";
        return ((MyDoubleLinkedList) e).lastIndexOf(e);
         
   }

	    /**
	     * Replace the element at the specified position in this list with the
	     * specified element.
	     */
   public E set(int index, E e) {
      // "Implementation left as an exercise";
      Node<E> ref = head.next;
      for(int i = 0; i < index; i++){
         ref = ref.next;
      }
      E result = ref.element;
      return result;
   }

	    
   public class Node<T> {
      T element;
      Node<T> next;
      Node<T> previous;
   
      public Node(T o) {
         element = o;
      }
   }

   public int size() {
      return size;
   }

	    /** Split the original list in half. The original     
	     * list will continue to reference the 
	     * front half of the original list and the method 
	     * returns a reference to a new list that stores the 
	     * back half of the original list. If the number of 
	     * elements is odd, the extra element should remain 
	     * with the front half of the list. */
   public MyDoubleLinkedList<E> split(){
          // "Implementation left as an exercise";
         
              	   
   }

}
	
