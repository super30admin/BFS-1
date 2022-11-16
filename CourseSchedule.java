
// TC : O(n + p) // n = numCourses // p = prerequisites
// SC : O(n + p)

package S30_Codes.BFS_1;
import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> prsToWantedCourse = new HashMap();

        for(int[] prs : prerequisites){
            inDegree[prs[0]]++;

            if(!prsToWantedCourse.containsKey(prs[1]))
                prsToWantedCourse.put(prs[1], new ArrayList());

            prsToWantedCourse.get(prs[1]).add(prs[0]);
        }

        Queue<Integer> q = new LinkedList();
        for(int c=0; c<inDegree.length; c++){
            if(inDegree[c] == 0)
                q.add(c);
        }

        int completeCount = 0;

        while(!q.isEmpty()){
            int curCourse = q.poll();
            completeCount++;

            List<Integer> lst = prsToWantedCourse.getOrDefault(curCourse, null);
            if(lst != null){
                for(int c : lst){
                    if(--inDegree[c] == 0)
                        q.add(c);
                }
            }
        }

        if(completeCount == numCourses)
            return true;

        return false;
    }
}