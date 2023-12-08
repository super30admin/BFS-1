// Time Complexity: O(V + E)
//  Space Complexity: O(V + E)
// BFS Approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegrees[] = new int[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] pr: prerequisites){
            indegrees[pr[0]]++;
            if(!adj.containsKey(pr[1])){
                adj.put(pr[1], new ArrayList<>());
            }
            adj.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        for(int i=0; i< numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;

        while(!q.isEmpty()){
            Integer course = q.poll();
            List<Integer> li = adj.get(course);
            if(li != null){
                for(Integer i: li ){
                    indegrees[i]--;
                    if(indegrees[i] == 0) {
                        count++;
                        q.add(i);
                        if(count == numCourses) return true;
                    }
                }
            }
            
        }
        return false;

    }
}