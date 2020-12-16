// Time Complexity : O(E+V)
// Space Complexity : O(E+V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : A LOT

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(numCourses == 0){
            return true;
        }
        vector<int> indegree(numCourses);
        map<int, vector<int>> _map;
        vector<int> newList;
        
        for(int i=0;i<prerequisites.size();i++){
            indegree[prerequisites[i][0]]++;
            if(_map.find(prerequisites[i][1])==_map.end()){
                _map.insert(pair<int, vector<int>>(prerequisites[i][1], newList));
            }
            _map[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        queue<int> q;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.push(i);
            }
        }
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            vector<int> children = _map[curr];
            if(children.size()>0){
                for(int child:children){
                    indegree[child]--;
                    if(indegree[child]==0){
                        q.push(child);
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]>0){
                return false;
            }
        }
        return true;
    }
};
