class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        Integer[][] dp = new Integer[m][n];

        return solve(word1, word2, 0, 0, dp);
    }

    private int solve(
            String word1,
            String word2,
            int i,
            int j,
            Integer[][] dp) {

        if (i == word1.length()) {
            return word2.length() - j;
        }

        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] =
                    solve(word1, word2, i + 1, j + 1, dp);
        }

        int insert = solve(word1, word2, i, j + 1, dp);
        int delete = solve(word1, word2, i + 1, j, dp);
        int replace = solve(word1, word2, i + 1, j + 1, dp);

        return dp[i][j] =
                1 + Math.min(insert, Math.min(delete, replace));
    }
}