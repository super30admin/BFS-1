// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
// We first create an adj list and and indegree array, then we push the nodes which have indegree = 0 into a queue for BFS (topological sort)
// When we process a node (pop it from the queue), we need to go over its neighbors and reduce their indegree by 1
// If the indegrees of any of these neighbors becomes 0, we put it in the queue for processing
// In the end, check if we could complete all the courses and return true/false accordingly

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // step 1: create adj list and build the indegree array
        unordered_map<int, vector<int>> adjList;
        vector<int> indegree(numCourses, 0);

        for(int i=0; i<prerequisites.size(); i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];

            adjList[parent].push_back(child);
            indegree[child]++;
        }

        // step 2: create a queue for BFS, insert all nodes/courses with indegree = 0 into the queue
        queue<int> q;
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }

        // step 3: process node & its children, while updating the indegree array
        int completed = 0;
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            completed++;
            for(int& child : adjList[node]) {
                indegree[child]--;
                if(indegree[child] == 0) {
                    q.push(child);
                }
            }
        }

        // step 4: check if we could complete all the courses or not
        if(completed != numCourses) return false;
        return true;
    }
};