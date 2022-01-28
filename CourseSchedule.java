

import java.util.*;

//BFS
//T.C - V+E
//S.C - V+E
public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2},{4,1},{5,4},{5,2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependencies = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge: prerequisites){
            dependencies[edge[0]]++; // increasing the dependency on each course
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]); // Adding parent course and relevant children course
        }

        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< dependencies.length; i++){
            if(dependencies[i]==0) { //If the course is independent, add it to the queue
                q.add(i);
                count++;  //maintain count
            }
        }

        if(q.isEmpty())
            return false;

        while(!q.isEmpty() && count<numCourses) {
            int curr = q.poll();
            //reduce the dependency of children by 1 as the parent is being removed
            List<Integer> children = map.get(curr);
            if (children != null) {
                for (int child : children) {
                    dependencies[child]--;
                    if (dependencies[child] == 0) { //If the course is now independent, add it to the queue
                        q.add(child);
                        count++;
                    }
                }
            }
        }
        if(count == numCourses) return true;

        return false;
    }
}
