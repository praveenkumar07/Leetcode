package Amazon;

import topological.OrderVertices;

import java.util.List;

public class MinSwaps {
    public int minSwaps(int[] data) {

        // first count number of 1s in the array
        int numOnes = 0;
        for (int num : data) {
            if (num == 1) numOnes++;
        }

        // for every fixed window with size numOnes, the swaps need to do is the number of zeros within this window (or window size - number of ones)
        int k = numOnes;
        int maxOnes = 0;
        int windowOnes = 0;

        for (int l = 0, r = 0; r < data.length; r++) {

            windowOnes += data[r];

            if (r - l == k - 1) {
                maxOnes = Math.max(maxOnes, windowOnes);
                windowOnes -= data[l++];
            }
        }

        return k - maxOnes;
    }
    public static void main(String[] args) {
        int[] data = new int[] { 1,0,1,0,1 };
        MinSwaps minSwaps = new MinSwaps();
        minSwaps.minSwaps(data);
    }

}
