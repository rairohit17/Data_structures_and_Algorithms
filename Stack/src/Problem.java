import java.util.*;

public class Problem {
    public static void main(String[] args) {
        Solution s= new Solution();
        String p = "(a)())()";
        // System.out.println(s.removeInvalidParentheses(p));
        System.out.println(s.removeInvgetalidParentheses(p).toString());
    }
    
}
class Solution {
    public List<String> removeInvgetalidParentheses(String s) {
        int open = invalidNumber(s)[0];
        int close = invalidNumber(s)[1];

        List<String> finalList = new ArrayList<>();
        return getAns(finalList, "", s, open, close, 0);



        
        
    }
    public List<String> getAns(List<String> finalList , String temp , String s , int open , int close , int index ){
        //  base case 
        if ( index == s.length()){
            if (invalidNumber(temp)[0]==0 &&invalidNumber(temp)[1]==0){
                if ( finalList.size()>0 && finalList.get(finalList.size()-1).equals(temp)) return finalList;
                finalList.add(temp);
                return finalList;

            }
            return finalList;
        }
        //  write logic ofr (

        if ( s.charAt(index) == '('){
            // include 
            getAns(finalList, temp+'(', s, open, close, index+1);

            // exclude 
            if ( open>0){
                getAns(finalList, temp, s, open-1, close, index+1);
            }
        }
        else if ( s.charAt(index) == ')'){
            // include 
            getAns(finalList, temp+')', s, open, close, index+1);

            if ( close>0){
                getAns(finalList, temp, s, open, close-1, index+1);
            }
        }
        else{
            getAns(finalList, temp+s.charAt(index), s, open, close, index+1);
        }

        return finalList;


        

    }
    public int[] invalidNumber( String s){
        int parenthesis = 0 ;  
        int invalidClose = 0;
        for (int i = 0 ; i< s.length() ; i++){
            if ( s.charAt(i) == '('){
                parenthesis+=1;
            }
            else if (s.charAt(i) == ')' && parenthesis>0){
                parenthesis-=1;
            }
            else if ( s.charAt(i) == ')' && parenthesis<=0 ){
                invalidClose+=1;
            }
        }
        return new int[]{parenthesis , invalidClose};

    }


}