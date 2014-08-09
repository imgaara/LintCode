import java.util.Arrays;

/**
 * Created by Administrator on 2014/8/9 0009.
 */
public class Longest_Increasing_Subsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        final int n = nums.length;
        int[] L = new int[n];

        L[0] = 1;
        for (int i = 1; i < n; ++i) {
            int max = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (L[j] > max) {
                        max = L[j];
                    }
                }
            }

            L[i] = max + 1;
        }

        return L[n-1];
    }

    /**
     * @see(http://blog.csdn.net/linulysses/article/details/5559262)
     * @see(http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/)
     * @see(http://www.csie.ntnu.edu.tw/~u91029/LongestIncreasingSubsequence.html)
     * @param nums
     * @return
     */
    public int longestIncreasingSubsequence2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        final int n = nums.length;
        int[] K = new int[n+2];
        Arrays.fill(K, Integer.MAX_VALUE);
        K[0] = 0;
        K[1] = nums[0];
        int l = 1;
        for (int i = 1; i < n; ++i) {
            int pos = binarySearch(nums, i, K, 1, l);
            if (nums[i] < K[pos + 1]) {
                K[pos + 1] = nums[i];
            }

            if (pos >= l) {
                l++;
            }
        }

        return l;
    }

    private int binarySearch(int[] A, int i, int[] K, int start, int end) {
        while (start <= end) {
            int mid = (start+end) >> 1;
            if (K[mid] < A[i] && A[i] <= K[mid+1]) {
                return mid;
            } else if (K[mid] >= A[i]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println(new Longest_Increasing_Subsequence().longestIncreasingSubsequence2(new int[]{4, 2, 4, 5, 3, 7})
        );
    }
}
