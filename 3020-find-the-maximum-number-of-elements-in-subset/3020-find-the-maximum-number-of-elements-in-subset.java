class Solution {

    public int maximumLength(int[] nums) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        if (freq.containsKey(1L)) {
            int ones = freq.get(1L);
            ans = Math.max(ans, ones % 2 == 0 ? ones - 1 : ones);
        }

        for (long start : freq.keySet()) {

            if (start == 1L) {
                continue;
            }

            long curr = start;
            int length = 0;

            while (freq.getOrDefault(curr, 0) >= 2) {

                length += 2;

                if (curr > 1_000_000_000L) {
                    break;
                }

                curr *= curr;
            }

            if (freq.getOrDefault(curr, 0) == 1) {
                length++;
            } else {
                length--;
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }
}