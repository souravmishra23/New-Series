package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12})));
        System.out.println(Arrays.toString(nextGreaterElementCircular(new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12})));
    }

    public static int[] nextGreaterElement(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nge, -1);
        for (int i = 0; i < nums.length; i++) {

            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int top = st.pop();
                nge[top] = i;
            }

            st.push(i);
        }
        return nge;
    }

    public static int[] nextGreaterElementCircular(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nge, -1);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {

                while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                    int top = st.pop();
                    nge[top] = i;
                }

                st.push(i);
            }
        }
        return nge;
    }

    public static int [] previousGreater(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int [] prevGreater = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                prevGreater[i] = st.peek();
            }
            st.push(i);
        }
        return prevGreater;
    }
}
