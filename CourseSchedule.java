//Problem : 57 - Course Schedule I
// Time Complexity : O(V+E), V stands for Vertices, E stands for edges
// Space Complexity : O(V) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Note: For graph questions, always start from independent node.

// Your code here along with comments explaining your approach
//Eg: 7, [[2,0],[4,0],[1,2],[1,4],[3,2],[5,3],[5,1],[6,2]]
/* 1) First calculate the indegrees, for maintaining the count of dependency for each node : TC:O(V) | SC:O(V), V-> number of vertices/courses 
   2) Initialise HashMap for putting the node which are not dependent on that edge, eg. putting 0 as key because for the course 1 taking 0 is mandatory, so here we are maintaining prereq course as key and all dependent courses as list. Because once we have taken the prereq course then we will be decrementing the inDegrees for the courses in that prereq list. TC:O(V) | SC:O(V+E), E stands for edges
   3) Iterate over inDegrees array and if any course indegree is 0, then just add it to the queue, which means it is independent and student can take that course.
   4) Iterate over the queue until q is empty and poll the elements from the queue. While polling just decrement indegree count of all the edges/courses in prereq list. If indegree of any of the course in the list becomes zero, then just add that course in the queue, so that it can also be pre processed. 
   TC: O(V+E), because for each vertex edges will be processed.
   Note : 1) Just take one more variable called course, and increment it according to the size of the queue. In last if count of course and numCourses become equal that means, all the courses could be taken and no course was left.[Here it means all inDegree elements have become 0]
          2) If you want to find, how many semesters it took to complete all the courses, just use a level variable, and increment it whenever a level is completely processed.


*/
import java.util.*;

class Solution57 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //TC: O(n)+O(Pre)+O(inDegree)+O(V+E)=> O(V+E)
        //SC: O(V+E)
        
        if(prerequisites==null) return true;
        
        int[] inDegrees = new int[numCourses];//for maintaining the count of dependency for each node//SC:O(V)
        
        Map<Integer,List<Integer>> map = new HashMap<>();//SC:O(V+E)
        
        for(int[] edge:prerequisites){
            inDegrees[edge[0]]++;//increase the dependency count, eg: 1 is dependent on how many courses
            
            if(!map.containsKey(edge[1])){
               map.put(edge[1],new ArrayList<>());//putting the node which are not dependent on that edge, eg. putting 0 as key because for the course 1 taking 0 is mandatory, so here we are maintaining prereq course as key and all dependent courses as list. Because once we have taken the prereq course then we will be decrementing the inDegrees for the courses in that prereq list.
            }
            
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();//Worst Case SC: O(V)
        
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]==0) q.offer(i);
        }
        
//         System.out.println("Arrays "+Arrays.toString(inDegrees));
//         System.out.println("Queue "+q);
//         System.out.println("Map "+map);
        
        int courses = 0;
        int level = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            courses += size;
            
            for(int i=0;i<size;i++){
                
                int currCourse = q.poll();//means we have taken this course
                List<Integer> edges = map.get(currCourse);
                //System.out.println("Edges "+edges);
                if(edges==null) continue;//if list of edges not available
                for(int edge : edges){
                    inDegrees[edge]--;
                    
                    if(inDegrees[edge]==0) q.offer(edge);
                }
                
            }
            level++;
        }
        //System.out.println("Arrays "+Arrays.toString(inDegrees));
        /*int max = 0;
        for(int inDegree:inDegrees){
            max = Math.max(max,inDegree);
        }*/
        System.out.println("Course Completed in "+level+" Semesters");
        return courses==numCourses ;
    }
}

/* Recursive
class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean [] visited;
    boolean [] path; //this path is curr path that we are making starting from a node
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean [numCourses];
        path = new boolean [numCourses];
        map = new HashMap<>();
        for(int [] edge : prerequisites){
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i)) {
                return false;
            }
        }
        return true;
    }
    //dfs is done for detecting cycle;
    private boolean dfs(int i){
        // base
        if(path[i]) return true; 
        if(visited[i]) return false;
        //logic
        visited[i] = true;
        //action add to current path
        path[i] = true;
        //recurse on all neigbours
        if(map.get(i) != null){
            for (int n : map.get(i)) {
                if (dfs(n)) return true;
            } 
        }
        //backtrack
        path[i] = false;
        return false;
    }
}


*/