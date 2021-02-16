// Time Complexity : O(E+V)
// Space Complexity : O(E+V)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            indegree.put(i,0);
            adjMap.put(i, new LinkedList<Integer>());
        }

        for(int[] prerequisite: prerequisites){
            indegree.put(prerequisite[1], indegree.get(prerequisite[1])+1);
            adjMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean isCyclic = true;

        while(!indegree.isEmpty()){
            isCyclic = true;
            for(int key : indegree.keySet()){
                if(indegree.get(key)==0){
                    for(int course : adjMap.get(key)){
                        indegree.put(course,indegree.get(course)-1);
                    }
                    indegree.remove(key);
                    isCyclic = false;
                    break;
                }
            }

            if(isCyclic)
                return false;
        }

        return true;
    }
}