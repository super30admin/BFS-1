import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class CourseSchedule {
    int [][] prereqs = {{1,0},{0,1}};
    int numCourses = 2;
    int [] indegrees = new int[numCourses];
    Queue<Integer> q = new LinkedList<Integer>();
    HashMap<Integer, ArrayList<Integer>> mmap = new HashMap<>();
    public void scheduler() {
        for (int[] prereq : prereqs) {
            int independent = prereq[1];
            int dependent = prereq[0];

            if (!mmap.containsKey(independent)) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                mmap.put(independent, arr);
            }
            mmap.get(independent).add(dependent);
            indegrees[dependent]++;
        }

        
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);                
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int course = q.poll();
                ArrayList<Integer> arr = mmap.get(course);
                
                if (arr != null) {
                    for (int k = 0; k < arr.size(); k++) {
                        int dependent = arr.get(k);
                        
                        indegrees[dependent]--;
                        if (indegrees[dependent] == 0) {
                            q.add(dependent);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.println(indegrees[i]);
        }
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        cs.scheduler();
    }
    
}
