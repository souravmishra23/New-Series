package binarysearch;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
       System.out.println(shipWithinDays(new int[] {3,2,2,4,1,4}, 3));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int max = weights[0];
        int sum = 0;

        for (int w: weights) {
            max = Math.max(max, w);
            sum += w;
        }

        int low = max;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isCapacityEnough(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static boolean isCapacityEnough(int [] weights, int days, int capacity) {
        int total = 0;
        int totalDays = 1;

        for (int w: weights) {
            total += w;

            if (total > capacity) {
                total = w;
                totalDays += 1;
            }

            if (totalDays > days) {
                return false;
            }
        }
        return true;
    }
}
