class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result);

        return result;
    }

    private void backtrack(
        int start,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        // Every current state is a valid subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}