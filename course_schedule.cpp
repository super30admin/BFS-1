
// Time Complexity : O(V+E) where V represents the vertices and E represents the edges
// Space Complexity : O(V) where V represents the no.of vertices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/course-schedule/
// Submission Link: https://leetcode.com/submissions/detail/541211973/

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int> > graph(numCourses);
        for(int i = 0; i < prerequisites.size(); i++){
            graph[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        
        vector<bool> path(numCourses, false);
        vector<bool> visited(numCourses, false);
        
        for(int i = 0; i < numCourses; i++){
            stack<int> s;
            s.push(i);
            path[i] = true;
            visited[i] = true;
            
            while(!s.empty()){
                int top = s.top();
                
                for(int j = 0; j < graph[top].size(); j++){
                    if(path[graph[top][j]])
                        return false;
                    else if(!visited[graph[top][j]]){
                        s.push(graph[top][j]);
                        path[graph[top][j]] = true;
                        visited[graph[top][j]] = true;
                        break;
                    }
                }
                
                if(top == s.top()){
                    path[top] = false;
                    s.pop();
                }
            }
        }
        
        return true;
    }
};