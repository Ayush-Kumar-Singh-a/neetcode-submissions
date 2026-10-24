class Solution {
    public void func(int index, int[] nums, List<Integer> ds,
    List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        func(index + 1, nums, ds, ans);
        ds.remove(ds.size() - 1);
        func(index + 1, nums, ds, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        func(0, nums, ds, ans);
        return ans;
    }
}
