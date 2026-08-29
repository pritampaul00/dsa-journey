class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Map each sorted value to an original position
        // Using pairs avoids duplicate-value problems.
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;

        while (left < n) {

            int right = left;

            while (right + 1 < n &&
                   pairs[right + 1][0] - pairs[right][0] <= limit) {
                right++;
            }

            int size = right - left + 1;

            int[] positions = new int[size];

            for (int i = 0; i < size; i++) {
                positions[i] = pairs[left + i][1];
            }

            Arrays.sort(positions);

            for (int i = 0; i < size; i++) {
                nums[positions[i]] = pairs[left + i][0];
            }

            left = right + 1;
        }

        return nums;
    }
}