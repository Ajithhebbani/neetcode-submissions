class Solution {
    public int findMin(int[] nums) {
         int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[right]) {
            // Minimum is somewhere to the right of mid
            left = mid + 1;
        } else {
            // Minimum is mid or somewhere to the left
            right = mid;
        }
    }

    return nums[left];
    }
}
