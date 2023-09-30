// Time Complexity : O(V+E)// V - vertices, E- edges
// Space Complexity : O(v+E)
// Did this code successfully run on Leetcode : Yes  https://leetcode.com/problems/course-schedule/submissions/1062724260/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Create an array with count of incoming edges
 * Maintain a hashmap of keys as courses and value as array list of courses which are impacted by the given key
 * Now, maintain a queue adding the values whose incoming edges count is 0 and check the array list of courses
 *  and decrase their count by 1 everytime found
 * If all the values of the queue is 0, then all courses can be finished, else return false
 */

import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0)
            return true;
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        for(int[] prereq : prerequisites){
            int to = prereq[0];
            int from = prereq[1];
            indegrees[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for(int i=0;i<indegrees.length;i++){
            System.out.println(indegrees[i]);
        }
        for(int i=0;i<map.size();i++){
            System.out.println(map.get(i));
        }
        for(int i=0;i<numCourses ;i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())
            return false;
        while(!q.isEmpty()){
            int curr = q.remove();
            List<Integer> temp = map.get(curr);
            if(temp == null)
                continue;
            for(int i=0; i< temp.size();i++){
                indegrees[temp.get(i)]--;
                if(indegrees[temp.get(i)]==0){
                    q.add(temp.get(i));
                    count++;
                }
            }
        }
        
        if(count == numCourses)
            return true;
        return false;
    }
}