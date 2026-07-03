class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums,
                           int target,
                           int start,
                           List<Integer> curr) {

        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            curr.add(nums[i]);

            backtrack(nums,
                    target - nums[i],
                    i + 1,
                    curr);

            curr.remove(curr.size() - 1);
        }
    }
}