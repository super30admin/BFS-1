// Time Complexity :O(V+E)
// Space Complexity :O(V+E)
// V-> Number of vertex E - Number of Edges
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

        vector<int> count(numCourses,0);
        unordered_map<int,vector<int>> map;
        queue<int> q;

        for(int i=0;i<prerequisites.size();i++){
            count[prerequisites[i][0]]++;
            map[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }


        for(int i=0;i<count.size();i++){
            if(count[i] == 0){
                q.push(i);
            }
        }

        while(!q.empty()){
            int sub = q.front();
            q.pop();
            for(auto it:map[sub]){
                count[it]--;
                if(count[it] ==0)
                    q.push(it);
            }
        }
        for(int i=0;i<count.size();i++){
            if(count[i]>0){
                return false;
            }
        }
        return true;

    }
};
