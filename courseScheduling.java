//time complexity O(V+E) where V is the vertices and E is the edges of the graph
//space complexity O(V+V)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
            map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int j = 0; j < indegrees.length; j++){
            if(indegrees[j] == 0){
                q.add(j);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        for(int k = 0; k < indegrees.length; k++){
            if(indegrees[k] > 0){
                return false;
            }
        }
        return true;
    }
}
