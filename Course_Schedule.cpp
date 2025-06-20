//Time Complexity : O(v+e)
#include<iostream>
#include<vector>
#include<queue>
#include<unordered_map>
using namespace std;
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indeg(numCourses, 0);
        queue<int> q;
        int count = 0;
        unordered_map<int, vector<int>> hm;
        for(const auto& p : prerequisites){
            indeg[p[0]]++;
            hm[p[1]].push_back(p[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                q.push(i);
                count++;
            }
        }
        if(q.empty()) 
            return false;
        if(count == numCourses) 
            return true;
        while(!q.empty()){
            int curr = q.front(); 
            q.pop();
            if(hm.count(curr)){
                for(int x : hm[curr]){
                    indeg[x]--;
                    if(indeg[x] == 0){
                        q.push(x);
                        count++;
                        if(count == numCourses) 
                            return true;
                    }
                }
            }
        }
        return false;
    }
};