//Time Complexity-O(number of courses+No.of children)
//Space Complexity-O(hashmap size)
//Ran successfully on leetcode
//3 point algo-
	//have an indegree array to count the no. of prerequisites i.e. how many nodes come into a particular node
    //Then we have a hashmap to maintain the node the list of its prerequisites
    //If the indegree is 0, it measn that the course has no prerequisites and hence it can be taken first
    //We maintain a queue for our bfs approach so that we can pop the node with 0 prereq and push its children.
    //For every node we encounter in the queue, we reduce its count in the indegree array.
	//If the indegree array has all 0s in the end, then we can say that all the courses can be completed.

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {        
        int indegree[numCourses];
        unordered_map<int,vector<int>>m;
        for (int i = 0; i < numCourses; i++) // ...initialize it
            indegree[i] = 0;
        for(int i=0;i<prerequisites.size();i++)
        {
            indegree[prerequisites[i][0]]++;
            if(!m.count(prerequisites[i][1]))
                m.insert({prerequisites[i][1], {}});
            m[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        queue<int>q;
        for(int i=0;i<numCourses;i++)
            if(indegree[i]==0)
                q.push(i);
        while(!q.empty())
        {
            int course=q.front();
            q.pop();
            vector<int>children=m[course];
            if(!children.empty())
            {
                for(int child:children)
                {
                    indegree[child]--;
                    if(indegree[child]==0)
                        q.push(child);
                }
            }
        }
        for(int i=0;i<numCourses;i++)
            if(indegree[i]>0)
                return false;
        return true;
    }
};