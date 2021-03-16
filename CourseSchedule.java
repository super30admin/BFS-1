// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites){
            if(map.containsKey(pre[1]))
                map.get(pre[1]).add(pre[0]);
            else
                map.put(pre[1],new ArrayList<>(Arrays.asList(pre[0])));
            inDegree[pre[0]]++;
        }
        Queue<Integer> que = new LinkedList();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int n  = que.poll();
            if(map.containsKey(n)){
                List<Integer> temp = map.get(n);
                for(int t:temp){
                    inDegree[t]--;
                    if(inDegree[t] == 0){
                        que.add(t);
                    }
                }
            }
        }
        for(int i:inDegree){
            if(i != 0) return false;
        }
        return true;
    }
}
