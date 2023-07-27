//Time Complexity: O(V+E)
//Space Complexity: O(V+E)
//Ran in Leetcoode: yes

//Manintain a hashmap with node and dependent nodes, indegree arry and queue each time the an element is polled the count of indree is decreased, 
//in the all the indrees should be 0

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] pr:prerequisites){
            indegrees[pr[0]]++;
            if(!map.containsKey(pr[1])){
                  map.put(pr[1],new ArrayList<>());
            }
          map.get(pr[1]).add(pr[0]);
        }
        System.out.println(Arrays.toString(indegrees));
        for(int i=0;i<numCourses;i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int current = queue.poll();
            List<Integer> currMap = map.get(current);
            if(currMap != null){
            for(int i=0;i<currMap.size();i++){
                indegrees[currMap.get(i)]--;
                if(indegrees[currMap.get(i)] == 0){
                    queue.add(currMap.get(i));
                }
            }
            }
        }
         for(int i=0;i<numCourses;i++){
            if(indegrees[i] != 0){
                return false;
            }
        }
        return true;
    }
}