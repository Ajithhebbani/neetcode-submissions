class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character to the window
            int index = s.charAt(right) - 'A';
            freq[index]++;

            // Highest frequency character in current window
            maxFreq = Math.max(maxFreq, freq[index]);

            // Current window size
            int windowSize = right - left + 1;

            // Characters that need replacement:
            // windowSize - maxFreq
            while (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                windowSize = right - left + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    
}
