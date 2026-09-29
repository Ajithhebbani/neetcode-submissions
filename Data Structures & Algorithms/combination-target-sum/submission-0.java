class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
           List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }

            current.add(nums[i]);

            // i, not i + 1, because we can reuse the same number
            backtrack(nums, target - nums[i], i, current, result);

            // Backtrack: remove the last number
            current.remove(current.size() - 1);
        }
}
}