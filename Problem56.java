TimeComplexity : O(V+E)
SpaceComplexity : O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length<1) return true;
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!hm.containsKey(edge[1])){
                hm.put(edge[1], new ArrayList());
            }
            hm.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> child = hm.get(cur);
            if(child != null){
                for(int children : child){
                    indegrees[children]--;
                    if(indegrees[children] == 0){
                        q.add(children);
                    }
                }
            }
        }
        
        for(int i = 0; i<indegrees.length; i++){
            if(indegrees[i] > 0) return false;
        }
        return true;
    }
}