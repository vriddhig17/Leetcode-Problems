class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;
        Map<Long, Long> map = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            long diff = (long) (i - nums[i]);
            goodPairs += map.getOrDefault(diff, 0L);
            map.put(diff, map.getOrDefault(diff, 0L) + 1);
        }

        return totalPairs - goodPairs;
    }
}