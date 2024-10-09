// TC: O(V+E)
// SC: O(V+E) V: numCourses, E: length of prerequisites


class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //To store the number of dependent courses for each course
        int[] indegrees = new int[numCourses]; // O(V) space 
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); //O(E) space. In the worst case, each course can have dependencies on every other course, so this takes O(E) space
        int count = 0;
        
        //Iterate the prerequisites to build the indegrees array and map - O(E)
        for(int[] prerequisite : prerequisites) { // O(E)
            int inde = prerequisite[1];
            int dep = prerequisite[0];

            // add the number of dependent courses for each course
            indegrees[dep]++;
            // store independent vs dependent courses so that we can decrement dependent courses count once independent is taken
            if(!map.containsKey(inde)) {
                map.put(inde,new ArrayList<>());
            }
            map.get(inde).add(dep);
        }

        // O(V) space. It can contain V courses inside it at max
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegrees.length;i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }

        //Process each course(verter) and traversing all its dependent courses(edges) O(V+E)
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            if(map.containsKey(course)) {
                for(int dependent : map.get(course)) {
                    indegrees[dependent]--;
                    if(indegrees[dependent] == 0) 
                        queue.add(dependent);
                }
            }
        }

        return count == numCourses;
    }
}