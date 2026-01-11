package stack;

import java.util.Stack;

public class ScoreOfParantheses {
    public static void main(String[] args) {

    }

    public int scoreOfParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (Character ch: s.toCharArray()) {
            if (ch == '(') {
                st.push('(');
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    st.push('1');
                } else {
                    if (!st.isEmpty() && st.peek() != '(') {
                        int sum = 0;

                        while (!st.isEmpty() && st.peek() != '(') {
                            sum += (st.pop() - '0');
                        }

                        st.pop();
                        st.push((char) (2 * sum + '0'));
                    }
                }
            }
        }
        int sum = 0;

        while (!st.isEmpty()) {
            sum += (st.pop() - '0');
        }
        return sum;
    }
}
