class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];

        for (int digit : digits) {
            count[digit]++;
        }

        int ans = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 8; c += 2) {

                    if (count[a] == 0 ||
                        count[b] == 0 ||
                        count[c] == 0) {
                        continue;
                    }

                    count[a]--;

                    if (count[b] > 0) {
                        count[b]--;

                        if (count[c] > 0) {
                            ans++;
                        }

                        count[b]++;
                    }

                    count[a]++;
                }
            }
        }

        return ans;
    }
}