class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int oddCount = 0;
        for (int num : nums1) {
            if (num < min) {
                min = num;
            }
            if (num % 2 == 1) {
                oddCount++;
            }
        }

        boolean canAllOdd = (min % 2 == 1);
        boolean canAllEven = (oddCount == 0);
        return canAllOdd || canAllEven;
    }
}