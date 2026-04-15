class Solution {
    public int removeDuplicates(int[] nums) {
        // 'i' is the pointer for the position where the next valid element will be placed
        int i = 0;
        
        for (int n : nums) {
            // If the current element is one of the first two, 
            // or if it's different from the element placed two spots back.
            if (i < 2 || n > nums[i - 2]) {
                nums[i] = n;
                i++;
            }
        }
        
        // 'i' represents the length of the array after removing extra duplicates
        return i;
    }
}