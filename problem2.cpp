// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// this problem is having dependencies, so clearly, this a graph problem.
// we create adjacency list using map with key as independent items and values as dependent items.
// we  need to find acourse to start with which is completey indpendent of other courses. so we calculate an indegree array 
// to keep track of all course dependencies. 
// we start doing BFS using a queue by adding courses which have indegree values as zero  and then we reduce the values of
//  its dependent courses and proceed further by  adding remaining courses if their indegree becomes zero.
//  we keep track of number of items added to queue and after BFS ,check if count == Number of courses and return answer based on that.

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.empty() || prerequisites.size()==0) return true;
        vector<int>indegree(numCourses,0);
        unordered_map<int,vector<int>>map;
        for(auto p: prerequisites)
        {
            indegree[p[0]]++;
            if(map.find(p[1])==map.end())
            {
                vector<int>v;
                map.insert({p[1],v});
            }
            map[p[1]].push_back(p[0]);
        }
        queue<int>q;
        int cnt = 0;
        for(int i = 0;i<numCourses;i++)
        {
            if(indegree[i]==0){
                q.push(i);
                cnt++;
            }
        }
        while(!q.empty())
        {
            int curr = q.front();q.pop();
            for(int i = 0;i<map[curr].size();i++)
            {
                indegree[map[curr][i]]--;
                if(indegree[map[curr][i]] ==0){
                    q.push(map[curr][i]);
                    cnt++;
                }
            }
        }
        if(cnt == numCourses) return true;
        return false;
    }
};