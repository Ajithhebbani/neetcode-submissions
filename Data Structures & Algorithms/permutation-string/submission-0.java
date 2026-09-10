class Solution {
    public boolean checkInclusion(String s1, String s2) {
     if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int windowSize = s1.length();

        // First window
        for (int i = 0; i < windowSize; i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(s1Count, windowCount)) {
            return true;
        }

        // Slide the window
        for (int right = windowSize; right < s2.length(); right++) {

            // Add new character
            windowCount[s2.charAt(right) - 'a']++;

            // Remove left character
            int left = right - windowSize;
            windowCount[s2.charAt(left) - 'a']--;

            // Check if current window is permutation of s1
            if (matches(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
