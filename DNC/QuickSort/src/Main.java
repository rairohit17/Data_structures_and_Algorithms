import java.util.*;


//------- Quick Sort Algorithm------------------

// step 1 create a recursive function for quick SOrt
// forst we take the forst element and then place it to the right position
// after placeing it we break the array to 2 parts
// we apply same  algorithm to the first and the second part respectively
// in the partition we  return the index of a newly placed right element
// we then aply recursion to the left [art forst and then to gthe righrt part




class Solution {

    public void quickSort(int[] arr  , int start , int end ){
        if ( start>=end) return ;

        int pivot = partition(arr, start, end);


        quickSort(arr, start, pivot-1);

        quickSort(arr, pivot+1, end);


    }
    public int  partition(int[] arr , int start , int end ){

        int pivot = start ;

        int count =0 ;

        for ( int i =0 ; i<= (end-start) ; i++){
            if (arr[start+i]< arr[pivot]) {
                count ++;
            }
        }

        int temp = arr[start];
        arr[start] = arr[start+count];
        arr[start+count] = temp;
        pivot = start + count ;

        int i  = start ;
        int j = end ;
        while ( i<pivot && pivot<j ){

            while(arr[i] <= arr[pivot]){
                i++;

            }
            while(arr[j] >arr[pivot]){
                j--;

            }
            if (i< pivot && j > pivot){
                int  let  = arr[i];
                arr[i] = arr[j];
                arr[j ] = let;
            }


        }
        return pivot;




    }

}



public class Main {


        public static void main(String[] args) {
            Solution s = new Solution();
            int [] arr = new int[]{23,12,45,2,2,2,2,2,2,2,2 ,3, 65, 76, 43, 2 };
            s.quickSort(arr , 0 , arr.length-1);
            System.out.println(Arrays.toString(arr));

        }
    }
