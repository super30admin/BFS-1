import java.util.*;

public class Courses {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependFrq = new int[numCourses];
        HashMap<Integer, ArrayList> hs = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (hs.containsKey(prerequisites[i][1])) {
                hs.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(prerequisites[i][0]);
                hs.put(prerequisites[i][1], al);
            }
            dependFrq[prerequisites[i][0]]++;
        }

        ArrayList<Integer> independent = new ArrayList<>();
        System.out.println(Arrays.toString(dependFrq));

        for (int i = 0; i < dependFrq.length; i++) {
            if (dependFrq[i] == 0)
                independent.add(i);
        }

        for (int el : hs.keySet()) {
            System.out.println(el);
            System.out.println(Arrays.toString(hs.get(el).toArray()));
            ArrayList<Integer> c = hs.get(el);
            if (independent.contains(el)) {
                for (int child : c) {
                    dependFrq[child]--;
                    if (dependFrq[child] == 0) {
                        independent.add(child);
                    }
                }
            }
        }

        if (independent.size() == numCourses)
            return true;
        else
            return false;

    }
}
