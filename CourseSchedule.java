import java.util.*;
import java.util.LinkedList;

public class CourseSchedule {
    //https://leetcode.com/problems/course-schedule/
    /* Step 1 - pair the elements in the combinations of given courses and their pre-requisites.
    2 - Iterate on each course of prerequisites and take a counter to check which all courses have.
    3 - We need a way to store the counter use an integer array.
    4 - We need to figure a way to know which elements are dependent on which elements. Since it is a lookup call we use hashmap
    5 - We also require a queue to list the elements which are eligible to be chosen. Take an independent element and poll the element. After polling check
    for its dependents and include them in the queue. Topological Sorting.
    * Time Complexity - O(V+E) v = vertices E = edges

    Space Complexity - O(V+E) O(V) to calculate the array  O(E) - to build the adjacency matrix

    * */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //base
        if(numCourses==0) return true;
        //logic
        int[] numOfIntegers = new int[numCourses];
        Queue<Integer> q = new LinkedList();
        int completedCourses =0;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int[] edge:prerequisites) {
            int in = edge[0];
            int out = edge[1];
            numOfIntegers[in]++;
            if(!map.containsKey(out)) map.put(out,new ArrayList<>());
            map.get(out).add(in);
        }
        for (int i = 0; i <numOfIntegers.length ; i++) {
            if(numOfIntegers[i]==0){
                completedCourses++;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges!=null){
                for (int edge:edges
                     ) {
                    numOfIntegers[edge]--;
                    if(numOfIntegers[edge]==0){
                        q.add(edge);
                        completedCourses++;
                    }
                }
            }
        }
//        for (int i = 0; i < numOfIntegers.length; i++) {
//            if(numOfIntegers[i]!=0) return false;
//        }
        return completedCourses==numCourses;
    }
}
