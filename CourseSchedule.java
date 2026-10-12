//Time Complexity: O(V+E)
//Space Complexity: O(V+E)
public class CourseSchedule {
    Map<Integer, List<Integer>> pre = new HashMap<>();
    Set<Integer> visited= new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        for (int i = 0; i<numCourses; i++) {
            pre.put(i, new ArrayList<>());
        }

        for (int i = 0; i<prerequisites.length; i++) {
            pre.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i<numCourses; i++) {
            if(!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int a) {
        if(visited.contains(a)) return false;
        if(pre.get(a) != null && pre.get(a).isEmpty()) return true;

        visited.add(a);
        for(int b : pre.get(a)) {
            if(!dfs(b)) return false;
        }
        visited.remove(a);
        pre.put(a,Collections.emptyList());
        return true;
    }
}
