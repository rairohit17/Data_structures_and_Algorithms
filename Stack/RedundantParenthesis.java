package Stack;
import java.util.*; 


public class RedundantParenthesis {
    
    public static void main(String[] args) {
        Solution s1 = new Solution(); 
        String str = "(A*(B+C))";
        str = s1.removeBrackets(str);
        System.out.println(str); 

        
    }
}

class MutableBoolean{
        boolean boolValue; 
        MutableBoolean(boolean boolValue){
            this.boolValue = boolValue;
        }
        public void changeval(boolean bool){
            this.boolValue = bool;
        }
}


class Solution{
    public static String removeBrackets(String s) {
        Stack<String> stack = new Stack<>(); 
        for ( int i =0 ; i < s.length() ; i++){
            if (s.charAt(i) == ')'){
                MutableBoolean operatorPresent = new MutableBoolean(false);
                MutableBoolean openingPresent = new MutableBoolean(false);
                String str = removeRedundant(stack , operatorPresent , openingPresent);
                if (operatorPresent.boolValue==false|| openingPresent.boolValue ==false){
                    stack.push(str);
                }
                else{
                    System.out.println(str);
                    stack.push(str+")");
                }
                
            }
            else{
                stack.push(Character.toString(s.charAt(i)));
            }
        }

        String finalAns = addStrings(stack);
        if ( finalAns.charAt(0) == '('&& finalAns.charAt(finalAns.length()-1) ==')'){
            finalAns = finalAns.substring(1, finalAns.length()-1);

        }
        return finalAns;

        
    }

    public static String removeRedundant(Stack<String> stack , MutableBoolean operatorPresent , MutableBoolean openingPresent){

        if (stack.empty()) return "";
        if (stack.peek().equals("(") && operatorPresent.boolValue){
            stack.pop();
            openingPresent.changeval(true);
            return "(";
        }
        else if ( stack.peek()=="("  && operatorPresent.boolValue== false){
            stack.pop();
            return "";
        }
        
        String top = stack.pop(); 
        if (top.equals("+") || top.equals("-") || top.equals("*") || top.equals("/")) {
             operatorPresent.changeval(true); 
            
        }
        return removeRedundant(stack , operatorPresent , openingPresent)+top;

    }

   public  static String  addStrings(Stack<String> stack){
    if ( stack.empty()){
        return "";

    }
    String top = stack.pop(); 
      return addStrings(stack)+top;
   }
    
} 
