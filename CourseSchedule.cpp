//Time Complexity: 
// Space Complexity: 

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> color(numCourses, 0);
        vector<vector<int>> adj(numCourses);

        if(numCourses == 0 or numCourses == 1) return true;

        for(int i = 0; i < prerequisites.size(); i++){
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }

        for(int v = 0; v < numCourses; v++) {
            if(color[v] == 0) {
                if(isCycle(adj, color, v)) return false;
            } 
        }

        return true;     
    }

    bool isCycle(vector<vector<int>>& adj, vector<int>& color, int vertex) {
        
        if(color[vertex] == 1) return true; 
        
        color[vertex] = 1;

        for(int i : adj[vertex]) {
            if(color[i] != 2) {
                if(isCycle(adj, color, i)) return true; 
            }
        }

        color[vertex] = 2; 
        return false;   
    }
};