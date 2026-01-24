package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String t: tokens) {
            switch (t) {
                case "+" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val1 + val2);
                }
                case "-" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val2 - val1);
                }
                case "*" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val1 * val2);
                }
                case "/" -> {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    st.push(val2 / val1);
                }
                default -> {
                    Integer val = Integer.parseInt(t);
                    st.push(val);
                }
            }
        }

        return st.peek();
    }
}
