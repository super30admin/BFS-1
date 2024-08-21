//Time Complexity: O(v+e)
//Space Complexity: O(v+e)
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] overAllCourse = new int[numCourses]; //O(v) space complexity
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] course: prerequisites){ //O(e) Time //O(e) Space
            overAllCourse[course[0]]++;
            if(map.containsKey(course[1])){
                map.get(course[1]).add(course[0]);
            }
            else{
                List<Integer> li = new ArrayList<>();
                li.add(course[0]);
                map.put(course[1], li);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<overAllCourse.length;i++){ //O(v) Time //O(v) space
            if(overAllCourse[i]==0){
                q.add(i);
            }
        }

        while(q.size()>0){ //O(v+e)
            int firstElement = q.poll();
            if(map.containsKey(firstElement)){
                for(int i : map.get(firstElement)){
                    overAllCourse[i]--;
                    if(overAllCourse[i]==0){
                        q.add(i);
                    }
                }
            }

        }

        for(int i: overAllCourse){
            if(i>0){
                return false;
            }
        }
        return true;


    }
}
