class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize maxSoFar with the first element of the array
        int maxSoFar = nums[0];
        // currentMax also starts at the first element
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            /* Decide: Is it better to start a new subarray at nums[i], 
               or continue the existing one?
            */
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update the overall maximum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}