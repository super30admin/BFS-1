TC:O(V+E)
SC:O(V+E)

// Topological sort Algorithm-->directed acyclic graph
// Here courses are vertices and pre-requisites are edges
// So,here [a,b] b course need to done before a course
// Converting this problem into a GRAPH problem

// By drawing graph with courses as vertices and preq's as edges directed from b to a
// So, to start with we a suject which has no pre-req but to know it for each sub from 0 to numcouses
//  ,I need to traverse prerequisites making it costly operation.
// So, I am choosing an indegree array in which I store pre-reqs quantity of each subject
// By traversing this indegree array I will get to know which course has no pre-req
// Now I know which subject has no pre-reqsuppose i.e., A now I need to check which subjects has A as pre-req
// For that I need to traverse again prereq's array for each subject and decrease the quantity in Indegree array 
// To optimise this I will use Graph Adjacency list representaion ,from this I will get to know for which subject it is a pre-req
// I will perform BFS by for doing above step of ,making elements of indegree array as zeros
// First push the courses with no pre-req into queue and traverse queue until it is empty and poping 
// elements whose indegree value is zero 

// At last if all elements in indegree array is zero only then a person can complete all courses without huddle
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

        //  courses are vertices
        // prereqs are edges
        
        if(numCourses==0) 
        return true;
        // stores how many pre-reqs each subject has or in [a,b] counting a occurences
        vector<int>indegrees(numCourses, 0);

        //  for(int i=0;i<prerequisites.size();i++)
        // {
        //     indegrees[prerequisites[i][0]]++;
        // }

       //Adjacency list-graph representation 

       unordered_map<int,vector<int>>graph;
       for(int i=0;i<prerequisites.size();i++)
        {
            int to=prerequisites[i][0];
            int from =prerequisites[i][1];
            if(graph.find(from)==graph.end())
            {
                vector<int>temp;
                graph[from]=temp;                               //O(Edges)
            }
             graph[from].push_back(to);

            // creating indegree array here moving from above
             indegrees[prerequisites[i][0]]++;
        }
       

        // Doing BFS 
        // finding the subject which does not have any pre-req
        queue<int>q;
        int count=0;

        for(int i=0;i<indegrees.size();i++)
        {
            if(indegrees[i]==0)
            {
            q.push(i);
            count++;
          
            }
        }
     
        // starting BFS
              
        while(!q.empty())
        {
           
            int tt=q.front();
            q.pop();
            
            vector<int>g=graph[tt];
        

            for(int i=0;i<g.size();i++)
            {
                
                indegrees[g[i]]--;
                if(indegrees[g[i]]==0)
                {
                    q.push(g[i]);
                    count++;
                }
            }
        }

      

        if(count==indegrees.size())
        return true;
        else
        return false;
   
    }
};