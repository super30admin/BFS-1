// Works on leetcode
// Time complexity - O(v+e)
// Space complexity - O(courses)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap <Integer, List<Integer>> courses = new HashMap<>();
        
        // Create hashmap and indegree array
        for(int[] x: prerequisites){
            int to = x[0];
            int from = x[1];
            if (!courses.containsKey(from)) {
                courses.put(from, new ArrayList<>());
            }
            courses.get(from).add(to);
            inDegree[to] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        // Add root node --> indegree 0
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        // Do BFS to find all edges - reduce indegree
        while(!queue.isEmpty()){
            int front = queue.poll();
            if(courses.containsKey(front)){
                for(int x: courses.get(front)){
                    inDegree[x] = inDegree[x] - 1;
                    if(inDegree[x] == 0){
                        queue.add(x);
                    }
                }
            }
        }
        // If any edge is not found in BFS --> reverse edge
        for(int x: inDegree){
            if (x!=0){
                return false;
            }
        }
        return true;
    
    }    
}
