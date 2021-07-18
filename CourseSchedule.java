package BFS1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*S30 Big N Problem #57 {Medium} - https://www.youtube.com/watch?v=4daVf8a9JmY
    you have n courses which you can take. let these courses be named from 0 to n-1.

    these courses may have some prerequisited, for instance we can take course 0 only if we have taken course 1 which is expressed as a pair: [0,1]

    you are given total number of courses and the list of the prerequisites pairs, tell whether its possible for you to finish all courses or not? 

    you may assume that:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.
    Example 1:

    Input: 2, [[1,0]] 
    Output: true
    Explanation: There are a total of 2 courses to take. 
                 To take course 1 you should have finished course 0. So it is possible.
    Example 2:
    Input: 2, [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
                 To take course 1 you should have finished course 0, and to take course 0 you should
                 also have finished course 1. So it is impossible.

    Source Link: https://leetcode.com/problems/course-schedule/
        -------------------------------------------------------------------------------------------------------
        Time complexity : O(V+E) 
        space complexity: O(V+E) 
        Did this code run successfully in leetcode : yes
        problems faces : no*/

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegress = new int[numCourses];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int subject = prerequisites[i][0];
            int subjectDependentOn = prerequisites[i][1];

            if (!map.containsKey(subjectDependentOn)) {
                map.put(subjectDependentOn, new ArrayList<>());
            }
            map.get(subjectDependentOn).add(subject);

            indegress[subject]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegress.length; i++) {
            if (indegress[i] == 0) {
                q.add(i);
            }

        }

        if (q.isEmpty())
            return false; // there is a cycle as there are no subjects without dependency

        while (!q.isEmpty()) {
            int currSubj = q.poll();
            List<Integer> dependentSubjcts = map.get(currSubj);
            if (dependentSubjcts == null)
                continue;

            for (int s : dependentSubjcts) {
                indegress[s]--;
                if (indegress[s] == 0) {
                    q.add(s);
                }
            }

        }

        //check if all indegress have become zero
        for (int i = 0; i < indegress.length; i++) {
            if (indegress[i] != 0) {
                return false;
            }
        }

        return true;
    }
    
 //   ---------------------------DFS with backtrack------------------------
    HashMap<Integer, List<Integer>> map ;
    boolean[] visited;
    boolean[] path;

    
    public boolean canFinishWithDfs(int numCourses, int[][] prerequisites) {

        map = new HashMap<>();
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
       
        for (int i = 0; i < prerequisites.length; i++) {
            int subject = prerequisites[i][0];
            int subjectDependentOn = prerequisites[i][1];

            if (!map.containsKey(subjectDependentOn)) {
                map.put(subjectDependentOn, new ArrayList<>());
            }
            map.get(subjectDependentOn).add(subject);

          }
        
        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i] && dfsIsCycle(i))
            {
                return false;
            }
        }

        return true;
    }
    
    
    private boolean dfsIsCycle(int i)   //detec if there is a cycle
    {
        //base
        if(path[i]) return true;
        if(visited[i]) return false;
        
        //logic
        //action
        path[i] = true;
        visited[i] = true;
        //recurse all the neigh bours and find if we are reaching to original node to detect a cycle
        if(map.get(i) != null)
        {
            for(int n : map.get(i))
            {
                if(dfsIsCycle(n)) return true;
            }
        }
        //backtrack
        path[i] = false;
        
        
        return false;
    }

}
