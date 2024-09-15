//time complexity:(N)
//Space:O(N)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] incomingEdges = new int[numCourses];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int edge[] : prerequisites) {

            int child = edge[0];
            int parent = edge[1];
            incomingEdges[child]++;

            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<>());
            }
            map.get(parent).add(child);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < incomingEdges.length; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            if (map.containsKey(parent)) {
                for (int children : map.get(parent)) {
                    incomingEdges[children]--;

                    if (incomingEdges[children] == 0)
                        queue.add(children);
                }
            }
        }

        for (int x : incomingEdges) {
            if (x != 0)
                return false;
        }
        return true;
    }
}