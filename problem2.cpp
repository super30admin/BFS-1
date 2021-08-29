//Time Complexity - O(V+E)
//Space Complexity - O(V+E)
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size()==0)
            return true;
        vector<int> indegree(numCourses);
        unordered_map<int,vector<int>>mp;
        for(auto edge : prerequisites){
            indegree[edge[0]]++;
            mp[edge[1]].push_back(edge[0]);
        }
        queue<int>q;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.push(i);
            }
        }
        if(q.size()==0)
            return false;
        int cnt=0;
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            cnt++;
            vector<int>edges = mp[curr];
            if(edges.size()!=0){
                for(int edge : edges){
                    indegree[edge]--;
                    if(indegree[edge]==0)
                        q.push(edge);
                }
            }
        }
        return cnt==numCourses;
    }
};