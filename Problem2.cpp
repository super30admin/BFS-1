// Time Complexity :O(V + E) where V is the number of vertices and E is the number of edges
// Space Complexity : O(V + E)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Course Schedule 

#include<vector>
#include<iostream>
#include<queue>
#include<unordered_map>

using namespace std;
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> inDegree(numCourses,0);
        unordered_map<int,vector<int>> m1;
        queue<int> q1;
        int in,out;
        for(auto pre: prerequisites){
            in = pre[1];
            out = pre[0];
            m1[out].push_back(in);
            inDegree[in]++;
        }
        
        for(int i = 0; i < inDegree.size(); i++){
            if(inDegree[i] == 0)
                q1.push(i);
        }
        if(q1.empty()) return false;
        int temp;
        while(!q1.empty()){
            temp = q1.front();
            q1.pop();
            for(auto c : m1[temp]){
                inDegree[c]--;
                if(inDegree[c] == 0) q1.push(c);
            }
        }
        for(int j : inDegree){
            if(j != 0) return false;
        }
        return true;
    }
};