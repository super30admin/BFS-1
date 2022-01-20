//Time Complexity O(V+E)
// Space Complexity O(V+E)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;

class Solution {
    bool canFinish(int numCourses, vector<vector<int> >& prerequisites) {
        vector<int> indegrees(numCourses);
        map<int,vector<int> > adjList;
        
        for(auto &prereq : prerequisites)
        {
            indegrees[prereq[0]]++;
            vector<int> newVec;
            if(adjList.find(prereq[1])==adjList.end())
            {
                adjList[prereq[1]]={};
            }
            adjList[prereq[1]].push_back(prereq[0]);
        }
        
        queue<int> q;
        
        for(int i=0;i<indegrees.size();i++)
        {
            if(indegrees[i]==0)
            {
                q.push(i);
            }
        }
        while(!q.empty())
        {
            int frontElement=q.front();
            q.pop();
            
            vector<int> edges=adjList[frontElement];
            for(auto &edge:edges)
            {
                indegrees[edge]--;
                if(indegrees[edge]==0)
                {
                    q.push(edge);
                }
            }
        }
        
        for(auto &ele : indegrees)
        {
            if(ele>0)
            {
                return false;
            }
        }
        return true;
    }
};
