/*
Create an in-degree array to track prerequisites count and an adjacency list for directed edges between courses.
Initialize a queue with courses having in-degree 0 and process courses, reducing in-degrees of neighbors.
If all courses are taken (courseTaken == numCourses), return true; otherwise, return false.
Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites. This is due to the topological sort using BFS.
Space Complexity: O(V + E), as the adjacency list and in-degree array both require additional space proportional to the number of courses and prerequisites.
*/
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, std::vector<std::vector<int>>& prerequisites) {
        vector<int> inDegree(numCourses);
        vector<vector<int>> adj(numCourses);
        for (auto prerequisite : prerequisites) {
            adj[prerequisite[1]].push_back(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        int courseTaken=0;
        while(!q.empty()){
            int course=q.front();
            q.pop();
            courseTaken++;
            for(auto& neighbor:adj[course]){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.push(neighbor);
                }
            }
        }
        return courseTaken==numCourses;
    }
};
