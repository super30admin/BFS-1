/*
Time: O(N)
Space: O(N)

If there's a cycle, finishing all courses are not possible
Otherwise, possible.
*/

class Solution {
public:
    vector<int> vis;
    
    bool isCycle(int u, vector<vector<int>>& v){
      if(vis[u]==1)  return true;
      if(vis[u]==2)  return false;

      vis[u] = 1;

      for(auto adj: v[u]){
        bool cycle = isCycle(adj, v);
        if(cycle)  return true;
      }

      vis[u] = 2;
      return false;   
    }

    bool canFinish(int n, vector<vector<int>>& pre) {
        vector<vector<int>> v(n,vector<int>());
        vis = vector(n, 0);

        for(auto p: pre){
          v[p[0]].push_back(p[1]);
        }

        for(int i=0;i<n;i++){
          if(isCycle(i,v))  return false;
        }

        return true;
    }
};
