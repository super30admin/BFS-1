// Time Complexity :  O(v+e) 
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english

/* Topological Sort Approach.
 *
 * Maintain a vector to store indegrees of each node. Create a map to store node id as a key and vector of its childs. 
 * Push all the nodes with indegree zero in queue. Perform BFS operation. 
 * For each pop operation increment total course completed variable and reduce the indegree of its child nodes, 
 * if indegree of child is zero then push the node to queue.
 * When queue is empty if total is equal to numCourse then return true else return false.    
 */

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if (numCourses == 0)
            return true;
        
        int inDeg[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            inDeg[i] = 0;
        
        map<int, vector<int>> m;
        queue<int> q;
        int total = 0;
        
        for (auto ele : prerequisites)
        {
            inDeg[ele[0]]++;
            
            auto e = m.find(ele[1]);
            if (e != m.end())
            {
                e->second.push_back(ele[0]);
            }
            else
            {
                m.insert({ele[1], {ele[0]}});
            }
        }
        
        for (int i = 0; i < numCourses; i++)
        {
            if (inDeg[i] == 0)
                q.push(i);
        }
        
        while (!q.empty())
        {
            int c = q.front();
            q.pop();
            total++;
            
            auto ele = m.find(c);
            
            if (ele != m.end())
            {
                for (auto i : ele->second)
                {
                    inDeg[i]--;

                    if (inDeg[i] == 0)
                        q.push(i);
                }   
            }
        }
        
        return total == numCourses;
    }
};