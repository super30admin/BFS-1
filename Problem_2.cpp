/*
 ? Problem: Course Schedule
 * Time Complexity : O(m + n)
 * Space Complexity : O(m + n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>
#include <queue>

class Solution {
public:
    bool canFinish(int numCourses, std::vector<std::vector<int>>& prerequisites) {
        std::vector<int> adj[numCourses];
        std::vector<int> indegree(numCourses, 0);

        for(const std::vector<int>& courses: prerequisites) {
            adj[courses[1]].push_back(courses[0]);
            indegree[courses[0]]++;
        }

        std::queue<int> q;

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.push(i);
        }

        int count = 0;
        while(!q.empty()) {
            int node = q.front(); q.pop();
            count++;

            for(auto it : adj[node]) {
                indegree[it]--;
                if(indegree[it] == 0) q.push(it);
            }
        }

        return count == numCourses;
    }
};