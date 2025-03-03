class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int[] pair:prerequisites){
            indegree[pair[1]]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0) q.add(i);
        }
        int select = 0;
        while(!q.isEmpty()){
            numCourses--;
            int course = q.poll();
            for(int[] pair:prerequisites){
                if(pair[0] == course){
                    indegree[pair[1]]--;
                    if(indegree[pair[1]] == 0) q.add(pair[1]);
                }
            }
        }
        return numCourses == 0;
    }
}