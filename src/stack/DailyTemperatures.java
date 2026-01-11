package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})));
        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{30,60,90})));
    }

    // brute force giving tle
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = getDaysToWait(temperatures, i, n);
        }
        return ans;
    }

    public static int getDaysToWait(int [] temperatures, int i, int n) {
        int temp = temperatures[i];
        int j = i + 1;
        int count = 1;
        while (j < n) {
            if (temperatures[j] <= temp) {
                count++;
                j++;
            } else {
                break;
            }
        }
        if (j >= n) {
            return 0;
        }
        return count;
    }

    // using stack and nge concept..

    public static int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        
        int [] nge = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int stackTop = st.pop();

                nge[stackTop] = i - stackTop;
            }

            st.push(i);

        }
        return nge;
    }
}
