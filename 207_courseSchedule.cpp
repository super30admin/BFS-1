// Time Complexity : O(V+E) where V is vertex and E is edges.
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//DFS

class Solution {
public:
    unordered_map<int, vector<int>> map;
    vector<bool> path;
    vector<bool> visited;
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.empty() || prerequisites.size() == 0){
            return true;
        }
        path.resize(numCourses);
        visited.resize(numCourses);
        for(vector<int> edge : prerequisites){
            if(map.find(edge[1]) != map.end()){
                vector<int> x;
                map.insert({edge[1], x});
            }
            map[edge[1]].push_back(edge[0]);
        }
        for(int i=0; i<numCourses; i++){
            if(!visited[i] && hasCycle(i)){
                return false;
            }
        }
        return true;
    }
    bool hasCycle(int i){
        //base
        if(path[i])
            return true;
        if(visited[i])
            return false;
        //logic
        visited[i] = true;
        path[i] = true;
        vector<int> edges = map[i];
        if(!edges.empty()){
            for(int edge: edges){
                //recursive statement
                if(hasCycle(edge))
                    return true;
            }
        }
        //backtrack
        path[i] = false;
        return false;
    }
};

// Time Complexity : O(V+E) where V is vertex and E is edges.
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//BFS

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.empty() || prerequisites.size() == 0){
            return true;
        }
        unordered_map<int, vector<int>> map;
        vector<int> indegrees;
        indegrees.resize(numCourses, 0);
        for(vector<int> edge : prerequisites){
            indegrees[edge[0]]++;
            if(map.find(edge[1]) != map.end()){
                vector<int> x;
                map.insert({edge[1], x});
            }
            map[edge[1]].push_back(edge[0]);
        }
        queue<int> q;
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                q.push(i);
            }
                
        }
        if(q.size() == 0)
            return false;
        int cnt=0;
        while(!q.empty()){
            int curr = q.front();
            q.pop();
            cnt++;
            vector<int> edges = map[curr];
            if(!edges.empty()){
                for(int edge: edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.push(edge);
                    }
                }
            }
        }
        return (cnt==numCourses);
    }
};
