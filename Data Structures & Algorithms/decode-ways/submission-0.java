class Solution {
    public int numDecodings(String s) {
         if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();

        // dp[i] = number of ways to decode the first i characters
        int[] dp = new int[n + 1];

        dp[0] = 1; // Empty string has one valid way
        dp[1] = 1; // First character is non-zero

        for (int i = 2; i <= n; i++) {

            // Option 1: Decode the current digit individually
            int oneDigit = s.charAt(i - 1) - '0';

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Option 2: Decode the last two digits together
            int twoDigits =
                    Integer.parseInt(s.substring(i - 2, i));

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
