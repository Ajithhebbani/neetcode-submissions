class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap hm = new HashMap();

        for(int i=0;i<nums.length;i++){
            if(hm.keySet().contains(nums[i])){
                return true;
            }
            else{
                hm.put(nums[i], 1);
            }
        }
        return false;
    }
}