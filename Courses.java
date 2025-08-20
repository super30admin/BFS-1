//approach- Performing a BFS on the graph with having an adjancy map and indegrees array, while getting independent nodes first from the indegrees array and processing those vertices and updating the dependent vertices we can get from the map, and adding the newly independent Vertices to the queue and proceeding. returning true if all Vertices are independent by the end(no Cycle) else returning false as it is not posssible given the cycle.
//time complexity-O(V+E), V for iterating the Vertices in indgrees array.E for iterating over prerequisities
//space complexity-O(V+E), v-> for indegrees,E->map(adjancy map)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashMap<Integer, List<Integer>> map = new HashMap<>();//mapping independent vertices with the vertices dependent on it
        Queue<Integer> q = new LinkedList();//processing independent vertices
        int[] inDegrees = new int[numCourses];
        //filling indegrees and our map
        for (int[] pr : prerequisites) {
            if (map.containsKey(pr[1])) {
                map.get(pr[1]).add(pr[0]);
            } else {
                map.put(pr[1], new ArrayList<>());
                map.get(pr[1]).add(pr[0]);
            }
            inDegrees[pr[0]]++;
        }
        int count = n;
        //getting independent vertices
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
                count--;
            }
        }
        //updating the indegrees as we process independent vertices and updating the queue with new independent vertices
        while (!q.isEmpty()) {
            var ind = q.poll();
            if (map.containsKey(ind)) {
                var list = map.get(ind);
                for (int i = 0; i < list.size(); i++) {
                    inDegrees[list.get(i)]--;
                    if (inDegrees[list.get(i)] == 0) {
                        count--;
                        q.offer(list.get(i));
                    }
                }

            }

        }

        return count == 0;
    }
}
