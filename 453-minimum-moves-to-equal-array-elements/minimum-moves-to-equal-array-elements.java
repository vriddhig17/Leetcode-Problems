class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        // Find minimum and sum
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        // Apply formula
        return sum - (min * nums.length);
    }
} 