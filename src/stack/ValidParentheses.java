package stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String [] args) {
        System.out.println(isValid("()"));
    }


    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (Character ch: s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (!st.isEmpty() && ch == ')' && st.peek().equals('(')) {
                st.pop();
            } else if (!st.isEmpty() && ch == '}' && st.peek().equals('{')) {
                st.pop();
            } else if (!st.isEmpty() && ch == ']' && st.peek().equals('[')) {
                st.pop();
            } else {
                return false;
            }


        }


        return st.isEmpty();
    }
}
