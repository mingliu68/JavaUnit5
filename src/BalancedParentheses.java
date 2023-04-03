import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String str1 = "((aba)())";
        String str2 = "(((c)))))(a)))";
        String str3 = "(a";

        System.out.println(isBalanced(str1));
        System.out.println(isBalanced(str2));
        System.out.println(isBalanced(str3));

    }

    public static Boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        // if(str.length() == 0) {
        //     return true;
        // } else if (str.charAt(0)==')') {
        //     return false;
        // } else {
        //     stack.push(str.charAt(0));
        // }
        for(int i = 0; i < str.length(); i++) {
            if(stack.empty() && str.charAt(i) == ')') {
                return false;
            } else {
                if(str.charAt(i)==')' && stack.peek() == '(') {
                    stack.pop();
                } else if (str.charAt(i) == '(' || str.charAt(i) == ')' ) {
                    stack.push(str.charAt(i));
                }
            }
        }

        return stack.empty();
    }
}
