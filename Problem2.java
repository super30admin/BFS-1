//Course Schedule
//TC : O(V+E)
//SC : O(V+E)
public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //BFS
        if(numCourses==0 || prerequisites.length==0 ){
            return true;
        }
        int total=0;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        //indegrees array
        int[] indegree = new int[numCourses];
      
        
        //Adjacency map
        for(int[] edge : prerequisites){
              indegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        //add all the elements with indegree 0
        
        for(int i=0; i< indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        
        while(!queue.isEmpty()){
            total++;
            Integer course = queue.poll();
            List<Integer> dependentCourses = map.get(course);
            if(dependentCourses!=null){
            for(Integer d : dependentCourses){
                indegree[d]--;
                if(indegree[d]==0){
                    queue.add(d);
                }
            }
            }
        }
        return total==numCourses;
    }
}

