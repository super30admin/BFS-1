// 207. Course Schedule
// Time Complexity : O(v+e)
// Space Complexity :O(v+e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    iterates through the prerequisites to create a dependency map and a dependency count for each course,
    then uses a queue to track courses with no dependencies, progressively reducing dependency counts until 
    all courses are accounted for or a cyclic dependency is detected.    
*/

bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>> dmap;
        vector<int> dep(numCourses);
        queue<vector<int>> q;
        int c = 0;
        for(int i = 0 ; i < prerequisites.size(); i++)
        {
            if(prerequisites[i][0] == prerequisites[i][1])
                return false;
            dmap[prerequisites[i][1]].push_back(prerequisites[i][0]);
            dep[prerequisites[i][0]]++;
        }
        for(int i = 0; i < numCourses; i++)
        {
            if(dep[i] == 0)
            {
                c++;
                q.push(dmap[i]);
            }
        }
        while(!q.empty())
        {
            vector<int> n = q.front();

            for(int i = 0; i < n.size(); i++)
            {
                dep[n[i]]--;
                if (dep[n[i]] == 0)
                {
                    c++;
                    q.push(dmap[n[i]]);
                }
            }
            q.pop();   
        }
        if (c == numCourses)
            return true;
        return false;        
    }