//Average Time Complexity O(n)
//Space Complexity O(n^2)
//Leetcode tested

import java.util.*;
import java.util.LinkedList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] pre) {
        if(pre == null || pre.length == 0) return true;
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < pre.length; i++) {
            inDegree[pre[i][0]]++;
            if(!map.containsKey(pre[i][1])){
                List<Integer> current = new ArrayList<>();
                current.add(pre[i][0]);
                map.put(pre[i][1],current);
            }else map.get(pre[i][1]).add(pre[i][0]);
        }
        for (int i=0;i< inDegree.length;i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> list = map.get(cur);
            for (int i = 0;list!=null &&  i < list.size(); i++) {
                inDegree[list.get(i)]--;
                if(inDegree[list.get(i)] == 0) queue.add(list.get(i));
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]>0) return  false;
        }
        return true;
    }
}
