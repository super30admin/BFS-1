//Time Complexity- O(V+E)
//Space Complexity- O(V+E)

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
    
        if(prerequisites.size()==0){
            return true;
        }
        
        vector<vector<int>> graph(numCourses);
        for(auto vec:prerequisites){
            graph[vec[1]].push_back(vec[0]);
        }
        
        vector<bool> visited(numCourses,false);
        vector<int> recStack(numCourses,false);
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==false){
                if(dfsCycle(i,graph,visited,recStack)==true){
                    return false;
                }
            }
        }
        return true;
    }
    
    bool dfsCycle(int node,vector<vector<int>> &graph,vector<bool> &visited,vector<int> &recStack){
        
        visited[node]=true;
        recStack[node]=true;
        
        for(int neighbour:graph[node]){
            if(visited[neighbour]==false){
                if(dfsCycle(neighbour,graph,visited,recStack)==true){
                    return true;
                }
            }
            else if(recStack[neighbour]){
                return true;
            }
        }
        
        recStack[node]=false;
        return false;
    }
};