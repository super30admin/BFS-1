/*
Time Complexity = O(V+E)
Space Complexity = O(V+E)
where V is the number pf courses and E is the dependencies.
*/
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size()==0)
            return true;
        
        //preparing the indegree array for each vertices.
        vector<int> indegree(numCourses,0);
        int i;
        for(i=0;i<prerequisites.size();i++)
            indegree[prerequisites[i][0]]++;
        
        //storing the dependencies in the map to efficiently access the courses dependent on that particular course.
        map<int, vector<int>> m;
        for(i=0;i<prerequisites.size();i++)
        {
            if(m.find(prerequisites[i][1])!=m.end())
                m[prerequisites[i][1]].push_back(prerequisites[i][0]);
            else
            {
                vector<int> z;
                z.push_back(prerequisites[i][0]);
                m[prerequisites[i][1]] = z;
            }
        }
        
        //using queue to check if we can undertake all the courses.
        
        queue<int> q;
        for(i=0;i<numCourses;i++)
            if(indegree[i]==0)
                q.push(i);
        if(q.size()==0)
            return false;
        int count=0;
        while(!q.empty())
        {
            int temp = q.front();
            q.pop();
            count++;
            vector<int> ans(m[temp]);
            if(ans.size()>0)
            {
                for(i=0;i<ans.size();i++)
                {   
                    indegree[ans[i]]--;
                    if(indegree[ans[i]]==0)
                        q.push(ans[i]);
                }
            }
        }
        cout<<count<<endl;
        return count==numCourses;
    }
};

/*
Time Complexity = O(V+E)
Space Complexity = O(V+E)
where V is the number pf courses and E is the dependencies.
*/
class Solution {
public:
    map<int, vector<int>> m;
        vector<bool> path;    //it contains the vertices you have seen so far.
        vector<bool> visited;     //it contains the vertices you have visited so far.
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size()==0)
            return true;
        
        //storing the dependencies in the map to efficiently access the courses dependent on that particular course.
        int i;
        for(i=0;i<numCourses;i++)
        {
            visited.push_back(false);
            path.push_back(false);
        }
        for(i=0;i<prerequisites.size();i++)
        {
            if(m.find(prerequisites[i][1])!=m.end())
                m[prerequisites[i][1]].push_back(prerequisites[i][0]);
            else
            {
                vector<int> z;
                z.push_back(prerequisites[i][0]);
                m[prerequisites[i][1]] = z;
            }
        }
        
        for(i=0;i<numCourses;i++)
        {
            if(!visited[i] && hascycle(i))
                return false;
        }
        return true;
    }
    
    bool hascycle(int i)
    {
         //base
         if(path[i])
             return true;
         if(visited[i])
             return false;
         
         //logic
         visited[i] = true;
         path[i] = true;
         vector<int> ans(m[i]);
         if(ans.size()!=0)
             for(int j=0;j<ans.size();j++)
                 if(hascycle(ans[j]))
                     return true;
        
        //backtrack
        path[i] = false;
        return false;
     }
};
