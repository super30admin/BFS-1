class Solution {
//TC = O(V+E)
  
  public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size()==0) return true;
        vector<int> indegree(numCourses);
        unordered_map<int,vector<int>> map;
        for(auto edge: prerequisites){
            indegree[edge[0]]++;
            map[edge[1]].push_back(edge[0]);
        }
        int count=0;
        queue<int> q;
        for(int i=0;i<indegree.size();i++){
            if(indegree[i]==0){
                q.push(i);
                count++;   
            }
        }
        if(q.empty()) return false;
        while(!q.empty()){
            int curr = q.front(); q.pop();
            vector<int> edges = map[curr];
            if(edges.size()!=0){
                for(auto edge:edges){
                    indegree[edge]--;
                    if(indegree[edge]==0){
                        q.push(edge);
                        count++;
                        if(count==numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
};
