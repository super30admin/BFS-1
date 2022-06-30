# Time Complexity: O(E)
# Space Complexity: O(E)
# where E is edges in the graph (dependency list)

from collections import deque


class Solution:
#  BFS Solution --->
#  We visualize the problem as a directed graph, and consider the 
#  prerequisites to be dependencies/edges of that graph. For each node(course) in this graph, the number of prereqs is equal
#  to the indegree at that node. We will then calculate the indegrees of all the nodes, and also create a map of all the 
#  dependencies between the nodes. For each course, we check it's dependencies, and which nodes are dependent on it as well.
#  Accordingly, we will select nodes with no dependencies, and as we select them, we will reduce the indegrees of its dependent 
#  nodes as well. This will be done over all the nodes of the graph. 
    def canFinish(self, numCourses, prerequisites):
        if numCourses == 0 or len(prerequisites)==0:
             return True
        
        indegree= [0]* numCourses
        adj = {}

     # this will calculate the  indegrees of each node, as well as creating the dependency map
        for dep, indep in prerequisites: 
            indegree[dep]+=1
            if indep in adj: 
                 adj[indep].append(dep)
            else:
                 adj[indep]=[dep]
        q = deque() 
        count = 0
         
        for i,k in enumerate(indegree):
          # Initially we add all the nodes with indegree 0 in the queue, which signifying that we have taken that course
             if k==0:
                q.append(i)   
                count+=1
          
        while q: 
            course = q.popleft()
            if course in adj: 
                 for dep in adj[course]: 
                    indegree[dep]-=1
                    if indegree[dep]==0: 
                        q.append(dep) 
                        count+=1 

        return count == numCourses  

obj = Solution()
print(obj.canFinish(2,[[1,0],[0,1]]))
            