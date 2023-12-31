//Time complexity:O(V+E)
//Space Complexity:O(V+E), V-indegree , E-edges
//create indegree list for each node)to find dependency, map to store indep - dependent list, find free nodes, process using BFS, if node becomes free, add to queue in BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null)
            return false;
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] course : prerequisites) {
            int dependent = course[0];
            int independent = course[1];

            indegree[dependent]++; 

            if (!map.containsKey(independent)) {
                map.put(independent, new ArrayList<>());
            }
            map.get(independent).add(dependent);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        //add indep nodes,whose indegree==0
        for (int i = 0; i < indegree.length; i++) 
        {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(count==0) return false;

        while (!q.isEmpty()) 
        {
            List<Integer> list = map.get(q.poll());

            if (list != null) {
                for (int n : list) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        count++;
                        q.add(n);
                    }
                }
            }
        }

        return count == numCourses;

    }
}