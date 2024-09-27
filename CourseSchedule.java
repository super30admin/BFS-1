
// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// This is topographical sort approach which was not intuitive	

// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<ArrayList<Integer>> preList = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) preList.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++) {
            preList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) if (indegree[i] == 0) queue.offer(i);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int num = queue.poll();
            for (int curr: preList.get(num)) {
                indegree[curr]--;
                if (indegree[curr] == 0) queue.offer(curr);
            }
        }
        return count == numCourses;
    }
}