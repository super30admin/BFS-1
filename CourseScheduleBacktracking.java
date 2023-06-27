import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


public class CourseScheduleBacktracking {

        HashMap<Integer, List<Integer>> mapChildren;

        boolean[] visited; boolean[] path;

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            visited = new boolean[numCourses];

            path = new boolean[numCourses];

            mapChildren = new HashMap<>();

            // building adjacency Map
            for(int[] edge: prerequisites) {

                if(!mapChildren.containsKey(edge[1])) {

                    mapChildren.put(edge[1], new ArrayList<>());
                }
                mapChildren.get(edge[1]).add(edge[0]);
            }

            for(int i = 0; i < numCourses; i++) {

                if(!visited[i] && checkCycleDfs(i)) {

                    return false;
                }
            }

            return true;
        }

        private boolean checkCycleDfs(int course) {

            //base
            if(path[course]) return true;

            if(visited[course]) return false;

            //logic
            //action course to current path
            visited[course] = true;

            path[course] = true;

            // recurse on all neighbors
            if(mapChildren.get(course) != null) {

                for(int child: mapChildren.get(course)) {

                    if(checkCycleDfs(child)) return true;
                }
            }

            //backtrack
            path[course] = false;

            return false;
        }

}
