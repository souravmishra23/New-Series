package binarysearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 5));
    }

    // need to find out optimal value of k k is number of banannas that koko can eat per h so that she call finish all in h
    public static int minEatingSpeed(int[] piles, int h) {
        int high = Integer.MIN_VALUE;
        for (int p: piles) {
            high = Math.max(p, high);
        }

        int low = 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (blackbox(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean blackbox(int maxPiles, int [] piles, int h) {
        int time = 0;
        for (int i : piles) {
            time += i / maxPiles;

            if (i % maxPiles != 0) {
                time += 1;
            }
        }
        if (time <= h) {
            return true;
        }
        return false;
    }
}
