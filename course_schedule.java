// Time Complexity : O(V+E), where V is the number of vertices and E is the number of edges in the graph
// Space Complexity :O(V+E), where V is the number of vertices and E is the number of edges in the graph (space required for the 
                                //adjacency list)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Please correct me on the space complexity

//Three Liner approach in plain English
//1. Calculate the indegrees and Adjacency list for each course. Start the BFS with all the courses that have indegrees 0 
        //(they dont have prerequisites)
//2. remove first node from the queue and recalculate the indegrees for all the courses that are dependent on this course and while
        //decreasing the indegrees the course becomes 0, add it to the queue to be processed
//3. in the end if the queue is empty and all the courses in the ingrees array are 0 (all courses can be completed) 
        //return TRUE else FALSE

// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //edge case
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> aList = new HashMap<>();
        
        //calculate the indegrees and Adjacency List
        for(int i=0; i<prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++;
            if(!aList.containsKey(prerequisites[i][1])){
                aList.put(prerequisites[i][1], new ArrayList<>());
            }
            aList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        //Queue to perform BFS
        Queue<Integer> childs = new LinkedList<>();
        //put all the courses in the queue with the indegrees 0
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] == 0) childs.add(i);
        }
        //remove first course from the queue and decrease the indegrees of all the courses depenedent on that course
        //later check if the indegree has become 0, if yes add it to the queue
        while(!childs.isEmpty()){
            int curr = childs.poll();
            List<Integer> childrens = aList.get(curr);
            //some of the courses can have no childrens
            if(childrens != null){
                for(int course : childrens){
                    indegrees[course]--;
                    if(indegrees[course] == 0) childs.add(course);
                }
            }
        }
        
        //check if queue is empty, then indegrees is also 0s
        for(int i =0; i<indegrees.length; i++){
            if(indegrees[i] != 0) return false;
        }
        //if queue is empty and the indegrees has all 0s, return true
        return true;
    }
}