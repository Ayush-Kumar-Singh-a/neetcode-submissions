class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[n + 1];
        for(int num: map.keySet()){
            int frequency = map.get(num);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }
        int[] result = new int[k];
        int index = 0;
        for(int frequency = buckets.length - 1; frequency>= 0 && index < k; frequency--){
            if(buckets[frequency] != null){
                for(int num: buckets[frequency]){
                    result[index] = num;
                    index++;
                    if(index == k){
                        break;
                    }
                }
            }
        }
        return result;
    }
}
