package stack;

import java.util.Stack;

/*Example 1:

Input: s = "1 + 1"
Output: 2

Example 2:

Input: s = " 2-1 + 2 "
Output: 3

Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
*/
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate(" 2-1 + 2 "));
    }

    public static int calculate(String s) {
        int sum = 0;
        int sign = 1;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val = val * sign;
                sum += val;
                sign = 1;

            } else if (ch == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum *= st.pop();
                sum += st.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }

        return sum;
    }
}
