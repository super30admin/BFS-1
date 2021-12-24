//Time complexity : O(V + E)
//Space complexity : O(V + E)

//Approach :
            // Calculate indegrees of each vertex
            // Calculate adjacency list through pre-req array
            // Apply a bfs from the course that has 0 pre-requisites
            // If such course does not exist then its impossible to cover all the courses
            // Return if all the courses are covered through coursework
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(numCourses == 0)
            return true;
        
        vector<int> indegrees(numCourses, 0);
        map<int, vector<int>> adj_list;
        int coursesFinished = 0;
        
        for(auto prereq : prerequisites)
        {
            indegrees[prereq[0]]++;
            
            if(adj_list.find(prereq[1]) == adj_list.end())
            {
                adj_list.insert(pair<int,vector<int>>(prereq[1], vector<int>{}));
            }
            adj_list[prereq[1]].push_back(prereq[0]);
        }
        
        queue<int> q;
        for(int i = 0; i < indegrees.size() ; i++)
        {
            if(indegrees[i] == 0)
            {
                q.push(i);
            }
        }
        
        while(!q.empty())
        {
            int vertex = q.front();
            q.pop();
            coursesFinished++;
            if(adj_list.find(vertex) != adj_list.end())
            {
                vector<int> list = adj_list[vertex];
                if(list.size() > 0)
                {
                    for(int i : list)
                    {
                        indegrees[i]--;
                        if(indegrees[i] == 0)
                            q.push(i);
                    }
                }
            }
        }
        
        return coursesFinished == numCourses;
    }
};