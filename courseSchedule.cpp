// Time Complexity : O(E + V) the total edges are processed within the v vertices, thats why its + and not *
// Space Complexity : O(E + V) indegrees and q -> v and adj_list is v
// Did this code successfully run on Leetcode : Yes 

//Approach 1: BFS

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size() == 0) return true;
        //array: to keep count of nodes that depends on that course
        //map: to see what nodes it is a prereq of aka adjacency list
        //0 : [2, 3] = 2 & 3 depends on 0 
        vector<int> indegrees(numCourses, 0);
        unordered_map<int, vector<int>> adj_list;
        queue<int> q;
        // int  coursesLeft = numCourses;

        for (auto edge: prerequisites){
            indegrees[edge[0]]++;
            adj_list[edge[1]].push_back(edge[0]);
        }

        for(int i=0; i<numCourses; i++){
            if(indegrees[i]==0)
                q.push(i);
        }
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            // coursesLeft--;
            if(adj_list.find(curr) != adj_list.end()){
                auto dependants = adj_list[curr];
                for(int n:dependants){
                    indegrees[n]--;
                    if(indegrees[n] == 0)
                        q.push(n);
                }
            }   
        }
        // return (!coursesLeft);
        return(!reduce(indegrees.begin(), indegrees.end()));
    }
};