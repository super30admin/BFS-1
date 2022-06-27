package com.leetcode;

import java.util.ArrayList;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<Integer>[] adj = new ArrayList[numCourses];
            for(int i=0; i<numCourses; i++)
                adj[i] = new ArrayList<>();
            for(int[] pre : prerequisites)
                adj[pre[0]].add(pre[1]);

            boolean[] visited = new boolean[numCourses];

            for(int i=0; i<numCourses; i++) {
                if( !dfs(i, visited, adj))
                    return false;
            }

            return true;
        }

        public boolean dfs(int node, boolean[] visited, ArrayList<Integer>[] adj) {
            if (adj[node].size() == 0)
                return true;
            if(visited[node] == true)
                return false;

            visited[node] = true;

            for(int n : adj[node]) {
                if(!dfs(n, visited, adj))
                    return false;
            }

            adj[node].clear();

            return true;
        }
    }
}
