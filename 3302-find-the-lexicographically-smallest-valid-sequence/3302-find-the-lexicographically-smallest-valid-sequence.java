class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = position in word1 where word2[j]
        // can be matched while preserving the remaining sequence
        int[] last = new int[m];

        Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        // Build the rightmost possible matching positions
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We can use at most one mismatch
        boolean canMismatch = true;

        j = 0;

        for (i = 0; i < n && j < m; i++) {

            // Normal matching character
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }

            // Use the one allowed mismatch
            else if (canMismatch &&
                    (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;
                canMismatch = false;
            }
        }

        // Could not construct the complete sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}