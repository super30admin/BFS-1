// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : yes 
// Three line explanation of solution in plain english: find topological sort of graph. If we are able to finish all courses
// return true else return false (there's a cycle)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        if(numCourses<=1 || prerequisites.length==0){
            return true;
        }
        int indegree[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int ind = prerequisites[i][1];
            int de = prerequisites[i][0];
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<Integer>());
            }
            map.get(ind).add(de);
            indegree[de]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            List<Integer> children = map.get(curr);
            if(children==null){
                continue;
            }
            for(int child:children){
                //System.out.println("reducing indegree of "+child);
                indegree[child]--;
                if(indegree[child]==0){
                    //System.out.println("Adding "+child+" to queue");
                    q.add(child);
                    count++;
                }
            }
        }
        if(count==numCourses){
            return true;
        }
        return false;
    }
}