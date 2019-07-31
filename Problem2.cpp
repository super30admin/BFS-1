//
// Created by shazm on 7/30/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

// Runtime: O(V*E) V = vertices E = edges.
// Space: O(N)

using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int count = 0;
        queue<int> que;
        vector<int> indegree(numCourses,0);
        for(int x = 0; x<prerequisites.size(); x++){
            indegree[prerequisites[x][0]] = indegree[prerequisites[x][0]]+1;
        }
        for(int x = 0; x<indegree.size(); x++){
            if(indegree[x]==0){
                que.push(x); count+=1;
            }
        }
        if(que.empty()){return false;}
        int currQue;
        while(!que.empty() && count<=numCourses){
            currQue = que.front();
            for(int x = 0; x<prerequisites.size(); x++){
                if(prerequisites[x][1]==currQue){
                    indegree[prerequisites[x][0]] -= 1;
                    if(indegree[prerequisites[x][0]]==0){count+=1; que.push(prerequisites[x][0]);}
                }
            }
            que.pop();
        }
        if(count == numCourses){return true;}
        return false;
    }
};