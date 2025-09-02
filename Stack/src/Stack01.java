import java.util.* ; 


public class Stack01 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); 
        stack.push(673);
        stack.push(212);
        stack.push(343);
        stack.push(23);
        stack.push(2990);
        stack.push(6789);
        stack = sortStack(stack  );
        System.out.println(stack.toString());
    }
    public static Stack<Integer> insertAtBottom(Stack<Integer> stack , int element){
        if (stack.empty()){
            stack.push(element);
            return stack;
        }
        int temp = stack.pop();
        stack  = insertAtBottom(stack ,element);
        stack.push(temp);
        return stack; 
        
    }

    public static Stack<Integer> reverseStack(Stack<Integer> stack  ){
        if ( stack.empty() ){
            return stack;
        }
        int top = stack.pop();
        stack = reverseStack(stack);  /// empty the stack forst adn then add start adding elemetns at the botom not top 
        stack = insertAtBottom(stack, top);
        return stack;
    }

    public static Stack<Integer> appendElementInSortedStack(Stack<Integer> stack , int  element){
        if ( stack.empty()){
            stack.push(element);
            return stack;
        }
        int top = stack.peek();
        if ( top>=element){
            stack.push(element);
            return stack ; 

        }
        else{
            stack.pop(); 
            appendElementInSortedStack(stack , element);
            stack.push(top);
            return stack;
        }

    }
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        if ( stack.empty()){
            return stack;
        }
        int top = stack.pop();
        sortStack(stack);
        appendElementInSortedStack(stack, top);

        return stack;

    }
    
}
