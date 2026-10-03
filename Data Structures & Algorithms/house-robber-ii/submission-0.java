class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        int case1 = robLinear(nums, 0, n -2);
        int case2 = robLinear(nums, 1, n-1);
        return Math.max(case1, case2);
    }


    private int robLinear(int[] nums, int start, int end){
        int rob1 = 0;
        int rob2 = 0;

        for(int i = start; i <= end; i++){
            int current = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = current;
        }
        return rob2;
    }
}
