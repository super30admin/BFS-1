/*
Time Complexity:
O(V+E) 
*/
/*
Space Complexity:
O(V+E) where V is the number of courses and E is the number of dependencies.
*/

/*
Approach:
Top sort is used. First, we have to create an indegree vector to
determine if there is an independent course or not and 
how many dependencies each course has. After that we have to create
a hash map to store the dependent courses for each course 

This will help us in reducing the overhead of going again and again to find
that a course is dependent on how many courses.

After maintain the hash map we have tp create a queue in which we add only
those courses which are independent or their dependency in indegrees array
has been reduced to zero. 

So we start adding the elements in and look for its dependent courses in the
hash map. If it has dependent courses then their dependecy is reduced by 1. We also
check if the dependecy is reduced to 0 or not. If it is reduced to 0 it means 
it has become completely independent and can be finished. Every time we add 
an element to the queue we increment our count by 1. When this count is equal
to total number of courses, we get to know that all courses can be finished
*/


//The code ran perfectly on leetcode


class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        //keep count of the dependecies 
        vector<int> inDegrees(numCourses);
        
        //independent node key, dependent nodes values
        //maintain an adjacency list to know on a particular 
        //vertex which nodes are dependet
        unordered_map <int, vector<int>> adjLst; 
        for(auto edge: prerequisites){
            inDegrees[edge[0]]++; 
            //find in the map if the independent node exists or not
            // if not add it and for the values create a vector too
            if(adjLst.find(edge[1]) == adjLst.end()){
              adjLst[edge[1]] = vector<int> {};  
            } 
            adjLst[edge[1]].push_back(edge[0]);
        }
        
        queue<int> q;
        int finCourse = 0;
        for(int i =0; i<numCourses; i++){
            if(inDegrees[i] == 0){
                q.push(i);
                finCourse++;
            }
        }
        
        
        while(q.empty()==false && finCourse < numCourses){
            int curr = q.front();
            q.pop();
            vector<int> depCourse = adjLst[curr];
            if(depCourse.empty() ==false){
            for(auto child : depCourse){
                    inDegrees[child]--;
                    if(inDegrees[child]==0){
                        q.push(child);
                        finCourse++;
                    }
                    
                }
            }
        }
        
        if(finCourse == numCourses) return true;
        return false;
        
    }
};