class KthLargest {
    ArrayList<Integer> list = new ArrayList<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list, Collections.reverseOrder());
        if(list.size() < k){
            return -1;
        }
        return list.get(k - 1);
    }
}
