//Time Complexity: O(V+E)
//TimeComplexity : O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int []indegrees = new int[numCourses];
        for(int []subArray : prerequisites){
            int dependent = subArray[0];
            int independent = subArray[1];
            indegrees[dependent]++;
            if(!map.containsKey(independent)) {
                map.put(independent, new ArrayList<>());
            }
            map.get(independent).add(dependent);
        }
       int countfinish=0;
        for(int i =0; i<numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
                countfinish++;
            }
        }
        if(queue.isEmpty()) {
            return false;
        }
        while(!queue.isEmpty()) {
            int current = queue.poll();
            List<Integer> res = map.get(current);
            if(res == null) {
                continue;
            }
            for(int r : res) {
                indegrees[r]--;
                if(indegrees[r] == 0) {
                    queue.add(r);
                    countfinish++;
                    if(countfinish == numCourses) {
                        return true;
                    }
                }
                
            }
        }
      if(countfinish == numCourses) {
                    return true;
                }
                return false;
    }
}