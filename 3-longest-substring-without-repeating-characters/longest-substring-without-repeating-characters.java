class Solution {
    public int lengthOfLongestSubstring(String s) {
        int freq[] = new int[128], si = 0, ei = 0, duplicateTracker = 0, n = s.length(), maxLength = 0;
        while(ei < s.length()) {
            if(freq[s.charAt(ei)] == 1) {
                duplicateTracker = 1;
            }
            freq[s.charAt(ei)]++;
            ei++;
            while(duplicateTracker == 1) {
                if(freq[s.charAt(si)] == 2) {
                    duplicateTracker = 0;
                }
                freq[s.charAt(si)]--;
                si++;
            }
            maxLength = Math.max(maxLength, ei - si);
        }
        return maxLength;
 
    }
}