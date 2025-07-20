package dp.minmax;

import java.util.Arrays;

public class HourseRobberCircularHouse {
    public static void main(String[] args) {
        int [] arr = new int[]{4, 1, 6, 10};
        int n = arr.length;
        int [] withoutFirst = new int[arr.length - 1];
        int [] withoutLast = new int[arr.length - 1];
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                withoutFirst[j++] = arr[i];
            }
            if (i != n - 1) {
                withoutLast[k++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(withoutFirst));
        System.out.println(Arrays.toString(withoutLast));
        int loot1 = maxMoneyLooted(withoutFirst);
        int loot2 = maxMoneyLooted(withoutLast);

        System.out.println(Math.max(loot1, loot2));
    }


    public static int maxMoneyLooted(int[] houses) {
        //Your code goes here

        int n = houses.length;
        if (n == 1) return houses[0];
        int prev2 = 0;
        int prev = houses[0];

        for (int i = 1; i < n; i++) {
            int take = houses[i];
            if (i > 1) take += prev2;
            int nottake = prev;
            int curri = Math.max(take, nottake);
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }
}
