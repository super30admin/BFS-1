//Time - O(numCourses)
//Space - O(numCourses)

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        unordered_map<int, vector<int>> adj;
        vector<int> inDeg(numCourses,0);
        queue<int> q;
        
        for(auto v:prerequisites){
            inDeg[v[0]]++; 
            adj[v[1]].push_back(v[0]);
        }
        
        for(auto i = 0;i<inDeg.size();i++){
            if(inDeg[i]== 0) q.push(i);
        }
        
        int node;
        
        while(!q.empty()){
           node = q.front();q.pop();numCourses--; 
            for(auto i:adj[node]){
                inDeg[i]--;
                if(inDeg[i] == 0) q.push(i);
            }
        }
        
        return numCourses == 0;
    }
};