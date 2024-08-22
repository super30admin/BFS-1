// Approach
// So, first you create a dependency list ->
// A hash map (dependency list ) -> {dependent: independent}.
// for eg {0:[1,2]}-> the edge will go from 0->1 and from 0->2.
// Then you create an array-> indegrees array which has all the number of edges that are going in that vertex. for eg. vertex 1 has incoming from 0 and 3. so indegrees[1]=2.
// Then all you need to do is push the vertex is the queue, which is independent.So essentially indegrees==0
// And once you do that, you need to reduce the indegrees for other indexes(you will get those indexes from the map(key:value) pair). Reduce by 1.
// no of semesters is like a level. every level you complete, no. of semesters ++.

// Time complexity = O(V+E) = O(max(V,E)) = O(E) <- connected graph, O(V) <- all independent graph with just 1 vertex having dependency on every other vertex.

// Space complexity = O(V*E)


class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        int count = 0;
        
        for(int[] prerequisite: prerequisites) {
            int de = prerequisite[0];
            int ind = prerequisite[1];
            indegrees[de]++;
            if(!map.containsKey(ind)) {
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(de);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i< numCourses;i++) {
            if(indegrees[i]==0) {
                q.add(i);
                count++;
            }
        }
        if(count== numCourses) {
            return true;
        }
        if(count==0) {
            return false;
        }
        int semesters=1;
        while(!q.isEmpty()) {
            
            int size = q.size();
            for(int i=0;i< size;i++) {
                int curr = q.poll();
                ArrayList<Integer> list = map.get(curr);
                if(list==null) {
                    continue;
                }
                for(int e: list) {
                    indegrees[e]--;
                    if(indegrees[e]==0) {
                        q.add(e);
                        count++;
                        if(count== numCourses) {
                            return true;
                        }
                    }
                }
            }
            semesters++;

        }
        
        System.out.print("No. of semesters taken " + semesters);

        return false;
    }
}