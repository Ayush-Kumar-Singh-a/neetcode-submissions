class Twitter {
    int count;
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followerMap;
    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{count, tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        if(!followerMap.containsKey(userId)){
            followerMap.put(userId, new HashSet<>());
        }
        followerMap.get(userId).add(userId);
        for(int followeeId: followerMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
            int i = tweetMap.get(followeeId).size() - 1;
            int[] tweet = tweetMap.get(followeeId).get(i);
            pq.add(new int[]{tweet[0], tweet[1], followeeId, i - 1});
            }
        }
        while(!pq.isEmpty() && res.size() < 10){
            int[] data = pq.poll();
            res.add(data[1]);
            if(data[3] >= 0){
                int[] tweet = tweetMap.get(data[2]).get(data[3]);
                pq.add(new int[]{tweet[0], tweet[1], data[2], data[3] - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId, new HashSet<>());
        }
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(followerMap.containsKey(followerId)){
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
