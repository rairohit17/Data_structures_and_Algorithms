
package Queues;

import java.util.*;

// MONOTONIC QUEUES  are used where we have to find the Max , min in a sliding windiw and its related problems in On time complexity 

// CONCEPT -------> IN Increasing  monotonic queues we use a Dequeue we check the lastElement in the queue is < new elemntn we pop it again  and again 
// until queue.peekLast >= new element; 
// used on condition where we hav to find the first max in a window and 
// used in place where we have to take teh first smaller element / largets element 

// for eg Leetcode shortest subarray with sum at least k Problem ----------------------------



public class MonotonicQueues {
    public static void main(String[] args) {
        int[] arr = new int[]{4,23,67,-9,29,12,676,789,209};
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[arr.length-3+1];


        for (int i =0 ; i< 3; i++){
             while (!deque.isEmpty() && arr[deque.peekLast()]< arr[i]) {
                deque.removeLast();
                
            }
            deque.add(i);

        }
        System.out.println(deque);
        ans[0] =arr[deque.peek()];
        

        for ( int i =3; i< arr.length ; i++){

            if ( deque.peek()<=i-3){
                deque.remove();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()]< arr[i]) {
                deque.removeLast();
                
            }
            deque.add(i);
            ans[i-2] = arr[ deque.peek()];

        }

        System.out.println(Arrays.toString(ans));


        
    }
    
}

