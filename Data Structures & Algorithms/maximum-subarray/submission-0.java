public class Solution {
    public int maxSubArray(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r) {
            return Integer.MIN_VALUE;
        }
        int m = (l + r) >> 1;
        int leftSum = 0, rightSum = 0, curSum = 0;
        for (int i = m - 1; i >= l; i--) {
            curSum += nums[i];
            leftSum = Math.max(leftSum, curSum);
        }

        curSum = 0;
        for (int i = m + 1; i <= r; i++) {
            curSum += nums[i];
            rightSum = Math.max(rightSum, curSum);
        }

        return Math.max(dfs(nums, l, m - 1),
                        Math.max(dfs(nums, m + 1, r),
                             leftSum + nums[m] + rightSum));
    }
}