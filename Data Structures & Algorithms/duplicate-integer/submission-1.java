class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
			for(Integer i : nums) {
				set.add(i);
			}
            if(nums.length==set.size()) {
				
				return false;
				
			}
            return true;
    }
}