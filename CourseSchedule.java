// Time Complexity : O(V+E), we will be going all the edges and vertices
// Space Complexity : O(V+E), adjacenct list will have all the vertices and edges
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : keep adding courses in queue as they become independent 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>(); // Adjacency list.
        int[] indegree = new int[numCourses]; // to store dependency of each course
        int count = 0;

        for(int[] cp : prerequisites){
            int course = cp[0];
            int preReq = cp[1];

            indegree[course]++; // course is dependent
            if(!adj.containsKey(preReq)){
                adj.put(preReq, new ArrayList<Integer>());
            }

            adj.get(preReq).add(course); 
        }
        // System.out.println(adj);
        Queue<Integer> q = new LinkedList<>();
        
        // find all completed course
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0){ 
                q.add(i);
                count++;
            }
        }
        // System.out.println(count);
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int course = q.poll(); 
            List<Integer> li = adj.get(course);
            if(li == null) continue;
            for(int i = 0 ; i < li.size(); i++){
                int preCourse = li.get(i);
                // System.out.println(preCourse);
                if(--indegree[preCourse] == 0){ //course completed
                    q.add(preCourse);
                    count++;
                    if(count == numCourses) return true;
                }
                
            }
        }
        // System.out.println(count);
        return count == numCourses ? true : false;
    }
}