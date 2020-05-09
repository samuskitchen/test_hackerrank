package almost_sorted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

    static int minDeletions(List<Integer> arr) {
        int[] dp = new int[arr.size()];
        int len = 0;

        for (int num : arr) {
            int i = Arrays.binarySearch(dp, 0, len, num);

            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = num;

            if (i == len) {
                len++;
            }
        }

        return (arr.size() - len) == 0 ? (arr.size() - len) : (arr.size() - len) -1;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(5);
        arr.add(10);

        System.out.println("Minimum number of deletions = " +  minDeletions(arr));
    }

}
