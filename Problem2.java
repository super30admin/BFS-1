

//TimeComplexity  : O(n)
//Space Complexity : O(n)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

import java.util.*;

public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer , List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int[] prereq : prerequisites){
            indegree[prereq[0]]++;
            if(!map.containsKey(prereq[1])){
                map.put(prereq[1],new ArrayList<>());
            }
            map.get(prereq[1]).add(prereq[0]);
        }
        for(int i =0;i<indegree.length;i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }

        while(! q.isEmpty()){
            int course = q.poll();
            List<Integer> dependent = map.get(course);
            if(dependent != null ){
                for(int i=0;i<dependent.size();i++){
                    int ele = dependent.get(i);
                    indegree[ele]--;
                    if(indegree[ele] ==0){
                        q.add(ele);
                    }
                }
            }

        }
        for(int i=0;i <indegree.length;i++){
            if(indegree[i] != 0){
                return false;
            }
        }

        return true;
    }
}
