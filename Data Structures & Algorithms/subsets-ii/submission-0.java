class Solution {
    public void func(int index, int[] nums, List<Integer> ds,
    List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            func(i+1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        func(0, nums, ds, ans);
        return ans;
    }
}
