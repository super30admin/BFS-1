package s30.BFS;

import java.util.*;


// TIme Complexity O(m) m being the number of rows of prerequisites
// Space complexity O(n) n being the number of courses.
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> dep = new HashMap();

        int[] courseCount = new int[numCourses];

        for(int[] c : prerequisites){
            courseCount[c[0]] =  ++courseCount[c[0]];

            if(!dep.containsKey(c[1])){
                dep.put(c[1], new ArrayList());
            }
            dep.get(c[1]).add(c[0]);
        }

        Queue<Integer> courses = new LinkedList();

        for(int i =0 ; i < courseCount.length ; i++){
            if(courseCount[i] ==0) courses.add(i);
        }


        int countCourse =0;
        while(!courses.isEmpty()){

            List<Integer> depC = dep.get(courses.poll());
             if(depC != null) {
                 for (int c : depC) {
                     courseCount[c] = --courseCount[c];
                     if (courseCount[c] == 0) courses.add(c);
                 }
             }

            countCourse++;
        }

        if(numCourses == countCourse) return true;
        return false;

    }
    public static void main(String[] args) {
        int[][] test = {
                {1,0}
        };
        canFinish(2,test);
    }
}
