// Time Complexity - O(n), since we are processing a total of 'n' nodes in the input tree.
// Space Complexity - O(n), since at max we can have a total of 'n/2' elements in the queue.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size() == 0)
            return true;
        vector<int> indegrees(numCourses);
        unordered_map<int, vector<int>> map;
        for(vector<int>& edge : prerequisites){
            indegrees[edge[0]]++;
            if(!map.count(edge[1])){
                vector<int> d;
                map[edge[1]] = d;
            }
            map[edge[1]].push_back(edge[0]);
        }
        
        queue<int> q;
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.push(i);
                count++;
            }
        }
        
        while(!q.empty()){
            int curr = q.front(); q.pop();
            vector<int> v = map[curr];
            if(v.size() != 0){
                for(int edge: v){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.push(edge);
                        count++;
                        if(count == numCourses)
                            return true;
                    }
                }
            }
        }
        return false;
    }
};