// # Problem 2
// Course Schedule (https://leetcode.com/problems/course-schedule/


//Did this code run on leetcode :Yes
//TC - O(V+E)
//SC - O(V+E)

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        if(numCourses ==0){
            return true;
        }
        
        vector<int> inDegree(numCourses, 0);
        
        unordered_map< int, vector<int>> m1;
        
        for(int i = 0 ; i< prerequisites.size(); i++){
            inDegree[ prerequisites[i][0]]++;
            
             m1[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        
        queue<int> q1;
        
        for(int i=0 ; i< numCourses; i++){
            
            if( inDegree[i]==0){
                q1.push( i);
            }
        }
        
        while(!q1.empty()){
            int curr = q1.front();
            q1.pop();
            
            vector<int> children = m1[curr];
            
            if( children.size() != 0){
                
                for(int j=0; j< children.size(); j++){
                    inDegree[children[j]]--;
                    if(inDegree[children[j]] ==0){
                        q1.push( children[j]);
                    }
                }
            }
        }
        
        for(int i=0 ; i< numCourses; i++){
            if(inDegree[i]!=0){
                return false;
            }
        }
        
        return true;
        
        
    }
    
    
    
};