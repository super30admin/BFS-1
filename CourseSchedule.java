//Solved successfully on leetcode and faced no issues
//TC : O(V+E) SC : O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //hashmap to store keys as independent node and values as dependent nodes for the key.Search takes O(1) in HashMap
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int prereq = edge[1];
            int course = edge[0];
            indegree[course]++;
            if(!map.containsKey(prereq)){
                map.put(prereq , new ArrayList<>());
            }
            map.get(prereq).add(course);
        }
        int count = 0 ;//count : total number of nodes completely processed
        Queue<Integer>queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.remove();
            List<Integer>children = map.get(curr);
            if(children!=null){
            for(int child : children){
                indegree[child]--;
                if(indegree[child] == 0){
                    queue.add(child);
                    count++;
                    if(count == numCourses){
                        return true;
                    }
                }
            }
        }
        }
        if(count == numCourses){
            return true;
        }
        else{
            return false;
        }

        
    }
}