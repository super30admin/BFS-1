// Problem Name: Course schedule
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// 1. Here we use topo sort to compute the independent courses first, by pushing
// courses which have indegree of zero which means they are independent
// 2. By using BFS, we decrease the indegree of each neighbor node, if it comes
// to zero, we push to queue since they are now independent
// 3. In the end we check if count == numCourses, we return true

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool canFinish(int numCourses, vector<vector<int>> &pre) {
    vector<vector<int>> adj(numCourses);
    vector<int> indegrees(numCourses, 0);
    for (auto it : pre) {
      adj[it[1]].push_back(it[0]);
      indegrees[it[0]]++;
    }

    queue<int> q;
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        q.push(i);
      }
    }

    int count = 0;
    while (!q.empty()) {
      int front = q.front();
      q.pop();
      count++;
      for (auto nei : adj[front]) {
        indegrees[nei]--;
        if (indegrees[nei] == 0) {
          q.push(nei);
        }
      }
    }
    return count == numCourses;
  }
};
