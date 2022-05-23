// O(|E| + |V|^2) time, where |E| is number of dependencies, |V| is number of courses and d is max length of acyclic paths
// O(|E| + |V|) space, built graph data structure which consumes |E| + |V| space, path to keep track of visited nodes is |V| and recursion takes up |V|

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>(); // course --> list of next courses
        
        // build graph first 
        for (int[] relation : prerequisites){
            // relation[0] depends on relation[1]
            if (courseDict.containsKey(relation[1])){
                courseDict.get(relation[1]).add(relation[0]);
            }
            else{
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }
        
        boolean[] path = new boolean[numCourses];
        
        for (int currCourse = 0; currCourse < numCourses; ++currCourse){
            if (this.isCyclic(currCourse, courseDict, path)) return false;
        }
        
        return true;
    }
    
    private boolean isCyclic(Integer currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] path){
        if (path[currCourse]) return true; // previously visited node --> detected cycle
        
        if (!courseDict.containsKey(currCourse)) return false; // no following courses, no loop
        
        // before backtracking, mark current node as visited
        path[currCourse] = true;
        
        // backtracking
        boolean ret = false;
        for (Integer next : courseDict.get(currCourse)){
            ret = this.isCyclic(next, courseDict, path);
            if (ret) break;
        }
        
        path[currCourse] = false;
        return ret;
    }
}