class Solution {
public:
    //TC-O(V+E)
    //SC-O(V+E)
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
       vector<vector<int>> graph(numCourses);
        vector<int>indegree(numCourses,0);
        queue<int> q;
        
        for(int i=0;i<prerequisites.size();i++){
            graph[prerequisites[i][1]].push_back(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        for(int i=0;i<indegree.size();i++){
            if(indegree[i]==0){
                q.push(i);
                numCourses--;
            }
        }
    while(!q.empty()){
        int temp=q.front();
        q.pop();
        for(auto p:graph[temp]){
            indegree[p]--;
            if(indegree[p]==0){
                q.push(p);
                numCourses--;
            }
        }
    }
        return numCourses==0;
    }
};