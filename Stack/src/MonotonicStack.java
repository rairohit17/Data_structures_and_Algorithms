import java.util.*;
// for getting the nearese largest / smallest or to the left/ right  a monitonic stack is used 

// This Monotonic STack is used in the above mentioned pronlems very widely popular problem  is max rectanngle in histogram and 
//  SUM OF MIN OF SUBARRAYS PROBLEM where each element will be minimum for a span ranging to minimum before to minimum after ;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] arr = new int[]{2, -3, 4, 5, 25, -8, 67 , 23, 87, 69};
        int[ ] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for ( int i =0 ; i< arr.length ; i++){
            ans[i] = getNextSmaller(stack, arr[i]);
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(ans));
    }
    

    static public int getNextSmaller(Stack<Integer> stack , int target){

        while(!stack.empty() && stack.peek()>target){
            stack.pop();
        }
        return stack.empty()?-1:stack.peek();
    }
    
}
