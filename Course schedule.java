//Time complexity: O(E+V^2)
//Space complexity: O(E+V)

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {

    HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

    for (int[] relation : prerequisites) {
 
      if (courseDict.containsKey(relation[1])) {
        courseDict.get(relation[1]).add(relation[0]);
      } else {
        List<Integer> nextCourses = new LinkedList<>();
        nextCourses.add(relation[0]);
        courseDict.put(relation[1], nextCourses);
      }
    }

    boolean[] path = new boolean[numCourses];

    for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
      if (this.isCyclic(currCourse, courseDict, path)) {
        return false;
      }
    }

    return true;
  }

  protected boolean isCyclic(
      Integer currCourse,
      HashMap<Integer, List<Integer>> courseDict,
      boolean[] path) {

    if (path[currCourse]) {
  
      return true;
    }

    if (!courseDict.containsKey(currCourse))
      return false;

    path[currCourse] = true;

    boolean ret = false;
    for (Integer nextCourse : courseDict.get(currCourse)) {
      ret = this.isCyclic(nextCourse, courseDict, path);
      if (ret)
        break;
    }
    path[currCourse] = false;
    return ret;
  }
}