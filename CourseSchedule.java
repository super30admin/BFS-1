/** Course Schedule
* TC O(E+V) SC O(N)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indeg[prerequisites[i][0]]++;
            if (!prereq.containsKey(prerequisites[i][1])) {
                prereq.put(prerequisites[i][1], new ArrayList<>());
            }
            prereq.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> order = new LinkedList<Integer>();
        for (int i = 0; i < indeg.length; i++)
        {
            if (indeg[i] == 0){
                order.add(i);
            }
        }
        int popCount = 0;
        while(!order.isEmpty()) {
            Integer popped = order.poll();
            popCount ++;
            List<Integer> children = prereq.get(popped);
            if (children != null) {
                for (Integer child : children) {
                indeg[child]--;
                if (indeg[child] == 0) {
                    order.add(child);
                }
              }
            }
        }
       
        return (popCount == indeg.length);
    }
}
