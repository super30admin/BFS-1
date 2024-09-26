class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int indegrees[numCourses];
        
        for(int i=0;i<prerequisites.size();i++)
        {
            indegrees[prerequisites[i][0]]++;
        }
        queue<int> queue1;
        
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]==0)
            {
                queue1.push(i);
            }
        }
        int counter=queue1.size();
        
        while(!queue1.empty())
        {
            int a;
            a=queue1.front();
            queue1.pop();
            
            for(int i=0;i<prerequisites.size();i++)
            {
                if(prerequisites[i][1]==a)
                {
                    indegrees[prerequisites[i][0]]--;
                    if( indegrees[prerequisites[i][0]]==0)
                    {
                        queue1.push(prerequisites[i][0]);
                            counter++;
                    }
                }
            }
        }
        
        if(counter==numCourses)
        {  
            return true;
        }
        else
            return false;
        
    }
};