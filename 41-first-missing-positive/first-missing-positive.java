class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. Cyclic Sort: Put each number in its right place (nums[i] at index nums[i] - 1)
        for (int i = 0; i < n; i++) {
            // While the current number is in the valid range [1, n] 
            // and it's not already at its correct index:
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the number at its target position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 2. Find the first index where the value doesn't match the index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all positions are correct, the missing number is n + 1
        return n + 1;
    }
}