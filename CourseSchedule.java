// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // intialize indegrees array to keep count of dependencies of each node
        int[] indegrees = new int[numCourses];
        // intialize adjacency list to keep track of dependencies (child nodes) on each node
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // fill the indegrees array and adjacency list
        for(int[] edge: prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        // intialize count
        int count = 0;
        // traverse through the indegrees array and check for nodes which have no dependecies
        // add such nodes in queue and increment the count
        for(int i = 0; i < indegrees.length; i ++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        // traverse through the queue until it is not empty
        while(!q.isEmpty()){
            // pop element from queue
            int dependencies = q.poll();
            List<Integer> li = new ArrayList<>();
            // get dependencies of that element from adjacency list
            li = map.get(dependencies);
            // if dependencies are found,
            // then for each dependent node, reduce the value in indegrees array
            // check for its dependencies, if no dependencies are found,
            // then add it to the queue and increment the count
            if(li != null){
                for(int dependency : li){
                    indegrees[dependency]--;
                    if(indegrees[dependency] == 0){
                        q.add(dependency);
                        count++;
                    }
                }
            }
        }
        // if all the courses are taken, then return true else return false
        return count == numCourses;
    }
}