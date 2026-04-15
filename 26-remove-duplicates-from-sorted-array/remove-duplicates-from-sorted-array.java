class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // 'i' is the pointer for the last unique element found
        int i = 0;

        // 'j' is the scanner pointer that moves through the array
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++;           // Move the unique pointer forward
                nums[i] = nums[j]; // Update the next unique slot with the new value
            }
        }

        // The number of unique elements is i + 1 (since i is an index)
        return i + 1;
    }
}