import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Base Check: If total sum isn't divisible by k, it's impossible
        if (totalSum % k != 0) return false;
        int target = totalSum / k;

        // dp[mask] stores the current sum of the subsets formed by the numbers in the mask.
        // If dp[mask] == -1, that combination of numbers is invalid.
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == -1) continue; // Skip unreachable states

            for (int i = 0; i < n; i++) {
                // If the i-th number hasn't been used in this mask
                if ((mask & (1 << i)) == 0) {
                    int nextMask = mask | (1 << i);
                    
                    // Logic: Check if adding nums[i] fits into the current target bucket
                    // (dp[mask] % target) gives the remainder/current fill level of the current subset
                    if (dp[mask] % target + nums[i] <= target) {
                        dp[nextMask] = dp[mask] + nums[i];
                    }
                }
            }
        }

        // If the last state (all numbers used) equals the total sum, we found a partition
        return dp[(1 << n) - 1] == totalSum;
    }
}