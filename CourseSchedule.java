class CourseScedhule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Checking to see if inputs are valid
        if (prerequisites == null || prerequisites.length == 0 ) return true;

        //Create an array to store degree of number of courses required
        int[] degrees = new int[numCourses];

        //Create new hashamp for adjacency list to store integer and its neighbours
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {

            //To take course in you need to finish course out
            int in = prerequisite[0];
            int out = prerequisite[1];

            //Fill degrees array
            degrees[in]++;

            //Fill in map for adjacency list
            if (!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }

            map.get(out).add(in);
        }

        Queue<Integer> q = new LinkedList<>();

        //Add of all the independent courses to the queue
        for (int i = 0; i< degrees.length; i++) {

            if (degrees[i] == 0) {
                q.add(i);
            }

        }

        //1, 0 and 0, 1 have no independent nodes to start with
        if (q.size() == 0) return false;
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            List<Integer> edges = map.get(curr);
            if (edges != null) {

                for (int edge: edges) {
                    degrees[edge]--;
                    if(degrees[edge] == 0) {
                        q.add(edge);
                    }
                }

            }

        }

        return count == numCourses;

    }

}