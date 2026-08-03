class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];

        return dfs(obstacleGrid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int row, int col, Integer[][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n || grid[row][col] == 1)
            return 0;

        if (row == m - 1 && col == n - 1)
            return 1;

        if (dp[row][col] != null)
            return dp[row][col];

        int down = dfs(grid, row + 1, col, dp);
        int right = dfs(grid, row, col + 1, dp);

        return dp[row][col] = down + right;
    }
}