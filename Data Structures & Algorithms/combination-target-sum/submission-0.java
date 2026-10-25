class Solution {
    public void func(int index, int target, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        if(index == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            return; 
        }
        if(nums[index] <= target){
            ds.add(nums[index]);
            func(index, target - nums[index], nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
        func(index + 1, target, nums, ds, ans);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        func(0, target, nums, ds, ans);
        return ans;
    }
}
