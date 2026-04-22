import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefixSum = 0;
        // HashMap to store (prefixSum, frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a prefix sum of 0 has been seen once (empty prefix)
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum += nums[i];
            
            // If (currentPrefixSum - k) exists in the map, it means there is
            // a subarray ending at i that sums to k
            if (map.containsKey(currentPrefixSum - k)) {
                count += map.get(currentPrefixSum - k);
            }
            
            // Update the frequency of the current prefix sum in the map
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return count;
    }
}