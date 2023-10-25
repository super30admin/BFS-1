// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int[] tmp : prerequisites){
            int course = tmp[0];
            int prereq = tmp[1];
            if(adj[prereq]==null)
                adj[prereq] = new ArrayList<>();
            adj[prereq].add(course);
            indegree[course]++;}
        for(int i = 0; i < n; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            ans.add(x);
            if(adj[x]!=null){
            for( int i : adj[x]){
                indegree[i]--;
                if(indegree[i]==0)
                    queue.offer(i);
            }}
        }
        return ans.size() == n;
    }
}