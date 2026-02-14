import java.util.*;   // <-- REQUIRED import

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged list is empty OR no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } 
            // Overlapping intervals → merge
            else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
