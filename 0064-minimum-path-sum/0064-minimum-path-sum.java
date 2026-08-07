class Solution {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Integer[][] dp = new Integer[m][n];

        return dfs(grid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int row, int col, Integer[][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n)
            return Integer.MAX_VALUE;

        if (row == m - 1 && col == n - 1)
            return grid[row][col];

        if (dp[row][col] != null)
            return dp[row][col];

        int down = dfs(grid, row + 1, col, dp);
        int right = dfs(grid, row, col + 1, dp);

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }
}