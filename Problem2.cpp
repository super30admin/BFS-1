// Time Complexity : O(E+V)  // not sure tbh
// Space Complexity : O(E+V) // slightly confused
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some, got it checked


// Your code here along with comments explaining your approach

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>> m1;
        vector<int> v1(numCourses, 0);
        queue<int> q;
        
        // creating the adjacency list and topological sort array
        for(auto i : prerequisites){
            v1[i[0]]++;
            m1[i[1]].push_back(i[0]);
        }
        
        // pushing elements with no dependencies in q
        for(int i = 0; i<numCourses; i++){
            if(v1[i] == 0) q.push(i);
        }
        if(q.empty()) return false; // if no dependencies return false
        
        while(!q.empty()){
            int p = q.front();  // get the no dependency element, that course is done
            q.pop();
           
            for(int i=0; i<m1[p].size(); i++){
                    v1[m1[p][i]]--;   // after the course is done, remove the dependency of nodes dependent on this node
                    if(v1[m1[p][i]] == 0){ 
                        q.push(m1[p][i]);  // push into queue if no dependency
                    }
                }
            
        }
        for(int i =0; i<numCourses; i++){
            if(v1[i] > 0) return false;  // if still courses remaining return false
        }
        return true;
    }
};

// int main(){
    
//     return 0;
// }