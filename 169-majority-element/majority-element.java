import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            if (freq > n / 2) return num;
            map.put(num, freq);
        }
        return -1; // never happens as majority exists
    }
}
