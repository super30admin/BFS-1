class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> outdegrees = new HashMap<>();
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!outdegrees.containsKey(edge[1])){
                outdegrees.put(edge[1], new ArrayList<>());
            }
            outdegrees.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i]==0){
                q.add(i);
                count++;
            }
        }
        
        if(q.isEmpty()) return false;
        
        int curr;

        while(!q.isEmpty()){
            curr = q.poll();
            if(outdegrees.get(curr)!=null){
                for(int i : outdegrees.get(curr)){
                    indegrees[i]--;
                    if(indegrees[i]==0){
                        q.add(indegrees[i]);
                        count++;
                        if(count==numCourses) return true;
                    }
                }
            }
        }
        
        if (count < numCourses) return false;
        return true;
    }
}
