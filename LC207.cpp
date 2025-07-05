
// Time Complexity O(v+e)
// Space Complexity O(v+e)

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

        unordered_map<int, vector<int>> adjacency;
        vector<int> indegree(numCourses, 0);
        for (const auto edge : prerequisites)
        {
            int a = edge[0];
            int b = edge[1];
            indegree[a]++;
            adjacency[b].push_back(a);
        }

        queue<int> que;
        for (int i=0; i<numCourses; i++)
        {
            if (indegree[i] == 0)
            {
                que.push(i);
            }
        }

        int count = 0;
        while(!que.empty()) {
            int vertex = que.front();
            que.pop();
            const auto& neighbors = adjacency[vertex];
            for (auto neighbor : neighbors)
            {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                {
                    que.push(neighbor);
                }
            }
            count++;
        }

        return count == numCourses;
    }
};