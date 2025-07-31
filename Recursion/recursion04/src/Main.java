class Solution {

    // recursicve get minimum coins for a given sum problem
    public int ans(int[] arr, int target, int count) {
        if (count == target) {
            return 0;

        }
        if (count > target) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int answer = ans(arr, target, count + arr[i]);
            if (answer != Integer.MAX_VALUE)
                min = Math.min(answer + 1, min);
        }
        return min;
    }

    public int answerWithoutCOunt(int[] arr, int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int answer = answerWithoutCOunt(arr, target - arr[i]);
            if (min != Integer.MAX_VALUE) ;
            min = Math.min(answer + 1, min);
        }
        return min;
    }

    // question : given a number and 3 number givew maximum number of segments

    public int getMaxSegments(int[] arr, int target) {
        if (target == 0) return 0;
        if (target < 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int ans = getMaxSegments(arr, target - arr[i]);
//            if (ans <0){
//                return -1;
//            }
            max = Math.max(ans + 1, max);
        }
        return max;

    }

// given an array find the max sum of the subsequecne such that if ypu select an elemetn you can not select the adjacent elemetn as well
// for eg [2,1,4,9] ans is 2+9 = 11;
    public int getMaxSubSequence(int index, int[] arr, int sum , int max ){
        max  = Math.max(sum , max);
        if (index>= arr.length) return max ;

        // if included
         int one = getMaxSubSequence(index+2 , arr, sum+arr[index] , max);

        // if excluded
        int two = getMaxSubSequence(index+1 , arr , sum , max);
        return Math.max(one , two);
    }
}





public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 2, 9 ,4, 5 , 13};
        int targetSum = 11;
        int finalAns = s.getMaxSubSequence(0 , arr ,  0 , 0);
        System.out.println(finalAns);
    }
}