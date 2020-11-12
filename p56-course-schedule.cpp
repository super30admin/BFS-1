// Time complexity is O(V + E) - V = #courses; E = #edges (links between courses)
// Space complexity is O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:

/*
    1. Indegree of each vertex(course) is maintained in the indegree vector.
    2. A map is used to maintain list of all edges representing the outdegree of a vertex.
        key = a course ; value = list of courses dependent of the key(list of verices which contribute to the outdegree of key.
    3. When indegree of avertex is zero, it implies that it is an independent vertex.
       An independent vertex implies that the course can be taken.
       So, we add all such independent vertices(courses) in the queue.
    4. Now, popping an element from the queue => completing the course. So, by performing BFS, we find all the courses who are
       prerequisites to the courses in the queue, and then reduce counts of those in the indegree vector. Once a course becomes
       independent(all prerequesisties are completed) or it's indegree value = 0, we add it to the queue.
    5. Once the queue becomes empty, and if all courses are taken, we return true, or else we return false.
 */

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indegree(numCourses, 0);
        unordered_map<int, vector<int>> map;
        queue<int> q;
        for(int i = 0; i < prerequisites.size(); i++) {
            indegree[prerequisites[i][0]]++;
            
            if(map.find(prerequisites[i][1]) == map.end()) {
                vector<int> temp;
                temp.push_back(prerequisites[i][0]);
                map[prerequisites[i][1]] = temp;
            }
            else {
                map[prerequisites[i][1]].push_back(prerequisites[i][0]);
            }
        }
        
        // pushing all independent courses into the queue
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }
        
        while(!q.empty()) {
            int currCourse = q.front();
            q.pop();
            for(int i = 0; i < map[currCourse].size(); i++) {
                indegree[map[currCourse][i]]--;
                if(indegree[map[currCourse][i]] == 0)
                    q.push(map[currCourse][i]);
            }
        }
        /* If a course is not completed => it's prerequisities are still not completed (it's indegree != 0),
           then we can say that we couldn't finish all courses and hence return false.
         */
        for(int i = 0; i < indegree.size(); i++) {
            if(indegree[i]) return false;
        }
        return true;
    }
};
