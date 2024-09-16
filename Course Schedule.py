# Time Complexity:- O(V+E)
# Space Complexity:- O(V+E)
# Approach:- Create the graph and create an indegrees array which marks a node has how many incoming edges. If the number of edges of edges in the indegrees array is 0 we can include that in our next course to take. We traverse the graph this way and in the end check our indegree array if any node has more than 1 incoming edge, if there is such an edge then it is not possible to take all the courses.
import collections

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g=collections.defaultdict(list)
        indegrees=[0]*numCourses
        for i,j in prerequisites:
            # create the graph
            g[j].append(i)
            # create the indegrees array
            indegrees[i]+=1
        # maintain a queue which will tell us which is the next course to take
        q=collections.deque([])
        for i,v in enumerate(indegrees):
            # if the indegrees of this node is 0 we can take this course
            if v==0:
                q.append(i)
        while(q):
            node=q.pop()
            if node not in g:
                continue
            for i in g[node]:
                # everytime we visit a node we can reduce the indegrees of it by 1
                indegrees[i]-=1
                # if the indegree of the node becomes 0 we can now take this course 
                if indegrees[i]==0:
                    q.append(i)
        # if the indegrees of a node is not 0 we can't take all the courses
        for i in indegrees:
            if i!=0:
                return False
        return True
        