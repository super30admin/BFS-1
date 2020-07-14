// Time Complexity : O(n)
// Space Complexity : O(n) // Hashmap creation
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// Was stuck at implemeting it with hashset.
//Initially constructed hashmap with wrong key values
// Pushing into queue logic was incorrect.

// Your code here along with comments explaining your approach
//1. Create Hashmap key(Course that is pre-req) : vector value(Courses that can be done after pre-req)
//2. Fill a lookup array with number of pre-reqs per course and then add the courses into a queue with zero pre-req
//3. Add the elements into queue when the pre-req count is zero
//4. Iterate after all courses are covered in the queue to see if any course remains
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        //edge case
        if(prerequisites.size()==0) return true;
        
        unordered_map<int, vector<int>> course_map;
        vector<int> course_array(numCourses,0);
        //logic
        //Creating Hashmap with all the next courses we can take and the array with dependencies
        for(int i =0;i<prerequisites.size(); i++){
            course_map[prerequisites[i][1]].push_back(prerequisites[i][0]);
            course_array[prerequisites[i][0]] +=1; 
        }
        
        queue<int> myqueue;
        for(int i =0;i<numCourses; i++){
           if(course_array[i] == 0)   {
               myqueue.push(i);
           }
        }
        int size;
        while(!myqueue.empty()){
            int temp = myqueue.front();
            myqueue.pop();
            vector <int> children = course_map[temp];
            for (int i=0; i<children.size(); i++) {
                 course_array[children[i]] = course_array[children[i]] - 1;
                 if(course_array[children[i]]==0) myqueue.push(children[i]);
            }
        }
        for(int i =0;i<numCourses; i++){
            if(course_array[i] != 0) return false;
        }
        return true;
        }
};
