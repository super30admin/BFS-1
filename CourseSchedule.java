// Time Complexity : O(V+E) // no of edges and vertices
// Space Complexity: O(V + E) same since indegree array and HashMap (V+E)

 // Checks if all courses can be completed given their prerequisites.
 // Builds a graph and processes courses with no prerequisites first.
 // Returns false if a cycle is detected in the course dependency graph.
 class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int indegree[] = new int[numCourses];//O(n)
        int n = prerequisites.length;

        HashMap<Integer,List<Integer>> hmap = new HashMap<>();

        for(int i = 0; i<n;i++){
            
            int ind = prerequisites[i][1];
            int dep = prerequisites[i][0];

            indegree[dep]++;

            if(!hmap.containsKey(ind)){
                hmap.put(ind, new ArrayList<>());
            }
        
            hmap.get(ind).add(dep);



        }

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<numCourses; i++ ){

            if(indegree[i]==0){
                queue.add(i);
                count++;
            }
            

        }

        if (count==numCourses) return true;
        if(queue.isEmpty()) return false;

        while(!queue.isEmpty()){
            int currCourse = queue.poll();

            List<Integer> children = hmap.get(currCourse);

            if(children==null){
                continue;
            }

            for(Integer child: children ){
                indegree[child]--;

                if(indegree[child] == 0){
                    queue.add(child);
                    count++;

                    if(count == numCourses) return true;
                }
            }
        }

        return false;

    }
}
