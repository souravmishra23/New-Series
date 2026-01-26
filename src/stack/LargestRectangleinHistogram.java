package stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int [] nextSmaller = new int[heights.length];
        Arrays.fill(nextSmaller, heights.length);
        int [] prevSmaller = new int[heights.length];
        Arrays.fill(prevSmaller, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0 ; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int top = st.pop();
                nextSmaller[top] = i;
            }

            if (!st.isEmpty()) {
                prevSmaller[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = 1;

        for (int i = 0 ; i < heights.length; i++) {
            int currentHeight = heights[i];

            int width = nextSmaller[i] - prevSmaller[i] - 1;

            maxArea = Math.max(maxArea, currentHeight * width);
        }

        return maxArea;
    }
}
