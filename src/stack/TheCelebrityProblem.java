package stack;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class TheCelebrityProblem {
    public static void main(String[] args) {

    }

    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (mat[a][b] == 1) {
                st.push(b);
            } else {
                st.push(a);
            }
        }

        int candidate = st.pop();
        //System.out.println(candidate);
        //1. Verify Row: Celebrity should know NO ONE (except maybe themselves)
        boolean rowCheck = true;
        for (int i = 0; i < n; i++) {
            // If candidate knows 'i' AND 'i' is not the candidate themselves
            if (mat[candidate][i] == 1 && i != candidate) {
                rowCheck = false;
                break;
            }
        }

// 2. Verify Column: EVERYONE should know the celebrity
        boolean colCheck = true;
        for (int i = 0; i < n; i++) {
            // If 'i' does NOT know candidate AND 'i' is not the candidate themselves
            if (mat[i][candidate] == 0 && i != candidate) {
                colCheck = false;
                break;
            }
        }
        if (rowCheck && colCheck) {
            return candidate;
        } else {
            return -1;
        }
    }
}
