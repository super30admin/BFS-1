/*
Time complexity - O(V + E)
Space complexity - O(V + E)
*/
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indegrees(numCourses, 0);
        unordered_map<int, vector<int>> umap;
        for (int i = 0; i < prerequisites.size(); ++i){
            int in = prerequisites[i][0];
            int out = prerequisites[i][1];
            umap[out].push_back(in);
            ++indegrees[in];
        }
        queue<int> q;
        for (int i = 0; i < numCourses; ++i){
            if (indegrees[i] == 0) q.push(i);
        }
        if (q.empty()) return false;
        while (!q.empty()){
            int curr = q.front();
            q.pop();
            if (umap[curr].size() == 0) continue;
            for (auto c : umap[curr]){
                --indegrees[c];
                if (indegrees[c] == 0) q.push(c);
            }
        }
        for (int i = 0; i < numCourses; ++i){
            if (indegrees[i] != 0) return false;
        }
        return true;
    }
};