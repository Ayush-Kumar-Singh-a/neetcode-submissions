class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0; i<m; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] dist = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        q.add(new Tuple(0, src, 0));
        while(!q.isEmpty()){
            int stops = q.peek().first;
            int node = q.peek().second;
            int cost = q.peek().third;
            q.poll();
            if(stops > k) continue;
            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int edgeWeight = it.second;
                if(cost + edgeWeight < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuple(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst] == (int)(1e9)){
            return -1;
        }
        return dist[dst];
    }
}
