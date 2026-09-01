class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return step;
            }
            char[] arr = word.toCharArray();
            for(int i = 0; i<arr.length; i++){
                char original = arr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String replacedWord = new String(arr);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, step + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
