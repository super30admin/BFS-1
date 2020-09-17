// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Use topological sorting to find any deadlock after sorting them in an array on basis of dependencies.
// create an array courseDependencies to record the incoming edges or number of nodes on which they are depending.
// and a map for storing the node and its dependants.
// iterate over map and if the you find the dependants of a key in courseDependencies array, reduce it by 1 and if it is 0 add to queue.
// this means, that node doesn't have any other depending nodes and can be added to out sorting output.
// after all this process is done and now if the courseDependencies array has any element > 0, then return false.
// This indicates that it is a deadlock and can't be sorted in topological array.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] courseDependencies = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<prerequisites.length;i++){
            courseDependencies[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<courseDependencies.length;i++){
            if(courseDependencies[i]==0){
                q.add(i);
            }
        }

        if(q.isEmpty()){
            return false;
        }

        while(!q.isEmpty()){
            int pop = q.poll();
            if(map.containsKey(pop)){
                for(int i : map.get(pop)){
                    courseDependencies[i]--;
                    if(courseDependencies[i]==0){
                        q.add(i);
                    }
                }
            }
        }

        for(int i:courseDependencies){
            if(i!=0)
                return false;
        }
        return true;
    }
}