class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int longest = 1;
        int count = 0;
        int lastSmaller = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            if(nums[i] - 1 == lastSmaller){
                count++;
                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller){
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
