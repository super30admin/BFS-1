// Time Complexity - O(V+E) where V is the number of courses and the E is the number of prerequisites given in the input
// Space Complexity - O(V+E) where V is the number of courses and the E is the number of prerequisites given in the input
// This solution worked on LeetCode
// In this problem, We need to find if all the course prequisites will be completed or not. The given prerequisites 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         Queue<Integer> q = new LinkedList<>();
        // build the indegrees and hashmap
        // HashMap is build using the prerequisites adjacency matrix which will have the course as key on which other courses are dependent upon and the value as the list of courses dependent on the key course. For eg. (0,4) from prerequisite will be 0 as key course and value 4 will the course dependent on 0
        int[] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0],new ArrayList<>());  //Empty list of key is newly created
            map.get(prerequisites[i][0]).add(prerequisites[i][1]); //Add the values in the empty list created then
        }
        // Check the course with 0 indegree which means that course do not have any prerequisites
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0)
                q.add(i);
        }
        // Use the hashmap and indegrees to contruct the BFS
        //The queue will poll the keys and reduce the indegree values in the indegrees array as the prerequisites are met
        //once the indegree becomes 0 , add it to the queue so it's children dependent on it can be processed subsequently
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children != null){a
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child]==0){
                        q.add(child);
                    }
                }   
            }
            
        }
        // Check if the indegrees has any greater than 0 and return false. If it is greater than 0 it means some prerequisite for a course is not completed
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] != 0)
                return false;
        }
        return true;
        
    }
}
