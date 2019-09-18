/*
Author: Akhilesh Borgaonkar
Leetcode: https://leetcode.com/problems/course-schedule/
*/

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    static class Course {
        boolean visited = false;
        boolean tested = false;
        List<Course> prerequisites = new ArrayList<>();
        public void add(Course prereq){
            prerequisites.add(prereq);
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for(int i = 0 ; i < numCourses ; i++)
            courses[i] = new Course();

        for(int i = 0 ; i < prerequisites.length ; i++)
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);

        for(int i = 0; i<numCourses; i++){
            if(isCyclic(courses[i]))
                return false;
        }
        return true;
    }

    public static boolean isCyclic(Course course){
        if(course.tested == true) return false;
        if(course.visited == true) return true;

        course.visited = true;

        for(Course c : course.prerequisites) {
            if (isCyclic(c))
                return true;
        }
        course.tested = true;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};

        if(canFinish(numCourses, prerequisites))
            System.out.println("possible");
        else
            System.out.println("impossible");

    }

}
