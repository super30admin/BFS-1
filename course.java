/*
Time Complextity: (V+E) here v is number of courses and e is dependencies.
Space Complexity:  (V+E) here v is number of courses and e is dependencies.

Worked On Leetcode : Yes


*/

import java.util.*;

public class course {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int index[] = new int[numCourses];
        // checking how many prerequesties course for this course.
        for (int pre[] : prerequisites) {

            index[pre[0]]++;
        }

        HashSet<Integer> set = new HashSet<>();
        // adding course which doesn't have prereq.
        for (int i = 0; i < index.length; i++) {

            if (index[i] == 0) {

                set.add(i);
            }

        }
        // base case
        if (set.size() == 0)
            return false;

        // iterating through the set
        while (!set.isEmpty()) {

            Iterator<Integer> it = set.iterator();

            int count = it.next();
            set.remove(count);

            // checking if prereq == 0 then add in the set.
            for (int[] prev : prerequisites) {

                if (count == prev[1]) {

                    index[prev[0]]--;

                    if (index[prev[0]] == 0) {
                        set.add(prev[0]);
                    }
                }
            }
        }

        // if all index has 0 then true else false;

        for (int n : index) {

            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}
