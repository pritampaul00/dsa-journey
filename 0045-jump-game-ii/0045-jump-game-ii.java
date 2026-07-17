class Solution {

    public int jump(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            for (int jump = 1;
                 jump <= nums[i] && i + jump < n;
                 jump++) {

                dp[i + jump] = Math.min(dp[i + jump],
                                        dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}