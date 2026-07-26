class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int picked = target - nums[i];
            if(map.containsKey(picked)){
                return new int [] {map.get(picked),i};
            }
            map.put(nums[i],i);
        }
    return new int[] {};
    }
}
