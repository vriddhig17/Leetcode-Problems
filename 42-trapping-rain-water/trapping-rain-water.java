class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            // Decide which pointer to move based on which side is lower
            if (height[left] < height[right]) {
                // If current height is greater than leftMax, update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Otherwise, we can trap water
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // If current height is greater than rightMax, update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Otherwise, we can trap water
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}