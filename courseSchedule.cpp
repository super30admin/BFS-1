// Time Complexity : O(V+E); v is number of vertices and E is number of edges
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain an indegrees array will contain number of prereq left to be taken for each index course
// 2. Maintain a queue which contains only those courses which can be taken now
// 3. Go through queue and reduce indegrees of dependent courses. Add a course to queue only if it has no prereq
// 4. At the end, return false if indegrees has any prereq left, else return true         

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(!prerequisites.size())
            return true;
        vector<int> indegrees(numCourses,0);
        map<int, vector<int>> hashmap;
        queue<int> q;
    
        // indegrees will contain number of prereq left to be taken for each index course
        for(auto pair: prerequisites){
            indegrees[pair[0]]++;
            hashmap[pair[1]].emplace_back(pair[0]);
        }
        // q contains only those courses which can be taken now
        // they will either have no prereq or their prereq must have been taken i.e. inserted
        // in the queue and popped
        for(int i=0; i<indegrees.size(); i++)
            if(indegrees[i] == 0)
                q.push(i);
        while(!q.empty()){
            int curr = q.front(); q.pop();
            if(hashmap.find(curr) != hashmap.end()){
                for(auto course: hashmap[curr]){
                    indegrees[course]--;
                    if(indegrees[course] == 0)
                        q.push(course);
                }
            }
        }
        
        for(auto course: indegrees)
            if(course!=0)
                return false;
        
        return true;
    }
};