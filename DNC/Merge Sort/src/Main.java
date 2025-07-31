import java.util.Arrays;
// merge sort implementation
// STEPS TO MERGE SORT ;
//1.we break the array into smaller arrays divides into half every time

// 2. base case-----> if the start< = end that means there ar only 1 element or no element in the array so return

// 3. first sort the ;eft part and then sort the ritgth part and then

// merge the 2 parts as they are already sorted using 2 pointers ;




class Solution {
    public void mergeSort(int[] arr , int start , int end ){
        int mid = (start+end +1 )/2;
        if (start>=end){
            return ;
        }
        // forst sort the foirest half
        mergeSort(arr , start , mid-1);
        //then sort the second half ;
        mergeSort(arr , mid , end );

        merge(arr, start , end );

    }
    public void merge( int[] arr , int start  , int end ) {
        int mid = (start + end + 1) / 2;
        int p1 = 0;
        int p2 = 0;

        // first we create 2 different arrays of the same size as the broken arrays and thenn
        // we merge 2 sorted arrays algorithm ;
        int[] startArr = new int[mid-start];
        int[] endArr = new int [end -mid+1];
        for ( int i = 0 ; i< startArr.length ; i++){
            startArr[i] = arr[start+i];
        }
        for ( int i = 0 ; i< endArr.length ; i++){
            endArr[i] = arr[mid+i];
        }
        while ( p1 < startArr.length && p2 < endArr.length ){
            if ( startArr[p1]<endArr[p2]){
                arr[start+p1+p2] = startArr[p1];
                p1++;
            }
            else{
                arr[start+p1+p2] = endArr[p2];
                p2++;

            }
        }
        while ( p1<startArr.length ){
            arr[start+p1+p2] = startArr[p1];
            p1++;
        }
        while ( p2<endArr.length){
            arr[start+p1+p2] = endArr[p2];
            p2++;
        }

    }
}




public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{38 , 27, 43 , 3, 9, 20};
        Solution s = new Solution();
         s.mergeSort(arr ,0 , arr.length-1 );
        System.out.println(Arrays.toString(arr));
    }
}