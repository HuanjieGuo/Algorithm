package secondOffer.stack;

import java.util.Stack;

public class Offer0031_ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx_pop = 0;
        for(int value:pushed){
            stack.push(value);
            while (stack.size()!=0
                    &&popped[idx_pop]==stack.peek()){
                stack.pop();
                idx_pop++;
            }
        }
        return stack.empty();
    }
}
