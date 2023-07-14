// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes


#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> degrees(numCourses, 0);
        unordered_map<int, vector<int>> graph;

        for (const vector<int>& prerequisite : prerequisites) {
            degrees[prerequisite[1]]++;
            graph[prerequisite[0]].push_back(prerequisite[1]);
        }

        queue<int> q;
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                q.push(i);
            }
        }

        while (!q.empty()) {
            int course = q.front();
            q.pop();

            for (int child : graph[course]) {
                degrees[child]--;
                if (degrees[child] == 0) {
                    q.push(child);
                }
            }
        }

        for (int degree : degrees) {
            if (degree != 0) {
                return false;
            }
        }

        return true;
    }
};