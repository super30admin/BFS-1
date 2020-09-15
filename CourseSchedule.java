// Time Complexity : O(V+E)
// Space Complexity : O(V+E) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)return true;
        int []incomingEdges = new int[numCourses];
        Map<Integer,Set<Integer>>map = new HashMap<>();
        for(int []prereq:prerequisites){
            int course=prereq[1] , dependee = prereq[0];
            incomingEdges[dependee]++;
            if(!map.containsKey(course)){
                map.put(course, new HashSet<>());
            }
            map.get(course).add(dependee);
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int course=0;course<numCourses;course++){
            if(incomingEdges[course]==0){
                queue.add(course);
            }
        }
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                int course = queue.poll();
                incomingEdges[course] = -1;// marking them as visited
                numCourses--;
                if(!map.containsKey(course))continue;
                for(int dependee:map.get(course)){
                    if(incomingEdges[dependee]==-1)continue;
                    incomingEdges[dependee]--;
                    if(incomingEdges[dependee]==0)queue.add(dependee);
                }
            }
            
        }
        return numCourses==0;
    }
}