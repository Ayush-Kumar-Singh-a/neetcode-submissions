class Solution {
    public void func(int index, int target, int[] candidates, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i >index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            ds.add(candidates[i]);
            func(i + 1, target - candidates[i], candidates, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        func(0, target, candidates, ds, ans);
        return ans;
    }
}
