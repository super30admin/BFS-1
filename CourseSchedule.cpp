class Solution {
    // TC - O(V+E)
    // SC - O(V+E) 
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indegree(numCourses,0);
        vector<vector<int>> graph(numCourses);
        for(vector<int> courseRelation :prerequisites ){
            indegree[courseRelation[0]]++;
                graph[courseRelation[1]].push_back(courseRelation[0]);
 
        }
        queue<int> independentCourses;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)  independentCourses.push(i);
        }
        int n = numCourses;
        while(independentCourses.size()!=0){
           vector<int> k = graph[independentCourses.front()];
           int i=0;
           while(k.size()!=i){
              indegree[k[i]]--;
              if(indegree[k[i]]==0) independentCourses.push(k[i]);
              i++;
           }
           independentCourses.pop();
           n--;
        }
        if(n>0) return false;
        return true;
        
    }
};