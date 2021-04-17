//Kahn's algorithm - used indegrees array
//Data structure used Queue
//Time Complexity - O(E+V) where E is no of edges and V is no of Vertices
//Space Complexity - O(E+V) where E is no of edges and V is no of Vertices

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    int[] indegree = new int[numCourses];
    Map<Integer, List<Integer>> map = new HashMap<>();

    for(int[] prereq: prerequisites){

      List<Integer> courseList = map.getOrDefault(prereq[1], new ArrayList<>());
      courseList.add(prereq[0]);
      indegree[prereq[0]]++;
      map.put(prereq[1], courseList);
    }

    Queue<Integer> queue = new LinkedList<>();

    for(int i=0; i<numCourses; i++){
      if(indegree[i] == 0){
        queue.add(i);
      }
    }

    while(!queue.isEmpty()){
      int course = queue.poll();

      List<Integer> prereqsForCourse = map.get(course);

      if(prereqsForCourse != null){
        for(Integer prereq: prereqsForCourse){
          indegree[prereq]--;
          if(indegree[prereq] == 0){
            queue.add(prereq);
          }
        }
      }
    }

    for(int i=0; i<numCourses; i++){
      if(indegree[i] > 0){
        return false;
      }
    }
    return true;
  }
}