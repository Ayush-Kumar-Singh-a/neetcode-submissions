class TimeMap {
    class Data{
        int timestamp;
        String value;
        Data(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    HashMap<String, ArrayList<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Data> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(list.get(mid).timestamp <= timestamp){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(ans == -1){
            return "";
        }
        return list.get(ans).value;
    }
}
