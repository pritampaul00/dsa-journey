class Solution {

    public boolean canJump(int[] nums) {

        int n = nums.length;

        boolean[] dp = new boolean[n];

        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {

            for (int jump = 1;
                 jump <= nums[i] && i + jump < n;
                 jump++) {

                if (dp[i + jump]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}