//time complexity: V+E , v = vertex (number of course) E  = edges(number of dependency present in the tree)(length of prerequisites)
//space complexity: V + E
//didn't face any problems
//runs successfully

import java.util.*;

public class CourseSchedule207LeetCode {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> map = new HashMap<>();              //creating map for courses and its dependent courses

            int[] courses = new int[numCourses];                        // creating the frequency array that stores each course is dependent on how many courses

            Queue<Integer> zeroPreReqCourse = new LinkedList<>();       //maintaing the queue by storing all the course which has zero prerequisites

            int completedCourse = 0;                                    //maintaing the counter for completed courses

            for (int i = 0; i < prerequisites.length; i++) {                  //iterating through array

                int dependentCourse = prerequisites[i][0];              //get dependent and independent courses
                int independentCourse = prerequisites[i][1];

                if (!map.containsKey(independentCourse)) {                //check if independent course is in map or not

                    map.put(independentCourse, new ArrayList<>());      //if not then store it as a key and value is all the dependent course
                }
                map.get(independentCourse).add(dependentCourse);        //if present then add dependent course into the list

                courses[dependentCourse]++;                             //increamenting the frequency of dependent course
            }

            for (int i = 0; i < courses.length; i++) {                    //iterating through frequency array and course which has zero prerequisites add to the queue

                if (courses[i] == 0) {
                    zeroPreReqCourse.add(i);
                }
            }

//         for(int i=0; i<courses.length; i++){
//             System.out.println(courses[i]);
//         }
//         System.out.println(map);
//         System.out.println(zeroPreReqCourse);


            while (!zeroPreReqCourse.isEmpty()) {                 //itearating till queue is not empty

                int courseComplete = zeroPreReqCourse.remove();         //getting each element from queue
                //System.out.println(courseComplete);

                completedCourse++;                                  //increament the completed course counter

                List<Integer> dependent = map.get(courseComplete);  //getting the list of courses which is dependent upon course which we just completed

                if (dependent != null) {                      //check if dependent courses are not zero

                    for (int i : dependent) {                  //if not then iterating all the dependent course

                        courses[i]--;                   //decrease the frequency of that dependent course

                        if (courses[i] == 0) {            //if frequency becomes zero which means we can take this course now, so add that course to our queue

                            zeroPreReqCourse.add(i);

                        }
                    }
                }
            }

            return completedCourse == numCourses;     //after completing the loop check if completed course is equal to the numcourses that are given, if so then return true otherwise return false

        }
}
