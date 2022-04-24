// Time Complexity                              :  O(N) where N is the number of courses
// Space Complexity                             :  O(H) where H is the height of the tree. 
//                                                 These values are stored in a queue. Max H can be N when the tree that forms is skewed
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


// https://leetcode.com/problems/course-schedule/submissions/

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        unordered_map<int, vector<int>> mp;
        vector<int> indegree(numCourses, 0);
    
        // O(N)
        for(auto pre : prerequisites) {
            mp[pre[1]].push_back(pre[0]);
        }
        
        // O(N)
        for(auto vec : mp) {
            for(auto course : vec.second) {
                indegree[course]++;
            }
        }
        
        // O(N)
        queue<int> q;
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }
        
        // O(N)
        int check = 0;
        while(!q.empty()) {
            int top = q.front(); q.pop();
            check++;
            for(auto course : mp[top]) {
                indegree[course]--;
                if(indegree[course] == 0)
                    q.push(course);
            }
        }
        
        
        return check == numCourses;
        
        
    }
};