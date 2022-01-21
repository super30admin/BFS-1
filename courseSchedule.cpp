// Time Complexity : O(vertices+edges))
// Space Complexity : O(vertices+edges)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

#include <queue>
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<int> indices(numCourses,0);
        map<int, vector<int>> map1;
        
        for(auto ele : prerequisites){
            indices[ele[0]]++;
            if(map1.find(ele[1]) != map1.end()){
                map1.insert({ele[1],{}});
            }
                map1[ele[1]].push_back(ele[0]);
        }
        
        queue<int> q1;
        int count=0;
        for(int i=0; i < numCourses; i++){
            if(indices[i]==0){
                 cout << indices[i] << endl;
                q1.push(i);  count++;
            }
        }
        
        if(q1.empty()){ 
            return false;
        }
        while(!q1.empty()){
            int curr = q1.front(); 
           
            q1.pop();
            vector<int> temp = map1[curr];
            for(auto ele : temp){
                indices[ele]--;
                if(indices[ele]==0){
                    q1.push(ele); count++;
                }
            }
        }
        if(count == numCourses) return true;
        
        return false;
        }
    };

