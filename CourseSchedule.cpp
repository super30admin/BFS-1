// Time Complexity : O(n) or O(V + E)
// Space Complexity : O(n) or O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> frequency(numCourses,0);
        map<int ,vector<int>> myhash;
        
        // corner case
        if (prerequisites.size() == 0) return true;
        
        // creating course array and loading the hashmap with dependent courses.
        for (vector<int> i : prerequisites){
            int temp = i[0];
            frequency[temp] +=1;
          
            myhash[i[1]].push_back(temp);  
        }
        
        queue <int> myqueue;
        // adding the courses with 0 prereq to the queue.
        for ( int i = 0; i < frequency.size(); i++){
            if(frequency[i]==0)
                myqueue.push(i);
        }
        
        // if there are no courses without prereq. then we cannot coomplete the course.
        if(myqueue.size() == 0) return false;
        
        while(!myqueue.empty()){
             int fron = myqueue.front();
             myqueue.pop();
            if(myhash.find(fron) != myhash.end()){
                 for (int i : myhash[fron]){
                frequency[i] -=1;
                if(frequency[i] == 0){
                    myqueue.push(i);
                }
            }
            
                
            }
           
        }
        
        for (int i =0; i <frequency.size() ; i++){
            if(frequency[i] != 0) return false;
        }
        
      return true;  
    }
};