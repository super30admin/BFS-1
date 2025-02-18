// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store the indgree and dependent nodes in a map.
// Push the nodes with 0 indegree into a queue, and find all the dependent nodes.
// Reduce the indgree of the dependent nodes and increase the count.
// If count is equal to num of courses return true else false


class Solution {
    public:
        bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
            map<int, vector<int>> mp;
            queue<int> q;
            vector<int> indegree(numCourses,0);
            int cnt=0;
            for(auto i:prerequisites){
                indegree[i[0]]++;
                mp[i[1]].push_back(i[0]);
            }
            for(int i=0; i<numCourses; i++){
                if(indegree[i] == 0){
                    q.push(i);
                    cnt++;
                }
            }
            if(cnt == numCourses) return true;
            if(q.empty()) return false;
            while(!q.empty()){
                int curr = q.front();
                q.pop();
                vector<int> res = mp[curr];
                if(mp.find(curr) != mp.end()){
                    for(auto i:res){
                        indegree[i]--;
                        if(indegree[i] == 0){
                            q.push(i);
                            cnt++;
                            if(cnt == numCourses) return true;
                        }
                    }
                }
            }
            return false;
    
        }
    };