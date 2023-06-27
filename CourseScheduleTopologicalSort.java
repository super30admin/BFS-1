import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseScheduleTopologicalSort {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // adjacency - children
            HashMap<Integer, List<Integer>> mapChildren = new HashMap<>();  // O(V+E)

            // in degree - number of incoming edges
            int[] inDegree = new int[numCourses];

            // making adjacency map and in degree array
            for(int[] edge: prerequisites) { // O(E) = prerequisites[][]

                int out = edge[1];
                int in = edge[0];

                // counting incoming edges of a course
                inDegree[in] ++;

                if(!mapChildren.containsKey(out)) {

                    mapChildren.put(out, new ArrayList<>());
                }
                mapChildren.get(out).add(in);

            }

            // Queue of courses in BFS
            Queue<Integer> courseQ = new LinkedList<>();

            int count = 0;

            for(int i = 0; i < numCourses; i++) { // O(v) = numCourses

                if(inDegree[i] == 0) {

                    courseQ.add(i);
                    count++;
                }

            }

            // if no course with no incoming edges = empty queue
            if(courseQ.isEmpty())  return false;

            // when queue has courses to be processed
            while(!courseQ.isEmpty()) { // O(V+E)

                // poll out a course in queue
                int currCourse = courseQ.poll(); //O(v) max polls = all courses

                // get children of polled out course
                List<Integer> children = mapChildren.get(currCourse); //O(E) max edges = all chidlren

                if(children != null) {

                    //iterate over children list (inner list)
                    for(int child: children) { //BFS step

                        // as current course is polled out
                        inDegree[child]--;

                        // whenever inDegree of a child becomes zero, add to queue
                        if(inDegree[child] == 0) {

                            courseQ.add(child);

                            //increase count of successful courses going in Queue
                            count++;

                            //if count reaches all courses
                            if(count == numCourses) return true;

                        }
                    }
                }

            }
            //mapchildren key with no children, but count matches the number of courses
            if(count == numCourses)  return true;

            // if it does not become true above
            return false;
        }

}

// BFS - Topological Sort - Queue, HashMap, Array

/* Time Complexity = O(V+E)
Space Complexity = O(V+E)
*/