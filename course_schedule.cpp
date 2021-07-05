// Time Complexity :O(V + E) 
// Space Complexity : O(V + E)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) 
    {
        vector<int> indegree(numCourses,0);
        unordered_map<int, vector<int> > map1;
        int in,out;
        for(auto pre:prerequisites){
            in = pre[0];
            out = pre[1];
            map1[out].push_back(in);
            indegree[in]++;
        }
        
        queue<int> q;
        for(int i = 0;i<indegree.size();i++){
            if(indegree[i] ==0){
                q.push(i);
            }
        }
        
        if(q.size() == 0) return false;
        int count = 0;
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            count++;
            
            for(auto child:map1[curr]){
                indegree[child]--;
                if(indegree[child] ==0){
                    q.push(child);
                }
            }
        }
        if(count == numCourses){
            return true;
        }
        return false;
        
    }
};

