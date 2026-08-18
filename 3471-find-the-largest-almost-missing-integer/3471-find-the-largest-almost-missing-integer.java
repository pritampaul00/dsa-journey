class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }

        // Only one subarray: the entire array
        if (k == n) {
            int max = -1;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Every element is its own subarray
        if (k == 1) {
            int max = -1;

            for (int num : nums) {
                if (freq[num] == 1) {
                    max = Math.max(max, num);
                }
            }

            return max;
        }

        // 1 < k < n
        int answer = -1;

        if (freq[nums[0]] == 1) {
            answer = Math.max(answer, nums[0]);
        }

        if (freq[nums[n - 1]] == 1) {
            answer = Math.max(answer, nums[n - 1]);
        }

        return answer;
    }
}