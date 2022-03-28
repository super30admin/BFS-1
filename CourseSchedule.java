public class CourseSchedule {
  /**
   * Time Complexity: O(V + E)
   * Space Complexity: O(V + E)
   * 
   * Were you able to solve this on leetcode ? Yes
   * Any issues solving this? No
   * 
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int size = 0;
    
    // create the Adjacency List
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    // Maintain dependency count
    int[] courseDep = new int[numCourses];
    
    for(int[] pre : prerequisites){
        courseDep[pre[0]]++;
        
        if(map.get(pre[1]) == null) {
            map.put(pre[1], new ArrayList<>());
        }
        
        map.get(pre[1]).add(pre[0]);
    }
    
    // identify the independent courses and add them to Queue
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < numCourses; i++){
        if(courseDep[i] == 0){
            queue.add(i);
        }
    }
    
    if(queue.isEmpty()) { return numCourses == 0; }
    
    while(!queue.isEmpty()) {
        int curCourse = queue.remove();
        
        // reduce its children's dependency and if dependency == 0, add it to the queue
        List<Integer> childCourses = map.get(curCourse);
        
        if(childCourses != null){
            for(int i = 0; i < childCourses.size(); i++){
                int childCourse = childCourses.get(i);
                courseDep[childCourse]--;
                if(courseDep[childCourse] == 0){
                    queue.add(childCourse);
                }
            }
        }
        
        
        size++;
        
    }
    
    return size == numCourses;
  }
}
