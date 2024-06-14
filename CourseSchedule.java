//Time Complexity -  O(V+E)
//Space Complexity -  O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return false;
        }
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int[] prerequisite : prerequisites){
            int ind = prerequisite[1];
            int depen = prerequisite[0];
            indegree[depen]++;
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(depen);
        }
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            if(!map.containsKey(curr)){
                continue;
            }
            List<Integer> edges = map.get(curr);
            if(edges == null){
                continue;
            }
            for(int edge : edges){
                indegree[edge]--;
                if(indegree[edge] == 0){
                    q.add(edge);
                    count++;

            }
                
            }
            }
            return count == numCourses;

        }

}
