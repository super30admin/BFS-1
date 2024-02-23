// TC = O(V + E)
//  SC = O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    // TC = O(V + E), SC = O(V + E)
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // null
        if(prerequisites.size() == 0) return true;
        vector<int> indegrees(numCourses);
        unordered_map<int, vector<int>> map;
        for(vector<int> edge: prerequisites) { // O(E), 
            indegrees[edge[0]]++; // calculating the dependencies for each course 
            map[edge[1]].push_back(edge[0]); // create list in map for adjacencylist&adding dependecies
        }
        queue<int> q;
        int count = 0;
        for(int i = 0; i <numCourses; i++) {
            if(indegrees[i] == 0) {
                q.push(i); // adding vertices in q who has no dependencies & are ready to process
                count++;
            }
        }
        while(!q.empty()) {
            int curr = q.front();
            q.pop();
            // indegrees of dependent nodes
            vector<int> li(map[curr]); // getting the list of dependent courses on curr
            if(li.size() != 0) {
                for(int edge: li) {
                    indegrees[edge]--; // as its processed reduce dependencies of dependent crs by 1
                    if(indegrees[edge] == 0) {
                        q.push(edge);
                        count++; // no dependency, add in q & increase the count
                    }
                }
            }
        }
        return (count == numCourses);
    }
};