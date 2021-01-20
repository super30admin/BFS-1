class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int [numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int [] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i< indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List<Integer> edges = map.get(curr);
            if(edges != null){
                for(int edge : edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                    }
                }
            }
        }
        if(count != numCourses) return false;
        return true;
    }
}
