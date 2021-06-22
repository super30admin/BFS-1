
// Time - O(|E| + |V|) where V is number of courses and E is the number of dependencies
// Space - O(|E| + |V|) where V is number of courses and E is the number of dependencies

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // base condition

        if(prerequisites == null || prerequisites.length == 0) return true;

        // maintain Adjacency list
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // create indegree array
        int [] indegree = new int[numCourses];

        for(int [] prerequisite: prerequisites) {

            int in = prerequisite[0];
            int out = prerequisite[1];

            indegree[in]++;

            if(!map.containsKey(out)) {

                map.put(out, new ArrayList<>());

            }

            map.get(out).add(in);

        }

        // indegrees array and adjacency list
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < indegree.length; i++) {

            if(indegree[i] == 0) {
                q.add(i);
            }

        }

        if(q.size() == 0) return false;

        while(!q.isEmpty()) {

            int curr = q.poll();
            count++;

            List<Integer> edges = map.get(curr);
            if(edges != null) {
                for(int edge: edges) {

                    indegree[edge]--;
                    if(indegree[edge] == 0) {
                        q.add(edge);
                    }


                }


            }
        }

        if(count != numCourses) return false;

        return true;




    }
}