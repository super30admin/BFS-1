import java.util.*;

public class CourseSchedule_207 {

    public boolean canFinish(int numberOfCourses, int[][] prerequistites) {
        int[] inDegree = new int[numberOfCourses]; // to save indegree
        Map<Integer, List<Integer>> hashMap = new HashMap<>(); // To save outdegree

        //Calculating the indegree.
        for (int[] x : prerequistites) {
            int from = x[0]; // Main Course
            int to = x[1]; // Must complete course
            inDegree[to]++; // Increasing the count of must complete course.
            if (!hashMap.containsKey(from)) {
                hashMap.put(from, new ArrayList<Integer>());
            }
            hashMap.get(from).add(to);
        }

        Queue<Integer> queue = new LinkedList();

        //If the indegree is 0 which is the starting vertex - As per Topological sort. 
        // Topological sort - Starts with no indegree  and ends with no outdegree and in between remining elements.
        for (int x = 0; x < numberOfCourses; x++) {
            if (inDegree[x] == 0) {
                queue.add(x);
            }
        }

        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (hashMap.containsKey(front)) {
                for (int x : hashMap.get(front)) { // Travers all the out degree
                    inDegree[x]--; // If i travers out degree , then the in degree will do down by 1.
                    if (inDegree[x] == 0) {
                        queue.add(x);
                    }
                }
            }
        }

        for(int x: inDegree) {
            if(x!=0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        CourseSchedule_207 courseSchedule_207 = new CourseSchedule_207();
        //boolean canFinish = courseSchedule_207.canFinish(2, new int[][]{{1,0}});
        // boolean canFinish = courseSchedule_207.canFinish(2, new int[][]{{1,0}, {0,1}});
        boolean canFinish = courseSchedule_207.canFinish(6, new int[][]{{2,0}, {4,0}, {1,2}, {1,4}, {3,2}, {5,3}});
        System.out.println("The course can be finished:"+ canFinish);
    }
}
