//Time O(n)
//Space O(n)
//Leetcode : yes
//issue seen: none

class Solution {
public:
    bool dfs(vector<vector<int>> &adj, int node, vector<int> &visited) {

         visited[node] = 1;

         for(int i=0; i<adj[node].size(); i++) {
            if (visited[adj[node][i]] == 1) {
                return false;
            }  
            if(visited[adj[node][i]] == 0){
                if(!dfs(adj, adj[node][i], visited)){
                    return false;
                }
            }
         }
         visited[node] = 2;
         return true;
    }

    bool canFinish(int n, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(n);
        vector<int> visited(n, 0);

        for(int i=0; i<prerequisites.size(); i++){
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                if(!dfs(adj,i,visited)){
                    return false;
                }

            }
        }
        return true;
    }
};
