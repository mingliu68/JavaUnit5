import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NonTestingBalancedBrackets {
    public static void main(String[] args) {



        String str1 = "({aba}())";
        String str2 = "((([c]))<>)))(a)))";
        String str3 = "(a)<";
        String str4 = ",,,,>><<";

        System.out.println(isBalanced(str1));
        System.out.println(isBalanced(str2));
        System.out.println(isBalanced(str3));
        System.out.println(isBalanced(str4));


    }

    private static Character[] chars = {'(' , ')' , '{' , '}' , '<', '>', '[', ']'};
    private static List<Character> charsList = Arrays.asList(chars);

    public static Boolean isBalanced(String str) {
        // Character[] chars = {'(' , ')' , '{' , '}' , '<', '>', '[', ']'};
        // List<Character> charsList = Arrays.asList(chars);
        Stack<Character> stack = new Stack<>();

        // O(n)
        for(int i = 0; i < str.length(); i++) {
            if(charsList.contains(str.charAt(i))) {
                if(stack.empty()) {
                    stack.push(str.charAt(i));
                } else if(getMatchingChar(str.charAt(i)) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        return stack.empty();
    }

    

    public static char getMatchingChar(char c) {
        switch(c){
            case '}':
                return '{';
            case ']':
                return '[';  
            case '>':
                return '<'; 
            case ')':
                return '(';
        }   

        return ' ';
    }
}
