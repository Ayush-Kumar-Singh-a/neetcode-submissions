class Solution {
    public void func(boolean[] pick, int[] nums, List<Integer> perm, List<List<Integer>> ans){
        if(perm.size() == nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(pick[i]){
                continue;
            }
            perm.add(nums[i]);
            pick[i] = true;
            func(pick, nums, perm, ans);
            perm.remove(perm.size() - 1);
            pick[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> perm = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        func(pick, nums, perm, ans);
        return ans;
    }
}
